package com.belerweb.social;

import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import com.belerweb.social.http.Http;
import com.belerweb.social.http.HttpException;
import com.belerweb.social.weibo.WeiboException;

public abstract class SDK {

  public JSONObject get(String url, List<NameValuePair> params) {
    try {
      return new JSONObject(Http.get(url, params));
    } catch (HttpException e) {
      throw new WeiboException(e);
    }
  }

  public JSONObject get(String url) {
    return get(url, null);
  }

  public JSONObject post(String url, List<NameValuePair> params) {
    try {
      return new JSONObject(Http.post(url, params));
    } catch (HttpException e) {
      throw new WeiboException(e);
    }
  }

  public JSONObject post(String url) {
    return post(url, null);
  }

  public void addParameter(List<NameValuePair> params, String name, Object value) {
    if (value == null) {
      throw new WeiboException("Parameter " + name + " must not be null.");
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

}
