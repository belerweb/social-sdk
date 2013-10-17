package com.belerweb.social.bean;

public enum OnlineStatus {

  ONLINE(1, "在线", "online"), OFFLINE(0, "不在线", "offline");

  private int status;
  private String text;
  private String enText;

  private OnlineStatus(int status, String text, String enText) {
    this.status = status;
    this.text = text;
    this.enText = enText;
  }

  public boolean online() {
    return status == 1;
  }

  public int status() {
    return status;
  }

  public String text() {
    return text;
  }

  public String enText() {
    return enText;
  }

  @Override
  public String toString() {
    return super.toString();
  }

  public static OnlineStatus parse(Integer val) {
    if (val == null) {
      return null;
    }
    if (new Integer(1).equals(val)) {
      return ONLINE;
    }
    return OFFLINE;
  }

  public static OnlineStatus parse(String val) {
    if (val == null) {
      return null;
    }
    if ("在线".equals(val) || "online".equalsIgnoreCase(val)) {
      return ONLINE;
    }
    return OFFLINE;
  }

}
