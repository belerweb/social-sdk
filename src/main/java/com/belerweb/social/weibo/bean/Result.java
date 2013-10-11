package com.belerweb.social.weibo.bean;

import org.json.JSONObject;

import com.belerweb.social.weibo.WeiboException;


public class Result<T> {

  private Error error;
  private T result;

  protected Result(Error error) {
    this.error = error;
  }

  protected Result(T result) {
    this.result = result;
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

  public static <T> Result<T> perse(JSONObject jsonObject, Class<T> cls) {
    Error error = Error.parse(jsonObject);
    if (error == null) {
      try {
        @SuppressWarnings("unchecked")
        T obj = (T) cls.getMethod("parse", JSONObject.class).invoke(null, jsonObject);
        return new Result<T>(obj);
      } catch (Exception e) {
        throw new WeiboException(e);
      }
    }

    return new Result<T>(error);
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
