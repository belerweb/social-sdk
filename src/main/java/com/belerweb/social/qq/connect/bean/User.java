package com.belerweb.social.qq.connect.bean;

import java.util.Date;

import org.json.JSONObject;

import com.belerweb.social.bean.Gender;
import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

public class User extends JsonBean {

  public User() {}

  private User(JSONObject jsonObject) {
    super(jsonObject);
  }

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
  private Boolean isQQVip;// 标识是否QQ会员
  private Integer qqVipLevel;// QQ会员等级
  private Boolean isQQYearVip;// 标识是否为年费QQ会员
  private Boolean isLost;
  private Date qqVipStart;// QQ会员最后一次充值时间
  private Date qqVipEnd;// QQ会员期限
  private Integer qqVipPayway;// QQ会员充值方式
  private Date qqYearVipStart;// QQ年费会员最后一次充值时间
  private Date qqYearVipEnd;// QQ年费会员期限
  private Integer qqYearVipPayway;// QQ年费会员充值方式
  private Date qqZuanhuangStart;// QQ钻皇最后一次充值时间
  private Date qqZuanhuangEnd;// QQ钻皇期限
  private Integer qqZuanhuangPayway;// QQ钻皇充值方式
  private Date qqHaohuaStart;// 豪华版QQ会员最后一次充值时间
  private Date qqHaohuaEnd;// 豪华版QQ会员期限
  private Integer qqHaohuaPayway;// 豪华版QQ会员充值方式
  private Date qqSvipStart;// QQ SVIP最后一次充值时间，预留字段，当前信息无效
  private Date qqSvipEnd;// QQ SVIP期限，预留字段，当前信息无效
  private Integer qqSvipPayway;// QQ SVIP充值方式，预留字段，当前信息无效
  private Date historyPayTime;// 非会员历史充值时间，仅在用户是非会员时信息有效
  private Date historyEndTime;// 非会员历史充值到期时间，仅在用户是非会员时信息有效

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

  /**
   * 标识是否QQ会员
   */
  public Boolean getIsQQVip() {
    return isQQVip;
  }

  public void setIsQQVip(Boolean isQQVip) {
    this.isQQVip = isQQVip;
  }

  /**
   * QQ会员等级
   */
  public Integer getQqVipLevel() {
    return qqVipLevel;
  }

  public void setQqVipLevel(Integer qqVipLevel) {
    this.qqVipLevel = qqVipLevel;
  }

  /**
   * 是否是QQ年费会员
   */
  public Boolean getIsQQYearVip() {
    return isQQYearVip;
  }

  public void setIsQQYearVip(Boolean isQQYearVip) {
    this.isQQYearVip = isQQYearVip;
  }

  public Boolean getIsLost() {
    return isLost;
  }

  public void setIsLost(Boolean isLost) {
    this.isLost = isLost;
  }

  /**
   * QQ会员最后一次充值时间
   */
  public Date getQqVipStart() {
    return qqVipStart;
  }

  public void setQqVipStart(Date qqVipStart) {
    this.qqVipStart = qqVipStart;
  }

  /**
   * QQ会员期限
   */
  public Date getQqVipEnd() {
    return qqVipEnd;
  }

  public void setQqVipEnd(Date qqVipEnd) {
    this.qqVipEnd = qqVipEnd;
  }

  /**
   * QQ会员充值方式
   */
  public Integer getQqVipPayway() {
    return qqVipPayway;
  }

  public void setQqVipPayway(Integer qqVipPayway) {
    this.qqVipPayway = qqVipPayway;
  }

  /**
   * QQ年费会员最后一次充值时间
   */
  public Date getQqYearVipStart() {
    return qqYearVipStart;
  }

  public void setQqYearVipStart(Date qqYearVipStart) {
    this.qqYearVipStart = qqYearVipStart;
  }

  /**
   * QQ年费会员期限
   */
  public Date getQqYearVipEnd() {
    return qqYearVipEnd;
  }

  public void setQqYearVipEnd(Date qqYearVipEnd) {
    this.qqYearVipEnd = qqYearVipEnd;
  }

  /**
   * QQ年费会员充值方式
   */
  public Integer getQqYearVipPayway() {
    return qqYearVipPayway;
  }

  public void setQqYearVipPayway(Integer qqYearVipPayway) {
    this.qqYearVipPayway = qqYearVipPayway;
  }

  /**
   * QQ钻皇最后一次充值时间
   */
  public Date getQqZuanhuangStart() {
    return qqZuanhuangStart;
  }

  public void setQqZuanhuangStart(Date qqZuanhuangStart) {
    this.qqZuanhuangStart = qqZuanhuangStart;
  }

  /**
   * QQ钻皇期限
   */
  public Date getQqZuanhuangEnd() {
    return qqZuanhuangEnd;
  }

  public void setQqZuanhuangEnd(Date qqZuanhuangEnd) {
    this.qqZuanhuangEnd = qqZuanhuangEnd;
  }

  /**
   * QQ钻皇充值方式
   */
  public Integer getQqZuanhuangPayway() {
    return qqZuanhuangPayway;
  }

