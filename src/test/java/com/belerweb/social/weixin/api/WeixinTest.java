package com.belerweb.social.weixin.api;

import org.junit.Assert;
import org.junit.Test;

import com.belerweb.social.TestConfig;
import com.belerweb.social.weixin.bean.AccessToken;

public class WeixinTest extends TestConfig {

  @Test
  public void testGetAccessToken() {
    AccessToken result = weixin.getAccessToken();
    Assert.assertTrue(result != null);
    System.out.println(result.getJsonObject());
  }

}
