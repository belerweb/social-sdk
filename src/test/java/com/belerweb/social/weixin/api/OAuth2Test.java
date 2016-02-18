package com.belerweb.social.weixin.api;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.belerweb.social.TestConfig;
import com.belerweb.social.bean.Result;
import com.belerweb.social.weixin.bean.AccessToken;

public class OAuth2Test extends TestConfig {
  final static Logger logger = LoggerFactory.getLogger(OAuth2Test.class);

  @Test
  public void testAuthorize() {
    String url = weixin.getOAuth2().authorize();
    // 浏览器不能访问，只能在微信客户端中访问
    logger.info(url);
  }

  @Test
  public void testAccessToken() {
    Result<AccessToken> tokenResult = weixin.getOAuth2().accessToken("code");
    Assert.assertTrue(!tokenResult.success());
    logger.info(tokenResult.getError().toString());

    String code = System.getProperty("weixin.code");
    tokenResult = weixin.getOAuth2().accessToken(code);
    Assert.assertTrue(tokenResult.success());
    logger.info(tokenResult.getResult().getJsonObject().toString());
  }

  @Test
  public void testRefreshAccessToken() {
    String refreshToken = System.getProperty("weixin.rtoken");
    Result<AccessToken> tokenResult = weixin.getOAuth2().refreshAccessToken(refreshToken);
    Assert.assertTrue(tokenResult.success());
    System.out.print(tokenResult.getResult().getJsonObject());
  }

}
