package com.belerweb.social.weibo.api;


public abstract class API {

  protected Weibo weibo;

  protected API(Weibo weibo) {
    this.weibo = weibo;
  }

}
