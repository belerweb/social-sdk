package com.belerweb.social.http;



public class HttpException extends Exception {

  private static final long serialVersionUID = -7528165403129614352L;

  public HttpException(Exception exception) {
    super(exception);
  }

  public HttpException(String message) {
    super(message);
  }

}
