package com.belerweb.social.weibo.bean;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.belerweb.social.weibo.WeiboException;


public class Result<T> {

  private Error error;
  private T result;
  private List<T> results;

  protected Result(Error error) {
    this.error = error;
  }

  protected Result(T result) {
    this.result = result;
  }

  protected Result(List<T> results) {
    this.results = results;
  }

  public boolean success() {
    return error == null;
  }

  public Error getError() {
    return error;
  }

  public T getResult() {
    return result;
  }

  public List<T> getResults() {
    return results;
  }

  @SuppressWarnings("unchecked")
  public static <T> Result<T> perse(String json, Class<T> resultType) {
    try {
      Method parse = resultType.getMethod("parse", JSONObject.class);

      if (json.matches("^\\s*[.*$")) {
        List<T> list = new ArrayList<T>();
        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
          list.add((T) parse.invoke(null, jsonArray.getJSONObject(i)));
        }
        return new Result<T>(list);
      } else {
        JSONObject jsonObject = new JSONObject(json);
        Error error = Error.parse(jsonObject);
        if (error == null) {
          T obj = (T) parse.invoke(null, jsonObject);
          return new Result<T>(obj);
        }
        return new Result<T>(error);
      }

    } catch (Exception e) {
      throw new WeiboException(e);
    }

  }

  public static String toString(Object obj) {
    if (obj == null) {
      return null;
    }

    return obj.toString();
  }

  public static Long perseLong(Object obj) {
    if (obj == null) {
      return null;
    }

    Long result = null;
    if (obj instanceof Number) {
      result = ((Number) obj).longValue();
    } else if (obj instanceof String) {
      result = Long.valueOf((String) obj);
    }

    return result;
  }

  public static Integer perseInteger(Object obj) {
    if (obj == null) {
      return null;
    }

    Integer result = null;
    if (obj instanceof Number) {
      result = ((Number) obj).intValue();
    } else if (obj instanceof String) {
      result = Integer.valueOf((String) obj);
    }

    return result;
  }

  public static Boolean perseBoolean(Object obj) {
    if (obj == null) {
      return null;
    }

    Boolean result = null;
    if (obj instanceof Boolean) {
      result = (Boolean) obj;
    } else if (obj instanceof String) {
      result = Boolean.valueOf(obj.toString());
    }

    return result;
  }

}
