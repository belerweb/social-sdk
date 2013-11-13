package com.belerweb.social.weixin.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import com.belerweb.social.TestConfig;
import com.belerweb.social.bean.Error;
import com.belerweb.social.bean.Result;
import com.belerweb.social.weixin.bean.Menu;
import com.belerweb.social.weixin.bean.MenuType;

public class MenuTest extends TestConfig {

  @Test
  public void testGet() {
    Result<List<Menu>> result = weixin.getMenu().get();
    Assert.assertTrue(result.success());
  }

  @Test
  public void testDelete() {
    Result<Error> result = weixin.getMenu().delete();
    Assert.assertTrue(result.success());
  }

  @Test
  public void testCreate() {
    List<Menu> menus = new ArrayList<Menu>();
    Menu menu1 = new Menu();
    menu1.setName(RandomStringUtils.randomAlphabetic(4));
    List<Menu> subs = new ArrayList<Menu>();
    Menu menu11 = new Menu();
    menu11.setName(RandomStringUtils.randomAlphabetic(4));
    menu11.setType(MenuType.CLICK);
    menu11.setKey(RandomStringUtils.randomAlphabetic(4));
    subs.add(menu11);
    Menu menu22 = new Menu();
    menu22.setName(RandomStringUtils.randomAlphabetic(4));
    menu22.setType(MenuType.VIEW);
    menu22.setUrl("https://github.com/belerweb/");
    subs.add(menu22);
    menu1.setSubs(subs);
    menus.add(menu1);
    Result<Error> result = weixin.getMenu().create(menus);
    Assert.assertTrue(result.success());
  }

}
