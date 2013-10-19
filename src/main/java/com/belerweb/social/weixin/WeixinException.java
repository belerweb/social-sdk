package com.belerweb.social.weixin;



public class WeixinException extends RuntimeException {

  private static final long serialVersionUID = 7603910614256771773L;

  public WeixinException(Exception exception) {
    super(exception);
  }

  public WeixinException(String message) {
    super(message);
  }

}
