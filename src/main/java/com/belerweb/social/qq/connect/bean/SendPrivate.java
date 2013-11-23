package com.belerweb.social.qq.connect.bean;

public enum SendPrivate {
  IDOL(0), FRIEND(1), PUBLIC(2);

  private Integer value;

  private SendPrivate(Integer value) {
    this.value = value;
  }

  public Integer value() {
    return value;
  }

  @Override
  public String toString() {
    return value.toString();
  }

  public static SendPrivate parse(Integer value) {
    if (value == null) {
      return null;
    }
    if (value == 0) {
      return IDOL;
    }
    if (value == 1) {
      return FRIEND;
    }
    if (value == 2) {
      return PUBLIC;
    }
    return null;
  }

}
