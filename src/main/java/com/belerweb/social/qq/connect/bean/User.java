package com.belerweb.social.qq.connect.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.Gender;
import com.belerweb.social.bean.Result;

public class User {

  private String nickname;// 用户在QQ空间的昵称。
  private String figureUrl;// 大小为30×30像素的QQ空间头像URL。
  private String figureUrl1;// 大小为50×50像素的QQ空间头像URL。
  private String figureUrl2;// 大小为100×100像素的QQ空间头像URL。
  private String figureUrlQQ1;// 大小为40×40像素的QQ头像URL。 40x40像素则是一定会有。
  private String figureUrlQQ2;// 大小为100×100像素的QQ头像URL。需要注意，不是所有的用户都拥有QQ的100x100的头像。
  private Gender gender;// 性别。 如果获取不到则默认返回"男"
  private Boolean isYellowVip;// 标识用户是否为黄钻用户
  private Boolean vip;// 标识用户是否为黄钻用户
  private Integer yellowVipLevel;// 黄钻等级
  private Integer level;// 黄钻等级
  private Boolean isYellowYearVip;// 标识是否为年费黄钻用户

  /**
   * 用户在QQ空间的昵称。
   */
  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  /**
   * 大小为30×30像素的QQ空间头像URL。
   */
  public String getFigureUrl() {
    return figureUrl;
  }

  public void setFigureUrl(String figureUrl) {
    this.figureUrl = figureUrl;
  }

  /**
   * 大小为50×50像素的QQ空间头像URL。
   */
  public String getFigureUrl1() {
    return figureUrl1;
  }

  public void setFigureUrl1(String figureUrl1) {
    this.figureUrl1 = figureUrl1;
  }

  /**
   * 大小为100×100像素的QQ空间头像URL。
   */
  public String getFigureUrl2() {
    return figureUrl2;
  }

  public void setFigureUrl2(String figureUrl2) {
    this.figureUrl2 = figureUrl2;
  }

  /**
   * 大小为40×40像素的QQ头像URL。 40x40像素则是一定会有。
   */
  public String getFigureUrlQQ1() {
    return figureUrlQQ1;
  }

  public void setFigureUrlQQ1(String figureUrlQQ1) {
    this.figureUrlQQ1 = figureUrlQQ1;
  }

  /**
   * 大小为100×100像素的QQ头像URL。需要注意，不是所有的用户都拥有QQ的100x100的头像。
   */
  public String getFigureUrlQQ2() {
    return figureUrlQQ2;
  }

  public void setFigureUrlQQ2(String figureUrlQQ2) {
    this.figureUrlQQ2 = figureUrlQQ2;
  }

  /**
   * 性别。 如果获取不到则默认返回"男"
   */
  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  /**
   * 标识用户是否为黄钻用户
   */
  public Boolean getIsYellowVip() {
    return isYellowVip;
  }

  public void setIsYellowVip(Boolean isYellowVip) {
    this.isYellowVip = isYellowVip;
  }

  /**
   * 标识用户是否为黄钻用户
   */
  public Boolean getVip() {
    return vip;
  }

  public void setVip(Boolean vip) {
    this.vip = vip;
  }

  /**
   * 黄钻等级
   */
  public Integer getYellowVipLevel() {
    return yellowVipLevel;
  }

  public void setYellowVipLevel(Integer yellowVipLevel) {
    this.yellowVipLevel = yellowVipLevel;
  }

  /**
   * 黄钻等级
   */
  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  /**
   * 标识是否为年费黄钻用户
   */
  public Boolean getIsYellowYearVip() {
    return isYellowYearVip;
  }

  public void setIsYellowYearVip(Boolean isYellowYearVip) {
    this.isYellowYearVip = isYellowYearVip;
  }

  public static User parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    User obj = new User();
    obj.nickname = Result.toString(jsonObject.get("nickname"));
    obj.figureUrl = Result.toString(jsonObject.opt("figureurl"));
    obj.figureUrl1 = Result.toString(jsonObject.opt("figureurl_1"));
    obj.figureUrl2 = Result.toString(jsonObject.opt("figureurl_2"));
    obj.figureUrlQQ1 = Result.toString(jsonObject.opt("figureurl_qq_1"));
    obj.figureUrlQQ2 = Result.toString(jsonObject.opt("figureurl_qq_2"));
    obj.gender = Gender.parse(jsonObject.optString("gender", null));
    obj.isYellowVip = Result.parseBoolean(jsonObject.opt("is_yellow_vip"));
    obj.vip = Result.parseBoolean(jsonObject.opt("vip"));
    obj.yellowVipLevel = Result.parseInteger(jsonObject.opt("yellow_vip_level"));
    obj.level = Result.parseInteger(jsonObject.opt("level"));
    obj.isYellowYearVip = Result.parseBoolean(jsonObject.opt("is_yellow_year_vip"));
    return obj;
  }
}
