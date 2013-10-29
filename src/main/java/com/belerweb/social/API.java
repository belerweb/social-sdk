package com.belerweb.social;

import com.belerweb.social.qq.connect.api.QQConnect;
import com.belerweb.social.qq.t.api.QQT;
import com.belerweb.social.weibo.api.Weibo;
import com.belerweb.social.weixin.api.Weixin;


public abstract class API {

  protected Weibo weibo;
  protected Weixin weixin;
  protected QQConnect connect;
  protected QQT t;

  protected API(Weibo weibo) {
    this.weibo = weibo;
  }

  protected API(Weixin weixin) {
    this.weixin = weixin;
  }

  protected API(QQConnect connect) {
    this.connect = connect;
  }

  protected API(QQT t) {
    this.t = t;
  }

}
