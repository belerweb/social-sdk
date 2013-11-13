package com.belerweb.social.weixin.bean;


/**
 * 自定义菜单类型
 */
public enum MenuType {

  /**
   * 用户点击click类型按钮后，微信服务器会通过消息接口推送消息类型为event的结构给开发者（参考消息接口指南），并且带上按钮中开发者填写的key值，
   * 开发者可以通过自定义的key值与用户进行交互；
   */
  CLICK("click"),

  /**
   * 用户点击view类型按钮后，微信客户端将会打开开发者在按钮中填写的url值 （即网页链接），达到打开网页的目的，建议与网页授权获取用户基本信息接口结合，获得用户的登入个人信息。
   */
  VIEW("view");

  private String type;

  private MenuType(String type) {
    this.type = type;
  }

  public String value() {
    return type;
  }

  @Override
  public String toString() {
    return type;
  }

  public static MenuType parse(Object val) {
    if (CLICK.type.equals(val)) {
      return CLICK;
    }
    if (VIEW.type.equals(val)) {
      return VIEW;
    }
    return null;
  }

}
