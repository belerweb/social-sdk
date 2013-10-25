package com.belerweb.social.weibo.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.Result;

public class TokenInfo {

  private String uid;
  private String appkey;// access_token所属的应用appkey。
  private String scope;// 用户授权的scope权限。
  private Long createAt;// access_token的创建时间，从1970年到创建时间的秒数。
  private Long expireIn;// access_token的剩余时间，单位是秒数。

  /**
   * 授权用户的uid。
   */
  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  /**
   * access_token所属的应用appkey。
   */
  public String getAppkey() {
    return appkey;
  }

  public void setAppkey(String appkey) {
    this.appkey = appkey;
  }

  /**
   * 用户授权的scope权限。
   */
  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }

  /**
   * access_token的创建时间，从1970年到创建时间的秒数。
   */
  public Long getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Long createAt) {
    this.createAt = createAt;
  }


  /**
   * access_token的剩余时间，单位是秒数。
   */
  public Long getExpireIn() {
    return expireIn;
  }

  public void setExpireIn(Long expireIn) {
    this.expireIn = expireIn;
  }

  public static TokenInfo parse(JSONObject jsonObject) {
    TokenInfo obj = new TokenInfo();
    obj.uid = Result.toString(jsonObject.get("uid"));
    obj.appkey = Result.toString(jsonObject.opt("appkey"));
    obj.scope = Result.toString(jsonObject.opt("scope"));
    obj.createAt = Result.parseLong(jsonObject.opt("create_at"));
    obj.expireIn = Result.parseLong(jsonObject.opt("expire_in"));
    return obj;
  }
}
