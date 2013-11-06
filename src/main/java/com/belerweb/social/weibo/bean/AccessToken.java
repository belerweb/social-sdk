package com.belerweb.social.weibo.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

public class AccessToken extends JsonBean {

  public AccessToken() {}

  private AccessToken(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String token;// 用于调用access_token，接口获取授权后的access token。
  private Long expiresIn;// access_token的生命周期，单位是秒数。
  private Long remindIn;// access_token的生命周期（该参数即将废弃，开发者请使用expires_in）。
  private String uid;// 当前授权用户的UID。

  /**
   * 用于调用access_token，接口获取授权后的access token。
   */
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  /**
   * access_token的生命周期，单位是秒数。
   */
  public Long getExpiresIn() {
    return expiresIn;
  }

  public void setExpiresIn(Long expiresIn) {
    this.expiresIn = expiresIn;
  }

  /**
   * access_token的生命周期（该参数即将废弃，开发者请使用expires_in）。
   */
  public Long getRemindIn() {
    return remindIn;
  }

  public void setRemindIn(Long remindIn) {
    this.remindIn = remindIn;
  }

  /**
   * 当前授权用户的UID。
   */
  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public static AccessToken parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    AccessToken obj = new AccessToken(jsonObject);
    obj.token = jsonObject.getString("access_token");
    obj.expiresIn = Result.parseLong(jsonObject.opt("expires_in"));
    obj.remindIn = Result.parseLong(jsonObject.opt("remind_in"));
    obj.uid = Result.toString(jsonObject.get("uid"));
    return obj;
  }
}
