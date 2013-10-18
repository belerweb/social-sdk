package com.belerweb.social.qq.t;



public class QQTException extends RuntimeException {

  private static final long serialVersionUID = -3646307994034122325L;

  public QQTException(Exception exception) {
    super(exception);
  }

  public QQTException(String message) {
    super(message);
  }

}
