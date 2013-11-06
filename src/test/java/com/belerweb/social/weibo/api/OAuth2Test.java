package com.belerweb.social.weibo.api;

import org.junit.Assert;
import org.junit.Test;

import com.belerweb.social.TestConfig;
import com.belerweb.social.bean.Result;
import com.belerweb.social.weibo.bean.AccessToken;

public class OAuth2Test extends TestConfig {

  /**
   * 获取用于获取accessToken的code，此方法需要单独测试
   */
  @Test
  public void testAuthorize() {
    String url = weibo.getOAuth2().authorize();
    // 浏览器打开URL获取code用于下一步测试
    System.out.println(url);
  }

  /**
   * 获取accessToken，此方法需要单独测试
   */
  @Test
  public void testAccessToken() {
    Result<AccessToken> tokenResult = weibo.getOAuth2().accessToken("code");
    Assert.assertTrue(!tokenResult.success());
    System.out.println(tokenResult.getError());

    String code = System.getProperty("weibo.code");
    tokenResult = weibo.getOAuth2().accessToken(code);
    Assert.assertTrue(tokenResult.success());
    System.out.println(tokenResult.getResult().getJsonObject());
  }

}
