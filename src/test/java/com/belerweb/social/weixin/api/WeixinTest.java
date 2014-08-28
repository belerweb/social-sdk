package com.belerweb.social.weixin.api;

import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.junit.Assert;
import org.junit.Test;

import com.belerweb.social.TestConfig;
import com.belerweb.social.bean.Result;
import com.belerweb.social.weixin.bean.AccessToken;
import com.belerweb.social.weixin.bean.Message;
import com.belerweb.social.weixin.bean.MsgType;
import com.belerweb.social.weixin.bean.QRTicket;
import com.belerweb.social.weixin.bean.QRType;
import com.belerweb.social.weixin.bean.Variable;

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

  @Test
  public void testSendTemplateMessage() throws Exception {
    Message message = new Message(MsgType.TEMPLATE);
    message.setToUser(System.getProperty("weixin.openid"));
    message.setTopColor("#459ae9");
    message.setTemplateId("Iwg2FbgpM9LKNKn2EZzk_TqjGTnDMiGnc_NNSwPo5LI");
    Variable var1 = new Variable("first", "您好，这是一个模板消息的测试");
    Variable var2 = new Variable("schedule", "这是一个新的事件");
    Variable var3 = new Variable("time", DateFormatUtils.format(new Date(), "yyyy年MM月dd日 HH:mm"));
    Variable var4 = new Variable("time", DateFormatUtils.format(new Date(), "yyyy年MM月dd日 HH:mm"));
    message.addVariable(var1).addVariable(var2).addVariable(var3).addVariable(var4);
    Result<Boolean> result = weixin.sendTemplateMessage(message);
    Assert.assertTrue(result.success());
  }
}
