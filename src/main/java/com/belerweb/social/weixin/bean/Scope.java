package com.belerweb.social.weixin.bean;


/**
 * 应用授权作用域
 */
public enum Scope {

  /**
   * 不弹出授权页面，直接跳转，只能获取用户openid
   */
  SNSAPI_BASE("snsapi_base"),

  /**
   * 网页应用目前仅填写snsapi_login即可
   */
  SNSAPI_LOGIN("snsapi_login"),

  /**
   * 弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息
   */
  SNSAPI_USERINFO("snsapi_userinfo");

  private String scope;

  private Scope(String scope) {
    this.scope = scope;
  }

  public String value() {
    return scope;
  }

  @Override
  public String toString() {
    return scope;
  }

  public static Scope parse(Object val) {
    if (SNSAPI_BASE.scope.equals(val)) {
      return SNSAPI_BASE;
    }
    if (SNSAPI_USERINFO.scope.equals(val)) {
      return SNSAPI_USERINFO;
    }
    if (SNSAPI_LOGIN.scope.equals(val)) {
      return SNSAPI_LOGIN;
    }
    return null;
  }
}
