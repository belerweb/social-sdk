package com.belerweb.social.weibo;

import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import com.belerweb.social.http.Http;
import com.belerweb.social.http.HttpException;

public final class Weibo {

  private String clientId;
  private String clientSecret;
  private String redirectUri;

  private OAuth2 oAuth2;

  public Weibo(String clientId, String clientSecret) {
    this.clientId = clientId;
    this.clientSecret = clientSecret;
  }


  public Weibo(String clientId, String clientSecret, String redirectUri) {
    this(clientId, clientSecret);
    this.redirectUri = redirectUri;
  }


  public OAuth2 getOAuth2() {
    if (oAuth2 == null) {
      oAuth2 = new OAuth2(this);
    }

    return oAuth2;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public String getRedirectUri() {
    return redirectUri;
  }

  public void setRedirectUri(String redirectUri) {
    this.redirectUri = redirectUri;
  }

  JSONObject get(String url, List<NameValuePair> params) {
    try {
      return new JSONObject(Http.get(url, params));
    } catch (HttpException e) {
      throw new WeiboException(e);
    }
  }

  JSONObject get(String url) {
    return get(url, null);
  }

  JSONObject post(String url, List<NameValuePair> params) {
    try {
      return new JSONObject(Http.post(url, params));
    } catch (HttpException e) {
      throw new WeiboException(e);
    }
  }

  JSONObject post(String url) {
    return post(url, null);
  }

  void addParameter(List<NameValuePair> params, String name, Object value) {
    if (value == null) {
      throw new WeiboException("Parameter " + name + " must not be null.");
    }
    params.add(new BasicNameValuePair(name, value.toString()));
  }

  void addNotNullParameter(List<NameValuePair> params, String name, Object value) {
    if (value != null) {
      params.add(new BasicNameValuePair(name, value.toString()));
    }
  }

  void addTrueParameter(List<NameValuePair> params, String name, Boolean value) {
    if (Boolean.TRUE.equals(value)) {
      params.add(new BasicNameValuePair(name, value.toString()));
    }
  }

}
