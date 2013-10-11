package com.belerweb.social.weibo.bean;

/**
 * 授权页面的终端类型
 */
public enum Display {

  /**
   * 默认的授权页面，适用于web浏览器。
   */
  DEFAULT("default"),

  /**
   * 移动终端的授权页面，适用于支持html5的手机。注：使用此版授权页请用 https://open.weibo.cn/oauth2/authorize 授权接口
   */
  MOBILE("mobile"),

  /**
   * wap版授权页面，适用于非智能手机。
   */
  WAP("wap"),

  /**
   * 客户端版本授权页面，适用于PC桌面应用。
   */
  CLIENT("client"),

  /**
   * 默认的站内应用授权页，授权后不返回access_token，只刷新站内应用父框架。
   */
  APPONWEIBO("apponweibo");

  private String display;

  private Display(String display) {
    this.display = display;
  }

  public String value() {
    return display;
  }

  @Override
  public String toString() {
    return display;
  }
}
