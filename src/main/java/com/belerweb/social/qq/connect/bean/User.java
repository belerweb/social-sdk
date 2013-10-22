package com.belerweb.social.qq.connect.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.Gender;
import com.belerweb.social.bean.Result;

public class User {

  /**
   * 用户在QQ空间的昵称。
   */
  private String nickname;

  /**
   * 大小为30×30像素的QQ空间头像URL。
   */
  private String figureurl;

  /**
   * 大小为50×50像素的QQ空间头像URL。
   */
  private String figureurl1;

  /**
   * 大小为100×100像素的QQ空间头像URL。
   */
  private String figureurl2;

  /**
   * 大小为40×40像素的QQ头像URL。 40x40像素则是一定会有。
   */
  private String figureurlQQ1;

  /**
   * 大小为100×100像素的QQ头像URL。需要注意，不是所有的用户都拥有QQ的100x100的头像。
   */
  private String figureurlQQ2;

  /**
   * 性别。 如果获取不到则默认返回"男"
   */
  private Gender gender;

  /**
   * 标识用户是否为黄钻用户
   */
  private Boolean isYellowVip;

  /**
   * 标识用户是否为黄钻用户
   */
  private Boolean vip;

  /**
   * 黄钻等级
   */
  private Integer yellowVipLevel;

  /**
   * 黄钻等级
   */
  private Integer level;

  /**
   * 标识是否为年费黄钻用户
   */
  private Boolean isYellowYearVip;

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getFigureurl() {
    return figureurl;
  }

  public void setFigureurl(String figureurl) {
    this.figureurl = figureurl;
  }

  public String getFigureurl1() {
    return figureurl1;
  }

  public void setFigureurl1(String figureurl1) {
    this.figureurl1 = figureurl1;
  }

  public String getFigureurl2() {
    return figureurl2;
  }

  public void setFigureurl2(String figureurl2) {
    this.figureurl2 = figureurl2;
  }

  public String getFigureurlQQ1() {
    return figureurlQQ1;
  }

  public void setFigureurlQQ1(String figureurlQQ1) {
    this.figureurlQQ1 = figureurlQQ1;
  }

  public String getFigureurlQQ2() {
    return figureurlQQ2;
  }

  public void setFigureurlQQ2(String figureurlQQ2) {
    this.figureurlQQ2 = figureurlQQ2;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Boolean getIsYellowVip() {
    return isYellowVip;
  }

  public void setIsYellowVip(Boolean isYellowVip) {
    this.isYellowVip = isYellowVip;
  }

  public Boolean getVip() {
    return vip;
  }

  public void setVip(Boolean vip) {
    this.vip = vip;
  }

  public Integer getYellowVipLevel() {
    return yellowVipLevel;
  }

  public void setYellowVipLevel(Integer yellowVipLevel) {
    this.yellowVipLevel = yellowVipLevel;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

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
    obj.figureurl = Result.toString(jsonObject.opt("figureurl"));
    obj.figureurl1 = Result.toString(jsonObject.opt("figureurl_1"));
    obj.figureurl2 = Result.toString(jsonObject.opt("figureurl_2"));
    obj.figureurlQQ1 = Result.toString(jsonObject.opt("figureurl_qq_1"));
    obj.figureurlQQ2 = Result.toString(jsonObject.opt("figureurl_qq_2"));
    obj.gender = Gender.parse(jsonObject.optString("gender"));
    obj.isYellowVip = Result.parseBoolean(jsonObject.opt("is_yellow_vip"));
    obj.vip = Result.parseBoolean(jsonObject.opt("vip"));
    obj.yellowVipLevel = Result.parseInteger(jsonObject.opt("yellow_vip_level"));
    obj.level = Result.parseInteger(jsonObject.opt("level"));
    obj.isYellowYearVip = Result.parseBoolean(jsonObject.opt("is_yellow_year_vip"));
    return obj;
  }
}
