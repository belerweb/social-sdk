package com.belerweb.social.qq.mail.bean;

public class ValidationCode {

  private String status;
  private String code;
  private String uid;

  public ValidationCode() {}

  public ValidationCode(String response) {
    String[] str = response.substring(13, response.length() - 2).split(",");
    status = str[0].trim().substring(1, str[0].length() - 1);
    code = str[1].trim().substring(1, str[1].length() - 1);
    uid = str[2].trim().substring(1, str[2].length() - 1).replaceAll("\\\\x", "");
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public boolean need() {
    return !"0".equals(status);
  }

}
