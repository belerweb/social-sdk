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

  @Test
  public void testCreate1() throws Exception {
    List<Menu> menus = new ArrayList<Menu>();
    Menu menu1 = new Menu();
    menu1.setName("普通菜单");
    List<Menu> subs1 = new ArrayList<Menu>();
    Menu menu11 = new Menu();
    menu11.setName("点击事件");
    menu11.setType(MenuType.CLICK);
    menu11.setKey("menu-click");
    subs1.add(menu11);
    Menu menu12 = new Menu();
    menu12.setName("跳转URL");
    menu12.setType(MenuType.VIEW);
    menu12.setUrl("https://github.com/jdkcn");
    subs1.add(menu12);
    menu1.setSubs(subs1);
    menus.add(menu1);

    Menu menu2 = new Menu();
    menu2.setName("扫码");
    List<Menu> subs2 = new ArrayList<Menu>();
    Menu menu21 = new Menu();
    menu21.setName("扫码推事件");
    menu21.setType(MenuType.SCANCODE_PUSH);
    menu21.setKey("scancode_push");
    subs2.add(menu21);
    Menu menu22 = new Menu();
    menu22.setName("扫码带提示");
    menu22.setType(MenuType.SCANCODE_WAITMSG);
    menu22.setKey("scancode_waitmsg");
    subs2.add(menu22);
    Menu menu23 = new Menu();
    menu23.setName("发送位置");
    menu23.setType(MenuType.LOCATION_SELECT);
    menu23.setKey("location_select");
    subs2.add(menu23);
    menu2.setSubs(subs2);
    menus.add(menu2);

    Menu menu3 = new Menu();
    menu3.setName("发图");
    List<Menu> subs3 = new ArrayList<Menu>();
    Menu menu31 = new Menu();
    menu31.setName("系统拍照发图");
    menu31.setType(MenuType.PIC_SYSPHOTO);
    menu31.setKey("pic_sysphoto");
    subs3.add(menu31);
    Menu menu32 = new Menu();
    menu32.setName("拍照或者相册发图");
    menu32.setType(MenuType.PIC_PHOTO_OR_ALBUM);
    menu32.setKey("pic_photo_or_album");
    subs3.add(menu32);
    Menu menu33 = new Menu();
    menu33.setName("微信相册发图");
    menu33.setType(MenuType.PIC_WEIXIN);
    menu33.setKey("pic_weixin");
    subs3.add(menu33);
    menu3.setSubs(subs3);
    menus.add(menu3);
    Result<Error> result = weixin.getMenu().create(menus);
    Assert.assertTrue(result.success());
  }

}
