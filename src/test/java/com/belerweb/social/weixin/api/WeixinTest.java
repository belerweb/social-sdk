package com.belerweb.social.weixin.api;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.belerweb.social.TestConfig;
import com.belerweb.social.bean.Result;
import com.belerweb.social.weixin.bean.AccessToken;
import com.belerweb.social.weixin.bean.Message;
import com.belerweb.social.weixin.bean.MsgType;
import com.belerweb.social.weixin.bean.QRTicket;
import com.belerweb.social.weixin.bean.QRType;

public class WeixinTest extends TestConfig {

  @Test
  public void testGetAccessToken() {
    AccessToken result = weixin.getAccessToken();
    Assert.assertTrue(result != null);
    System.out.println(result.getJsonObject());
  }

  @Test
  public void testCreateQR() {
    Result<QRTicket> result = weixin.createQR(QRType.QR_SCENE, 0);
    Assert.assertTrue(result.success());
    System.out.println(result.getResult().getJsonObject());
  }

  @Test
  public void testCreateQR2() {
    Result<QRTicket> result = weixin.createQR(QRType.QR_LIMIT_SCENE, 0);
    Assert.assertTrue(result.success());
    System.out.println(result.getResult().getJsonObject());
    System.out.println(result.getResult().getQRUrl());
  }

  @Test
  public void testSendCustomMessage() {
    Message message = new Message(MsgType.TEXT);
    message.setToUser(System.getProperty("weixin.openid"));
    message.setContent(new Date().toString());
    Result<Boolean> result = weixin.sendCustomMessage(message);
    Assert.assertTrue(result.success());
  }

}
