package com.belerweb.social.weixin.api;

import com.belerweb.social.SDK;

public final class Weixin extends SDK {

  private String appId;
  private String secret;
  private String redirectUri;

  public Weixin(String appId, String secret) {
    this.appId = appId;
    this.secret = secret;
  }

  public Weixin(String appid, String secret, String redirectUri) {
    this(appid, secret);
    this.redirectUri = redirectUri;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public String getRedirectUri() {
    return redirectUri;
  }

  public void setRedirectUri(String redirectUri) {
    this.redirectUri = redirectUri;
  }


}
