package com.belerweb.social;

import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.belerweb.social.exception.SocialException;
import com.belerweb.social.http.Http;
import com.belerweb.social.http.HttpException;

public abstract class SDK {

  public String get(String url, List<NameValuePair> params) {
    try {
      return Http.get(url, params);
    } catch (HttpException e) {
      throw new SocialException(e);
    }
  }

  public String get(String url) {
    return get(url, null);
  }

  public String post(String url, List<NameValuePair> params) {
    try {
      return Http.post(url, params);
    } catch (HttpException e) {
      throw new SocialException(e);
    }
  }

  public String post(String url) {
    return post(url, null);
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

}
