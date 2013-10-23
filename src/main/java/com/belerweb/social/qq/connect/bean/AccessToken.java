package com.belerweb.social.qq.connect.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.Result;

public class AccessToken {

  /**
   * 授权令牌，Access_Token。
   */
  private String token;

  /**
   * 该access token的有效期，单位为秒。
   */
  private Long expiresIn;

  /**
   * 在授权自动续期步骤中，获取新的Access_Token时需要提供的参数。
   */
  private String refreshToken;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Long getExpiresIn() {
    return expiresIn;
  }

  public void setExpiresIn(Long expiresIn) {
    this.expiresIn = expiresIn;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public static AccessToken parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    AccessToken obj = new AccessToken();
    obj.token = jsonObject.getString("access_token");
    obj.expiresIn = Result.parseLong(jsonObject.opt("expires_in"));
    obj.refreshToken = Result.toString(jsonObject.opt("refresh_token"));
    return obj;
  }

}
