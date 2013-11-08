package com.belerweb.social.qq.connect.api;

import org.junit.Assert;
import org.junit.Test;

import com.belerweb.social.TestConfig;
import com.belerweb.social.bean.Result;
import com.belerweb.social.qq.connect.bean.AccessToken;
import com.belerweb.social.qq.connect.bean.OpenID;

public class OAuth2Test extends TestConfig {

  @Test
  public void testAuthorize() {
    String url = connect.getOAuth2().authorize();
    // 浏览器打开URL获取code用于下一步测试
    System.out.println(url);
  }

  @Test
  public void testAuthorizeWap() {
    String url = connect.getOAuth2().authorize(true);
    // 浏览器打开URL获取code用于下一步测试
    System.out.println(url);
  }

  @Test
  public void testAccessToken() {
    Result<AccessToken> tokenResult = connect.getOAuth2().accessToken("code");
    Assert.assertTrue(!tokenResult.success());
    System.out.println(tokenResult.getError());

    String code = System.getProperty("connect.code");
    tokenResult = connect.getOAuth2().accessToken(code);
    Assert.assertTrue(tokenResult.success());
    System.out.println(tokenResult.getResult().getJsonObject());
  }

  @Test
  public void testAccessTokenWap() {
    Result<AccessToken> tokenResult = connect.getOAuth2().accessToken("code", true);
    Assert.assertTrue(!tokenResult.success());
    System.out.println(tokenResult.getError());

    String code = System.getProperty("connect.code");
    tokenResult = connect.getOAuth2().accessToken(code, true);
    Assert.assertTrue(tokenResult.success());
    System.out.println(tokenResult.getResult().getJsonObject());
  }

  @Test
  public void testOpenId() {
    String accessToken = System.getProperty("connect.token");
    Result<OpenID> result = connect.getOAuth2().openId(accessToken);
    Assert.assertTrue(result.success());
    System.out.println(result.getResult().getJsonObject());
  }

  @Test
  public void testOpenIdWap() {
    String accessToken = System.getProperty("connect.token");
    Result<OpenID> result = connect.getOAuth2().openId(accessToken, true);
    Assert.assertTrue(result.success());
    System.out.println(result.getResult().getJsonObject());
  }

  @Test
  public void testRefreshAccessToken() {
    String refreshToken = System.getProperty("connect.rtoken");
    Result<AccessToken> result = connect.getOAuth2().refreshAccessToken(refreshToken);
    Assert.assertTrue(result.success());
    System.out.println(result.getResult().getJsonObject());
  }

  @Test
  public void testRefreshAccessTokenWap() {
    String refreshToken = System.getProperty("connect.rtoken");
    Result<AccessToken> result = connect.getOAuth2().refreshAccessToken(refreshToken, true);
    Assert.assertTrue(result.success());
    System.out.println(result.getResult().getJsonObject());
  }

}
