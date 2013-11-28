package com.belerweb.social;

import org.junit.Assert;
import org.junit.Test;

import com.belerweb.social.bean.Result;

public class SDKTest extends TestConfig {

  @Test
  public void testLonLatToAddress() {
    Result<String> result = weibo.lonLatToAddress(118.839485, 31.954561);
    Assert.assertTrue(result.success());
    System.out.println(result.getResult());
  }

}
