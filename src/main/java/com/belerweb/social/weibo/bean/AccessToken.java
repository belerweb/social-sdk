package com.belerweb.social.weibo.bean;

import org.json.JSONObject;

public class AccessToken {

  /**
   * 用于调用access_token，接口获取授权后的access token。
   */
  private String token;

  /**
   * access_token的生命周期，单位是秒数。
   */
  private Long expiresIn;

  /**
   * access_token的生命周期（该参数即将废弃，开发者请使用expires_in）。
   */
  private Long remindIn;

  /**
   * 当前授权用户的UID。
   */
  private String uid;

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

  public Long getRemindIn() {
    return remindIn;
  }

  public void setRemindIn(Long remindIn) {
    this.remindIn = remindIn;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public static AccessToken parse(JSONObject jsonObject) {
    AccessToken obj = new AccessToken();
    obj.token = jsonObject.getString("access_token");
    obj.expiresIn = Result.perseLong(jsonObject.opt("expires_in"));
    obj.remindIn = Result.perseLong(jsonObject.opt("remind_in"));
    obj.uid = Result.toString(jsonObject.get("uid"));
    return obj;
  }
}
