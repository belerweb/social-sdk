package com.belerweb.social.exception;

public class SocialException extends RuntimeException {

  private static final long serialVersionUID = 3536584215181288508L;

  public SocialException(Exception exception) {
    super(exception);
  }

  public SocialException(String message) {
    super(message);
  }

}