  public void setQqZuanhuangPayway(Integer qqZuanhuangPayway) {
    this.qqZuanhuangPayway = qqZuanhuangPayway;
  }

  /**
   * 豪华版QQ会员最后一次充值时间
   */
  public Date getQqHaohuaStart() {
    return qqHaohuaStart;
  }

  public void setQqHaohuaStart(Date qqHaohuaStart) {
    this.qqHaohuaStart = qqHaohuaStart;
  }

  /**
   * 豪华版QQ会员期限
   */
  public Date getQqHaohuaEnd() {
    return qqHaohuaEnd;
  }

  public void setQqHaohuaEnd(Date qqHaohuaEnd) {
    this.qqHaohuaEnd = qqHaohuaEnd;
  }

  /**
   * 豪华版QQ会员充值方式
   */
  public Integer getQqHaohuaPayway() {
    return qqHaohuaPayway;
  }

  public void setQqHaohuaPayway(Integer qqHaohuaPayway) {
    this.qqHaohuaPayway = qqHaohuaPayway;
  }

  /**
   * QQ SVIP最后一次充值时间，预留字段，当前信息无效
   */
  public Date getQqSvipStart() {
    return qqSvipStart;
  }

  public void setQqSvipStart(Date qqSvipStart) {
    this.qqSvipStart = qqSvipStart;
  }

  /**
   * QQ SVIP期限，预留字段，当前信息无效
   */
  public Date getQqSvipEnd() {
    return qqSvipEnd;
  }

  public void setQqSvipEnd(Date qqSvipEnd) {
    this.qqSvipEnd = qqSvipEnd;
  }

  /**
   * QQ SVIP充值方式，预留字段，当前信息无效
   */
  public Integer getQqSvipPayway() {
    return qqSvipPayway;
  }

  public void setQqSvipPayway(Integer qqSvipPayway) {
    this.qqSvipPayway = qqSvipPayway;
  }

  /**
   * 非会员历史充值时间，仅在用户是非会员时信息有效
   */
  public Date getHistoryPayTime() {
    return historyPayTime;
  }

  public void setHistoryPayTime(Date historyPayTime) {
    this.historyPayTime = historyPayTime;
  }

  /**
   * 非会员历史充值到期时间，仅在用户是非会员时信息有效
   */
  public Date getHistoryEndTime() {
    return historyEndTime;
  }

  public void setHistoryEndTime(Date historyEndTime) {
    this.historyEndTime = historyEndTime;
  }

  public static User parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    User obj = new User(jsonObject);
    obj.nickname = Result.toString(jsonObject.opt("nickname"));
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
    obj.isQQVip = Result.parseBoolean(jsonObject.opt("is_qq_vip"));
    obj.qqVipLevel = Result.parseInteger(jsonObject.opt("qq_vip_level"));
    obj.isQQYearVip = Result.parseBoolean(jsonObject.opt("is_qq_year_vip"));
    obj.isLost = Result.parseBoolean(jsonObject.opt("is_lost"));
    obj.qqVipStart = Result.parseTimeSeconds(jsonObject.opt("qq_vip_start"));
    obj.qqVipEnd = Result.parseTimeSeconds(jsonObject.opt("qq_vip_end"));
    obj.qqVipPayway = Result.parseInteger(jsonObject.opt("qq_vip_payway"));
    obj.qqYearVipStart = Result.parseTimeSeconds(jsonObject.opt("qq_year_vip_start"));
    obj.qqYearVipEnd = Result.parseTimeSeconds(jsonObject.opt("qq_year_vip_end"));
    obj.qqYearVipPayway = Result.parseInteger(jsonObject.opt("qq_year_vip_payway"));
    obj.qqZuanhuangStart = Result.parseTimeSeconds(jsonObject.opt("qq_zuanhuang_start"));
    obj.qqZuanhuangEnd = Result.parseTimeSeconds(jsonObject.opt("qq_zuanhuang_end"));
    obj.qqZuanhuangPayway = Result.parseInteger(jsonObject.opt("qq_zuanhuang_payway"));
    obj.qqHaohuaStart = Result.parseTimeSeconds(jsonObject.opt("qq_haohua_start"));
    obj.qqHaohuaEnd = Result.parseTimeSeconds(jsonObject.opt("qq_haohua_end"));
    obj.qqHaohuaPayway = Result.parseInteger(jsonObject.opt("qq_haohua_payway"));
    obj.qqSvipStart = Result.parseTimeSeconds(jsonObject.opt("qq_svip_start"));
    obj.qqSvipEnd = Result.parseTimeSeconds(jsonObject.opt("qq_svip_end"));
    obj.qqSvipPayway = Result.parseInteger(jsonObject.opt("qq_svip_payway"));
    obj.historyPayTime = Result.parseTimeSeconds(jsonObject.opt("history_pay_time"));
    obj.historyEndTime = Result.parseTimeSeconds(jsonObject.opt("history_end_time"));
    return obj;
  }

}
