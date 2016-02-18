package com.belerweb.social.weibo.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.belerweb.social.TestConfig;
import com.belerweb.social.bean.Result;
import com.belerweb.social.weibo.bean.UserCounts;

public class UserTest extends TestConfig {

  final static Logger logger = LoggerFactory.getLogger(UserTest.class);

  @Test
  public void testShow() {
    String uid = System.getProperty("weibo.uid");
    Result<com.belerweb.social.weibo.bean.User> result =
        weibo.getUser().show(weibo.getClientId(), null, uid, null);
    Assert.assertTrue(result.success());
    logger.info(result.getResult().getJsonObject().toString());
  }

  @Test
  public void testDomainShow() {
    Result<com.belerweb.social.weibo.bean.User> result =
        weibo.getUser().domainShow(weibo.getClientId(), null, "cqlybest");
    Assert.assertTrue(result.success());
    logger.info(result.getResult().getJsonObject().toString());
  }

  @Test
  public void testCounts() {
    String accessToken = System.getProperty("weibo.token");
    String uid = System.getProperty("weibo.uid");
    List<String> uids = new ArrayList<String>();
    uids.add(uid);
    Result<UserCounts> result = weibo.getUser().counts(null, accessToken, uids);
    Assert.assertTrue(result.success());
    List<UserCounts> results = result.getResults();
    for (UserCounts userCounts : results) {
      logger.info(userCounts.getJsonObject().toString());
    }
  }

}
