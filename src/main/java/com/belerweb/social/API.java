package com.belerweb.social;

import com.belerweb.social.weibo.api.Weibo;


public abstract class API {

  protected Weibo weibo;

  protected API(Weibo weibo) {
    this.weibo = weibo;
  }

}
