package com.belerweb.social.qq.connect.bean;

/**
 * QQ登录页面版本
 */
public enum Gut {

  WML(1),

  XHTML(2);

  private int value;

  private Gut(int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

}
