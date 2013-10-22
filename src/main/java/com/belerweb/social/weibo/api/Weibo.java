package com.belerweb.social.weibo.api;

import com.belerweb.social.SDK;

public final class Weibo extends SDK {

  private String clientId;
  private String clientSecret;
  private String redirectUri;

  private OAuth2 oAuth2;
  private User user;

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

  public User getUser() {
    if (user == null) {
      user = new User(this);
    }

    return user;
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
