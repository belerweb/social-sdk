package com.belerweb.social.weixin.api;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.belerweb.social.TestConfig;
import com.belerweb.social.bean.Result;
import com.belerweb.social.weixin.bean.AccessToken;
import com.belerweb.social.weixin.bean.ApiTicket;
import com.belerweb.social.weixin.bean.JSApiTicket;
import com.belerweb.social.weixin.bean.Message;
import com.belerweb.social.weixin.bean.MsgType;
import com.belerweb.social.weixin.bean.QRTicket;
import com.belerweb.social.weixin.bean.QRType;
import com.belerweb.social.weixin.bean.Variable;

public class WeixinTest extends TestConfig {
  final static Logger logger = LoggerFactory.getLogger(WeixinTest.class);

  @Test
  public void testGetAccessToken() {
    AccessToken result = weixin.getAccessToken();
    Assert.assertNotNull(result);
    logger.info(result.getJsonObject().toString());
  }

  @Test
  public void testGetJSApiTicket() {
    JSApiTicket result = weixin.getJsApiTicket();
    Assert.assertNotNull(result);
    logger.info(result.getJsonObject().toString());
  }

  @Test
  public void testGetApiTicket() {
    ApiTicket result = weixin.getApiTicket();
    Assert.assertNotNull(result);
    logger.info(result.getJsonObject().toString());
  }

  @Test
  public void testSignature() throws Exception {
    Weixin wx = new Weixin(null);
    assertEquals("def42db04eb64f66c47a4e14fcc736156a704d8e", wx.signature("sduhi123",
        "wxd0f84fbc9396d6ae", "GROUPON",
        "E0o2-at6NcC2OsJiQTlwlKQmnidi_i9qnUG6I8wOFOOnPaK_fcjapbiBA15AUBXvkux2vvNsjYomRcbxXolfMw",
        "14300000000", "134234235235235"));
  }

  @Test
  public void testJsApiSignature() {
    String signature =
        weixin.jsapiSignature("http://openlaw.cn", new Date().getTime(),
            RandomStringUtils.randomAlphanumeric(16));
    Assert.assertNotNull(signature);
    logger.info(signature);
  }

  @Test
  public void testCreateQR() {
    Result<QRTicket> result = weixin.createQR(QRType.QR_SCENE, 0);
    Assert.assertTrue(result.success());
    logger.info(result.getResult().getJsonObject().toString());
  }

  @Test
  public void testCreateQR2() {
    Result<QRTicket> result = weixin.createQR(QRType.QR_LIMIT_SCENE, 0);
    Assert.assertTrue(result.success());
    logger.info(result.getResult().getJsonObject().toString());
    logger.info(result.getResult().getQRUrl());
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
    message.setUrl("https://github.com/belerweb/social-sdk");
    message.setTopColor("#459ae9");
    message.setTemplateId(System.getProperty("weixin.templateid"));
    Variable var1 = new Variable("first", "您好，这是一个模板消息的测试");
    Variable var2 = new Variable("schedule", "这是一个新的事件");
    Variable var3 = new Variable("time", DateFormatUtils.format(new Date(), "yyyy年MM月dd日 HH:mm"));
    message.addVariable(var1).addVariable(var2).addVariable(var3);
    Result<Boolean> result = weixin.sendTemplateMessage(message);
    Assert.assertTrue(result.success());
  }

  @Test
  public void testSendTemplateMessage1() throws Exception {
    Message message = new Message(MsgType.TEMPLATE);
    message.setToUser(System.getProperty("weixin.openid"));
    message.setUrl("http://openlaw.cn/judgement/4b47137610264874a4e41f3635b3fd83");
    message.setTopColor("#459ae9");
    message.setTemplateId(System.getProperty("weixin.templateid"));
    Variable var1 =
        new Variable("first", "高圆圆,您好!您关注的判决文书:\n龚喜琴与上海诺盛企业发展有限公司劳动合同纠纷一审民事判决书\n有新的回复。");
    Variable var2 = new Variable("keyword1", "happyboy_1688");
    Variable var3 =
        new Variable("keyword2", DateFormatUtils.format(new Date(), "yyyy年MM月dd日 HH:mm"));
    Variable var4 =
        new Variable(
            "keyword3",
            "本人参与庭审,有权发表意见:\n原告负责的项目她没本事拿下来,本人花了几个月把这项目做下来,老板为显示公平,却把一半提成给了原告,本人只拿一半帮原告挣钱但毫无怨言,这事大家都同意了,现在原告在法庭上反悔要本人的那一半,还好法官有眼,没给她.正义战胜邪恶！ ",
            "#32a3cb");
    message.addVariable(var1).addVariable(var2).addVariable(var3).addVariable(var4);
    Result<Boolean> result = weixin.sendTemplateMessage(message);
    Assert.assertTrue(result.success());
  }
}
