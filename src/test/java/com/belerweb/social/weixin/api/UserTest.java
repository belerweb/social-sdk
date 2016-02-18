package com.belerweb.social.weixin.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.belerweb.social.TestConfig;
import com.belerweb.social.bean.Result;

public class UserTest extends TestConfig {

  final static Logger logger = LoggerFactory.getLogger(UserTest.class);

  @Test
  public void testSnsapiUserInfo() {
    String accessToken = System.getProperty("weixin.atoken");
    String openId = System.getProperty("weixin.openid");
    Result<com.belerweb.social.weixin.bean.User> result =
        weixin.getUser().snsapiUserInfo(accessToken, openId);
    Assert.assertTrue(result.success());
    logger.info(result.getResult().getJsonObject().toString());
  }

  @Test
  public void testUserInfo() {
    String openId = System.getProperty("weixin.openid");
    Result<com.belerweb.social.weixin.bean.User> result =
        weixin.getUser().userInfo(weixin.getAccessToken().getToken(), openId);
    Assert.assertTrue(result.success());
    logger.info(result.getResult().getJsonObject().toString());
  }

  @Test
  public void testGetFollowUsers() {
    Result<List<com.belerweb.social.weixin.bean.User>> result = weixin.getUser().getFollowUsers();
    Assert.assertTrue(result.success());
    for (com.belerweb.social.weixin.bean.User user : result.getResult()) {
      logger.info(user.getJsonObject().toString());
    }
  }

}
