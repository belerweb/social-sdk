package com.belerweb.social.qq.connect.api;

import org.junit.Assert;
import org.junit.Test;

import com.belerweb.social.TestConfig;
import com.belerweb.social.bean.Result;

public class UserTest extends TestConfig {

  @Test
  public void testGetUserInfo() {
    String openId = System.getProperty("connect.openid");
    String accessToken = System.getProperty("connect.token");

    Result<com.belerweb.social.qq.connect.bean.User> result =
        connect.getUser().getUserInfo(accessToken, openId);
    Assert.assertTrue(result.success());
    System.out.println(result.getResult().getJsonObject());
  }

  @Test
  public void testGetSimpleUserInfo() {
    String openId = System.getProperty("connect.openid");
    String accessToken = System.getProperty("connect.token");

    Result<com.belerweb.social.qq.connect.bean.User> result =
        connect.getUser().getSimpleUserInfo(accessToken, connect.getClientId(), openId);
    Assert.assertTrue(result.success());
    System.out.println(result.getResult().getJsonObject());
  }

}
