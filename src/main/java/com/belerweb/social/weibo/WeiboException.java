package com.belerweb.social.weibo;



public class WeiboException extends RuntimeException {

  private static final long serialVersionUID = 3536584215181288508L;

  public WeiboException(Exception exception) {
    super(exception);
  }

  public WeiboException(String message) {
    super(message);
  }

}
