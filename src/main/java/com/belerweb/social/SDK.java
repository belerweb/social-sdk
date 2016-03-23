package com.belerweb.social;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import com.belerweb.social.bean.Error;
import com.belerweb.social.bean.Result;
import com.belerweb.social.exception.SocialException;
import com.belerweb.social.http.Http;
import com.belerweb.social.http.HttpException;

public abstract class SDK {

  private final Charset defaultCharset;

  public SDK() {
    this(null);
  }

  public SDK(Charset defaultCharset) {
    this.defaultCharset = defaultCharset;
  }

  public String get(String url, List<NameValuePair> params) {
    try {
      Http.setDefaultCharset(defaultCharset);
      return Http.get(url, params);
    } catch (HttpException e) {
      throw new SocialException(e);
    }
  }

  public String get(String url) {
    return get(url, null);
  }

  public String post(String url, HttpEntity postBody) {
    try {
      Http.setDefaultCharset(defaultCharset);
      return Http.post(url, postBody);
    } catch (HttpException e) {
      throw new SocialException(e);
    }
  }

  public String post(String url, List<NameValuePair> params) {
    try {
      Http.setDefaultCharset(defaultCharset);
      return Http.post(url, params, "UTF-8");
    } catch (HttpException e) {
      throw new SocialException(e);
    }
  }

  public String post(String url) {
    return post(url, (HttpEntity) null);
  }

  public void addParameter(List<NameValuePair> params, String name, Object value) {
    if (value == null) {
      throw new SocialException("Parameter " + name + " must not be null.");
    }
    params.add(new BasicNameValuePair(name, value.toString()));
  }

  public void addNotNullParameter(List<NameValuePair> params, String name, Object value) {
    if (value != null) {
      params.add(new BasicNameValuePair(name, value.toString()));
    }
  }

  public void addTrueParameter(List<NameValuePair> params, String name, Boolean value) {
    if (Boolean.TRUE.equals(value)) {
      params.add(new BasicNameValuePair(name, value.toString()));
    }
  }

  /**
   * 经纬度转换为地址
   * 
   * @param lon 经度
   * @param lat 纬度
   */
  public Result<String> lonLatToAddress(Double lon, Double lat) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    addParameter(params, "sensor", "false");
    addParameter(params, "language", "zh");
    addParameter(params, "latlng", lat + "," + lon);
    String json = get("https://maps.googleapis.com/maps/api/geocode/json", params);
    JSONObject jsonObject = new JSONObject(json);
    if (!"OK".equals(jsonObject.getString("status"))) {
      Error error = new Error();
      error.setErrorCode(jsonObject.getString("status"));
      error.setError(jsonObject.optString("error_message"));
      return new Result<String>(error);
    }

    JSONArray results = jsonObject.getJSONArray("results");
    if (results.length() == 0) {
      return new Result<String>(StringUtils.EMPTY);
    }
    return new Result<String>(results.getJSONObject(0).getString("formatted_address"));
  }

}
