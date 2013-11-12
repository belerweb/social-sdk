package com.belerweb.social.weixin.bean;

import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.belerweb.social.bean.Gender;
import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

/**
 * 微信用户信息
 */
public class User extends JsonBean {

  public User() {}

  private User(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String openId;// 用户的唯一标识
  private String nickname;// 用户昵称
  private Gender gender;// 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
  private String province;// 用户个人资料填写的省份
  private String city;// 普通用户个人资料填写的城市
  private String country;// 国家，如中国为CN
  private List<String> privilege; // 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
  private String language;// 用户的语言，简体中文为zh_CN
  private String headImgUrl;// 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
  private Boolean subscribe;// 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
  private Date subscribeTime;// 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间

  /**
   * 用户的唯一标识
   */
  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  /**
   * 用户昵称
   */
  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  /**
   * 用户的性别
   */
  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  /**
   * 用户个人资料填写的省份
   */
  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  /**
   * 普通用户个人资料填写的城市
   */
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  /**
   * 国家，如中国为CN
   */
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
   */
  public List<String> getPrivilege() {
    return privilege;
  }

  public void setPrivilege(List<String> privilege) {
    this.privilege = privilege;
  }

  /**
   * 用户的语言，简体中文为zh_CN
   */
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  /**
   * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
   */
  public String getHeadImgUrl() {
    return headImgUrl;
  }

  public void setHeadImgUrl(String headImgUrl) {
    this.headImgUrl = headImgUrl;
  }

  /**
   * 用户是否订阅该公众号标识，false 表此用户没有关注该公众号，拉取不到其余信息。
   */
  public Boolean getSubscribe() {
    return subscribe;
  }

  public void setSubscribe(Boolean subscribe) {
    this.subscribe = subscribe;
  }

  /**
   * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
   */
  public Date getSubscribeTime() {
    return subscribeTime;
  }

  public void setSubscribeTime(Date subscribeTime) {
    this.subscribeTime = subscribeTime;
  }

  public static User parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    User obj = new User(jsonObject);
    obj.openId = Result.toString(jsonObject.get("openid"));
    obj.nickname = Result.toString(jsonObject.opt("nickname"));
    obj.gender = Gender.parse(Result.parseInteger(jsonObject.opt("sex")));
    obj.province = Result.toString(jsonObject.opt("province"));
    obj.city = Result.toString(jsonObject.opt("city"));
    obj.country = Result.toString(jsonObject.opt("country"));
    obj.language = Result.toString(jsonObject.opt("language"));
    obj.headImgUrl = Result.toString(jsonObject.opt("headimgurl"));
    obj.subscribe = Result.parseBoolean(jsonObject.opt("subscribe"));
    Long subscribeTime = Result.parseLong(jsonObject.opt("subscribe_time"));
    if (subscribeTime != null) {
      obj.subscribeTime = new Date(subscribeTime * 1000);
    }
    obj.privilege = Result.parse(jsonObject.optJSONArray("privilege"), String.class);
    return obj;
  }

}
