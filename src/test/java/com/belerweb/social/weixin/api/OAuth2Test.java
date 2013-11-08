package com.belerweb.social.weixin.api;

import org.junit.Assert;
import org.junit.Test;

import com.belerweb.social.TestConfig;
import com.belerweb.social.bean.Result;
import com.belerweb.social.weixin.bean.AccessToken;

public class OAuth2Test extends TestConfig {

  @Test
  public void testAuthorize() {
    String url = weixin.getOAuth2().authorize();
    // 浏览器不能访问，只能在微信客户端中访问
    System.out.println(url);
  }

  @Test
  public void testAccessToken() {
    Result<AccessToken> tokenResult = weixin.getOAuth2().accessToken("code");
    Assert.assertTrue(!tokenResult.success());
    System.out.println(tokenResult.getError());

    String code = System.getProperty("weixin.code");
    tokenResult = weixin.getOAuth2().accessToken(code);
    Assert.assertTrue(tokenResult.success());
    System.out.println(tokenResult.getResult().getJsonObject());
  }

  @Test
  public void testRefreshAccessToken() {
    String refreshToken = System.getProperty("weixin.rtoken");
    Result<AccessToken> tokenResult = weixin.getOAuth2().refreshAccessToken(refreshToken);
    Assert.assertTrue(tokenResult.success());
    System.out.print(tokenResult.getResult().getJsonObject());
  }

}
