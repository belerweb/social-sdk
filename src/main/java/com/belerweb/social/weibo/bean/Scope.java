package com.belerweb.social.weibo.bean;

/**
 * scope是OAuth2.0授权机制中authorize接口的一个参数
 * 
 * 通过scope，平台将开放更多的微博核心功能给开发者，同时也加强用户隐私保护，提升了用户体验，用户在新OAuth2.0授权页中有权利选择赋予应用的功能。
 */
public enum Scope {

  /**
   * 请求下列所有scope权限
   */
  ALL("all"),

  /**
   * 用户的联系邮箱
   */
  EMAIL("email"),

  /**
   * 私信发送接口
   */
  DIRECT_MESSAGES_WRITE("direct_messages_write"),

  /**
   * 私信读取接口
   */
  DIRECT_MESSAGES_READ("direct_messages_read"),

  /**
   * 邀请发送接口
   */
  INVITATION_WRITE("invitation_write"),

  /**
   * 好友分组读取接口组
   */
  FRIENDSHIPS_GROUPS_READ("friendships_groups_read"),

  /**
   * 好友分组写入接口组
   */
  FRIENDSHIPS_GROUPS_WRITE("friendships_groups_write"),

  /**
   * 定向微博读取接口组
   */
  STATUSES_TO_ME_READ("statuses_to_me_read"),

  /**
   * 关注应用官方微博，该参数不对应具体接口，只需在应用控制台填写官方帐号即可（默认值是应用开发者帐号）
   */
  FOLLOW_APP_OFFICIAL_MICROBLOG("follow_app_official_microblog");

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
}
