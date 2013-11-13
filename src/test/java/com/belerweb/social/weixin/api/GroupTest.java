package com.belerweb.social.weixin.api;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import com.belerweb.social.TestConfig;
import com.belerweb.social.bean.Error;
import com.belerweb.social.bean.Result;
import com.belerweb.social.weixin.bean.Group;

public class GroupTest extends TestConfig {

  @Test
  public void testCreate() {
    Result<Group> result = weixin.getGroup().create(RandomStringUtils.randomAlphabetic(6));
    Assert.assertTrue(result.success());
    System.out.println(result.getResult().getJsonObject());
  }

  @Test
  public void testGet() {
    Result<List<Group>> result = weixin.getGroup().get();
    Assert.assertTrue(result.success());
    for (Group group : result.getResult()) {
      System.out.println(group.getJsonObject());
    }
  }

  @Test
  public void testUpdate() {
    String id = System.getProperty("weixin.groupid");
    Result<Error> result = weixin.getGroup().update(id, RandomStringUtils.randomAlphabetic(6));
    Assert.assertTrue(result.success());
  }

  @Test
  public void testMove() {
    String openId = System.getProperty("weixin.openid");
    String groupId = System.getProperty("weixin.groupid");
    Result<Error> result = weixin.getGroup().move(openId, groupId);
    Assert.assertTrue(result.success());
  }

}
