package com.belerweb.social.weibo.bean;

import org.json.JSONObject;

public final class Error {

  private String request;
  private String errorCode;
  private String error;

  public Error() {}

  public String getRequest() {
    return request;
  }

  public void setRequest(String request) {
    this.request = request;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public static Error parse(JSONObject jsonObject) {
    String errorCode = jsonObject.optString("error_code");
    if (errorCode != null) {
      String request = jsonObject.optString("request");
      String error = jsonObject.optString("error");
      Error er = new Error();
      er.setRequest(request);
      er.setErrorCode(errorCode);
      er.setError(error);
      return er;
    }

    return null;
  }

}
