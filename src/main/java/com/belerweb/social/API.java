package com.belerweb.social;

import com.belerweb.social.qq.connect.api.QQConnect;
import com.belerweb.social.weibo.api.Weibo;
import com.belerweb.social.weixin.api.Weixin;


public abstract class API {

  protected Weibo weibo;
  protected Weixin weixin;
  protected QQConnect qqConnect;

  protected API(Weibo weibo) {
    this.weibo = weibo;
  }

  protected API(Weixin weixin) {
    this.weixin = weixin;
  }

  protected API(QQConnect qqConnect) {
    this.qqConnect = qqConnect;
  }

}
