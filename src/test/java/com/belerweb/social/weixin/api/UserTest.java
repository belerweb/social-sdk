package com.belerweb.social.weixin.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.belerweb.social.TestConfig;
import com.belerweb.social.bean.Result;

public class UserTest extends TestConfig {

  @Test
  public void testSnsapiUserInfo() {
    String accessToken = System.getProperty("weixin.atoken");
    String openId = System.getProperty("weixin.openid");
    Result<com.belerweb.social.weixin.bean.User> result =
        weixin.getUser().snsapiUserInfo(accessToken, openId);
    Assert.assertTrue(result.success());
    System.out.println(result.getResult().getJsonObject());
  }

  @Test
  public void testUserInfo() {
    String openId = System.getProperty("weixin.openid");
    Result<com.belerweb.social.weixin.bean.User> result =
        weixin.getUser().userInfo(weixin.getAccessToken().getToken(), openId);
    Assert.assertTrue(result.success());
    System.out.println(result.getResult().getJsonObject());
  }

  @Test
  public void testGetFollowUsers() {
    Result<List<com.belerweb.social.weixin.bean.User>> result = weixin.getUser().getFollowUsers();
    Assert.assertTrue(result.success());
    for (com.belerweb.social.weixin.bean.User user : result.getResult()) {
      System.out.println(user.getJsonObject());
    }
  }

}
