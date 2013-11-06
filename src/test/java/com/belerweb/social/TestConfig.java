package com.belerweb.social;

import org.junit.Before;

import com.belerweb.social.qq.connect.api.QQConnect;
import com.belerweb.social.weibo.api.Weibo;

public class TestConfig {

  protected Weibo weibo;
  protected QQConnect connect;

  @Before
  public void initialize() {
    String redirectUri = System.getProperty("redirect");
    weibo =
        new Weibo(System.getProperty("weibo.id"), System.getProperty("weibo.secret"), redirectUri);
    connect =
        new QQConnect(System.getProperty("connect.id"), System.getProperty("connect.secret"),
            redirectUri);
  }

}
