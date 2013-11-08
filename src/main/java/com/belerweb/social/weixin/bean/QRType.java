package com.belerweb.social.weixin.bean;


/**
 * 带参数的二维码类型
 */
public enum QRType {

  /**
   * 临时二维码
   */
  QR_SCENE("QR_SCENE"),

  /**
   * 永久二维码
   */
  QR_LIMIT_SCENE("QR_LIMIT_SCENE");

  private String type;

  private QRType(String type) {
    this.type = type;
  }

  public String value() {
    return type;
  }

  @Override
  public String toString() {
    return type;
  }

  public static QRType parse(Object val) {
    if (QR_LIMIT_SCENE.type.equals(val)) {
      return QR_LIMIT_SCENE;
    }
    if (QR_SCENE.type.equals(val)) {
      return QR_SCENE;
    }
    return null;
  }
}
