package com.belerweb.social.qq.connect.bean;

public enum AlbumPrivilege {
  PUBLIC(1), PRIVATE(3), FRIEND(4), QUESTION(5);

  private Integer value;

  private AlbumPrivilege(Integer value) {
    this.value = value;
  }

  public Integer value() {
    return value;
  }

  @Override
  public String toString() {
    return value.toString();
  }

  public static AlbumPrivilege parse(Integer value) {
    if (value == null) {
      return null;
    }
    if (value == 1) {
      return PUBLIC;
    }
    if (value == 3) {
      return PRIVATE;
    }
    if (value == 4) {
      return FRIEND;
    }
    if (value == 5) {
      return QUESTION;
    }
    return null;
  }

}
