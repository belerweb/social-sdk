package com.belerweb.social.weixin.api;

import com.belerweb.social.SDK;

public final class Weixin extends SDK {

  private String appid;
  private String secret;
  private String redirectUri;

  public Weixin(String appid, String secret) {
    this.appid = appid;
    this.secret = secret;
  }

  public Weixin(String appid, String secret, String redirectUri) {
    this(appid, secret);
    this.redirectUri = redirectUri;
  }

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
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
