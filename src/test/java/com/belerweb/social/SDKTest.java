package com.belerweb.social;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.belerweb.social.bean.Result;

public class SDKTest extends TestConfig {

  final static Logger logger = LoggerFactory.getLogger(SDKTest.class);

  @Test
  public void testLonLatToAddress() {
    Result<String> result = weibo.lonLatToAddress(118.839485, 31.954561);
    Assert.assertTrue(result.success());
    logger.info(result.getResult());
  }

}
