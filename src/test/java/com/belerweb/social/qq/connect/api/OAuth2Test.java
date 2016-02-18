package com.belerweb.social.qq.connect.api;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.belerweb.social.TestConfig;
import com.belerweb.social.bean.Result;
import com.belerweb.social.qq.connect.bean.AccessToken;
import com.belerweb.social.qq.connect.bean.OpenID;

public class OAuth2Test extends TestConfig {

  final static Logger logger = LoggerFactory.getLogger(OAuth2Test.class);

  @Test
  public void testAuthorize() {
    String url = connect.getOAuth2().authorize();
    // 浏览器打开URL获取code用于下一步测试
    logger.info(url);
  }

  @Test
  public void testAuthorizeWap() {
    String url = connect.getOAuth2().authorize(true);
    // 浏览器打开URL获取code用于下一步测试
    logger.info(url);
  }

  @Test
  public void testAccessToken() {
    Result<AccessToken> tokenResult = connect.getOAuth2().accessToken("code");
    Assert.assertTrue(!tokenResult.success());
    logger.info(tokenResult.getError().toString());

    String code = System.getProperty("connect.code");
    tokenResult = connect.getOAuth2().accessToken(code);
    Assert.assertTrue(tokenResult.success());
    logger.info(tokenResult.getResult().getJsonObject().toString());
  }

  @Test
  public void testAccessTokenWap() {
    Result<AccessToken> tokenResult = connect.getOAuth2().accessToken("code", true);
    Assert.assertTrue(!tokenResult.success());
    logger.info(tokenResult.getError().toString());

    String code = System.getProperty("connect.code");
    tokenResult = connect.getOAuth2().accessToken(code, true);
    Assert.assertTrue(tokenResult.success());
    logger.info(tokenResult.getResult().getJsonObject().toString());
  }

  @Test
  public void testOpenId() {
    String accessToken = System.getProperty("connect.token");
    Result<OpenID> result = connect.getOAuth2().openId(accessToken);
    Assert.assertTrue(result.success());
    logger.info(result.getResult().getJsonObject().toString());
  }

  @Test
  public void testOpenIdWap() {
    String accessToken = System.getProperty("connect.token");
    Result<OpenID> result = connect.getOAuth2().openId(accessToken, true);
    Assert.assertTrue(result.success());
    logger.info(result.getResult().getJsonObject().toString());
  }

  @Test
  public void testRefreshAccessToken() {
    String refreshToken = System.getProperty("connect.rtoken");
    Result<AccessToken> result = connect.getOAuth2().refreshAccessToken(refreshToken);
    Assert.assertTrue(result.success());
    logger.info(result.getResult().getJsonObject().toString());
  }

  @Test
  public void testRefreshAccessTokenWap() {
    String refreshToken = System.getProperty("connect.rtoken");
    Result<AccessToken> result = connect.getOAuth2().refreshAccessToken(refreshToken, true);
    Assert.assertTrue(result.success());
    logger.info(result.getResult().getJsonObject().toString());
  }

}
