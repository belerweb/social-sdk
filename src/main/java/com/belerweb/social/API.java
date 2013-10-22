package com.belerweb.social;

import com.belerweb.social.qq.connect.api.QQConnect;
import com.belerweb.social.weibo.api.Weibo;


public abstract class API {

  protected Weibo weibo;
  protected QQConnect qqConnect;

  protected API(Weibo weibo) {
    this.weibo = weibo;
  }

  protected API(QQConnect qqConnect) {
    this.qqConnect = qqConnect;
  }

}
