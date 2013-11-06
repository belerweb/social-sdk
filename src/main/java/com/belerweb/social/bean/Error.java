package com.belerweb.social.bean;

import org.json.JSONObject;

public final class Error extends JsonBean {

  private String request;
  private String errorCode;
  private String error;

  public Error() {}

  private Error(JSONObject jsonObject) {
    super(jsonObject);
  }

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

  @Override
  public String toString() {
    return errorCode + ":" + error + "(" + request + ")";
  }

  public static Error parse(JSONObject jsonObject) {
    String errorCode = jsonObject.optString("error_code", null);
    if (errorCode != null) {// 微博
      String request = jsonObject.optString("request", null);
      String error = jsonObject.optString("error", null);
      Error er = new Error(jsonObject);
      er.setRequest(request);
      er.setErrorCode(errorCode);
      er.setError(error);
      return er;
    }

    errorCode = jsonObject.optString("errcode", null);
    if (errorCode != null) {// 微信
      String error = jsonObject.optString("errmsg", null);
      Error er = new Error(jsonObject);
      er.setErrorCode(errorCode);
      er.setError(error);
      return er;
    }

    errorCode = jsonObject.optString("error", null);
    if (errorCode != null) {// QQ互联
      String error = jsonObject.optString("error_description", null);
      Error er = new Error(jsonObject);
      er.setErrorCode(errorCode);
      er.setError(error);
      return er;
    }

    Integer ret = Result.parseInteger(jsonObject.opt("ret"));
    if (ret != null && ret != 0) {// QQ互联
      String msg = jsonObject.optString("msg", null);
      Error er = new Error(jsonObject);
      er.setErrorCode(ret.toString());
      er.setError(msg);
      return er;
    }

    return null;
  }

}
