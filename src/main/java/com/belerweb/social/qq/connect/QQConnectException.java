package com.belerweb.social.qq.connect;



public class QQConnectException extends RuntimeException {

  private static final long serialVersionUID = 7823506317296937470L;

  public QQConnectException(Exception exception) {
    super(exception);
  }

  public QQConnectException(String message) {
    super(message);
  }

}
