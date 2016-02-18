package com.belerweb.social.weibo.api;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.belerweb.social.TestConfig;
import com.belerweb.social.bean.Result;
import com.belerweb.social.weibo.bean.AccessToken;
import com.belerweb.social.weibo.bean.TokenInfo;

public class OAuth2Test extends TestConfig {

  final static Logger logger = LoggerFactory.getLogger(OAuth2Test.class);

  /**
   * 获取用于获取accessToken的code，此方法需要单独测试
   */
  @Test
  public void testAuthorize() {
    String url = weibo.getOAuth2().authorize();
    // 浏览器打开URL获取code用于下一步测试
    logger.info(url);
  }

  /**
   * 获取accessToken，此方法需要单独测试
   */
  @Test
  public void testAccessToken() {
    Result<AccessToken> tokenResult = weibo.getOAuth2().accessToken("code");
    Assert.assertTrue(!tokenResult.success());
    logger.info(tokenResult.getError().toString());

    String code = System.getProperty("weibo.code");
    tokenResult = weibo.getOAuth2().accessToken(code);
    Assert.assertTrue(tokenResult.success());
    logger.info(tokenResult.getResult().getJsonObject().toString());
  }

  @Test
  public void testGetTokenInfo() {
    String accessToken = System.getProperty("weibo.token");
    Result<TokenInfo> tokenResult = weibo.getOAuth2().getTokenInfo(accessToken);
    Assert.assertTrue(tokenResult.success());
    logger.info(tokenResult.getResult().getJsonObject().toString());
  }

  @Test
  public void testRevokeOAuth2() {
    String accessToken = System.getProperty("weibo.token");
    Result<Boolean> tokenResult = weibo.getOAuth2().revokeOAuth2(accessToken);
    Assert.assertTrue(tokenResult.success());
    Assert.assertTrue(tokenResult.getResult());
  }

}
