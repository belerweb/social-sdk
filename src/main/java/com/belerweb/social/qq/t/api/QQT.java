package com.belerweb.social.qq.t.api;

import com.belerweb.social.SDK;

public final class QQT extends SDK {

  private String clientId;
  private String clientSecret;
  private String redirectUri;

  public QQT(String clientId, String clientSecret) {
    this.clientId = clientId;
    this.clientSecret = clientSecret;
  }

  public QQT(String clientId, String clientSecret, String redirectUri) {
    this(clientId, clientSecret);
    this.redirectUri = redirectUri;
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


}
