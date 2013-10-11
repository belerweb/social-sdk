package com.belerweb.social.weibo.bean;

/**
 * 授权页面的终端类型
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
   * follow_app_official_microblog
   */
  FOLLOW_APP_OFFICIAL_MICROBLOG("follow_app_official_microblog ");

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
