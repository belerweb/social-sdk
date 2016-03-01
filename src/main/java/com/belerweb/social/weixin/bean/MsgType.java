package com.belerweb.social.weixin.bean;


/**
 * 普通消息
 */
public enum MsgType {

  /**
   * 文本消息
   */
  TEXT("text"),

  /**
   * 图片消息
   */
  IMAGE("image"),

  /**
   * 语音消息
   */
  VOICE("voice"),

  /**
   * 视频消息
   */
  VIDEO("video"),

  /**
   * 视频消息
   */
  SHORTVIDEO("shortvideo"),

  /**
   * 音乐消息
   */
  MUSIC("music"),

  /**
   * 地理位置消息
   */
  LOCATION("location"),

  /**
   * 链接消息
   */
  LINK("link"),

  /**
   * 事件
   */
  EVENT("event"),

  /**
   * 图文消息
   */
  NEWS("news"),

  /**
   * 模板消息
   */
  TEMPLATE("template"),

  /**
   * 多客服接入
   */
  TRANSFER_CUSTOMER_SERVICE("transfer_customer_service");

  private String type;

  private MsgType(String type) {
    this.type = type;
  }

  public String value() {
    return type;
  }

  @Override
  public String toString() {
    return type;
  }

  public static MsgType parse(Object val) {
    if (TEXT.type.equals(val)) {
      return TEXT;
    }
    if (IMAGE.type.equals(val)) {
      return IMAGE;
    }
    if (VOICE.type.equals(val)) {
      return VOICE;
    }
    if (VIDEO.type.equals(val)) {
      return VIDEO;
    }
    if (MUSIC.type.equals(val)) {
      return MUSIC;
    }
    if (LOCATION.type.equals(val)) {
      return LOCATION;
    }
    if (LINK.type.equals(val)) {
      return LINK;
    }
    if (EVENT.type.equals(val)) {
      return EVENT;
    }
    if (NEWS.type.equals(val)) {
      return NEWS;
    }
    if (TEMPLATE.type.equals(val)) {
      return TEMPLATE;
    }
    if (TRANSFER_CUSTOMER_SERVICE.type.equals(val)) {
      return TRANSFER_CUSTOMER_SERVICE;
    }
    return null;
  }
}
