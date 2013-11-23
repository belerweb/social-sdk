package com.belerweb.social.qq.connect.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONObject;

import com.belerweb.social.bean.Gender;
import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

public class WeiboUser extends JsonBean {

  public WeiboUser() {}

  private WeiboUser(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String openId;// 登录用户的唯一ID，与name一一对应。
  private String name;// 登录用户的帐号名
  private String nick;// 登录用户昵称。
  private Date regTime;// 登录注册时间。
  private Date birth;
  private String countryCode;
  private String provinceCode;
  private String cityCode;
  private List<Company> companies;
  private List<Education> educations;
  private Integer fansNum;// 登录用户听众数。
  private Integer favNum;// 登录用户收藏数。
  private String head;
  private String homeCountryCode;// 登录用户家乡所在国家代码。
  private String homeProvinceCode;// 登录用户家乡所在省份代码。
  private String homeCityCode;// 登录用户家乡所在城市代码。
  private String hometownCode;// 登录用户家乡所在城镇代码。
  private String homepage;// 个人主页。
  private Integer idolNum;// 登录用户收听的人数。
  private String industryCode;// 行业ID。
  private String introduction;// 登录用户的个人介绍。
  private Boolean isEnt;// 登录用户是否为企业机构
  private Boolean isMyBlack;// 是否在当前用户的黑名单中
  private Boolean isMyFans;// 是否是当前用户的听众
  private Boolean isMyIdol;// 是否是当前用户的偶像
  private Boolean isRealName;// 登录用户是否实名认证
  private Boolean isVip;// 登录用户是否为微博认证用户
  private String location;// 登录用户所在地。
  private Integer mutualFansNum;// 登录用户的互听好友数
  private SendPrivate sendPrivate;// 是否允许所有人给当前用户发私信。
  private Gender gender;
  private List<Tag> tags;
  private List<TweetInfo> tweets;
  private Integer tweetNum;
  private String verifyInfo;
  private Integer exp;
  private Integer level;
  private String seqId;

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNick() {
    return nick;
  }

  public void setNick(String nick) {
    this.nick = nick;
  }

  public Date getRegTime() {
    return regTime;
  }

  public void setRegTime(Date regTime) {
    this.regTime = regTime;
  }

  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth = birth;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getProvinceCode() {
    return provinceCode;
  }

  public void setProvinceCode(String provinceCode) {
    this.provinceCode = provinceCode;
  }

  public String getCityCode() {
    return cityCode;
  }

  public void setCityCode(String cityCode) {
    this.cityCode = cityCode;
  }

  public List<Company> getCompanies() {
    return companies;
  }

  public void setCompanies(List<Company> companies) {
    this.companies = companies;
  }

  public List<Education> getEducations() {
    return educations;
  }

  public void setEducations(List<Education> educations) {
    this.educations = educations;
  }

  public Integer getFansNum() {
    return fansNum;
  }

  public void setFansNum(Integer fansNum) {
    this.fansNum = fansNum;
  }

  public Integer getFavNum() {
    return favNum;
  }

  public void setFavNum(Integer favNum) {
    this.favNum = favNum;
  }

  public String getHead() {
    return head;
  }

  public void setHead(String head) {
    this.head = head;
  }

  public String getHomeCountryCode() {
    return homeCountryCode;
  }

  public void setHomeCountryCode(String homeCountryCode) {
    this.homeCountryCode = homeCountryCode;
  }

  public String getHomeProvinceCode() {
    return homeProvinceCode;
  }

  public void setHomeProvinceCode(String homeProvinceCode) {
    this.homeProvinceCode = homeProvinceCode;
  }

  public String getHomeCityCode() {
    return homeCityCode;
  }

  public void setHomeCityCode(String homeCityCode) {
    this.homeCityCode = homeCityCode;
  }

  public String getHometownCode() {
    return hometownCode;
  }

  public void setHometownCode(String hometownCode) {
    this.hometownCode = hometownCode;
  }

  public String getHomepage() {
    return homepage;
  }

  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }

  public Integer getIdolNum() {
    return idolNum;
  }

  public void setIdolNum(Integer idolNum) {
    this.idolNum = idolNum;
  }

  public String getIndustryCode() {
    return industryCode;
  }

  public void setIndustryCode(String industryCode) {
    this.industryCode = industryCode;
  }

  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }

  public Boolean getIsEnt() {
    return isEnt;
  }

  public void setIsEnt(Boolean isEnt) {
    this.isEnt = isEnt;
  }

  public Boolean getIsMyBlack() {
    return isMyBlack;
  }

  public void setIsMyBlack(Boolean isMyBlack) {
    this.isMyBlack = isMyBlack;
  }

  public Boolean getIsMyFans() {
    return isMyFans;
  }

  public void setIsMyFans(Boolean isMyFans) {
    this.isMyFans = isMyFans;
  }

  public Boolean getIsMyIdol() {
    return isMyIdol;
  }

  public void setIsMyIdol(Boolean isMyIdol) {
    this.isMyIdol = isMyIdol;
  }

  public Boolean getIsRealName() {
    return isRealName;
  }

  public void setIsRealName(Boolean isRealName) {
    this.isRealName = isRealName;
  }

  public Boolean getIsVip() {
    return isVip;
  }

  public void setIsVip(Boolean isVip) {
    this.isVip = isVip;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Integer getMutualFansNum() {
    return mutualFansNum;
  }

  public void setMutualFansNum(Integer mutualFansNum) {
    this.mutualFansNum = mutualFansNum;
  }

  public SendPrivate getSendPrivate() {
    return sendPrivate;
  }

  public void setSendPrivate(SendPrivate sendPrivate) {
    this.sendPrivate = sendPrivate;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public List<Tag> getTags() {
    return tags;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }

  public List<TweetInfo> getTweets() {
    return tweets;
  }

  public void setTweets(List<TweetInfo> tweets) {
    this.tweets = tweets;
  }

  public Integer getTweetNum() {
    return tweetNum;
  }

  public void setTweetNum(Integer tweetNum) {
    this.tweetNum = tweetNum;
  }

  public String getVerifyInfo() {
    return verifyInfo;
  }

  public void setVerifyInfo(String verifyInfo) {
    this.verifyInfo = verifyInfo;
  }

  public Integer getExp() {
    return exp;
  }

  public void setExp(Integer exp) {
    this.exp = exp;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public String getSeqId() {
    return seqId;
  }

  public void setSeqId(String seqId) {
    this.seqId = seqId;
  }

  public static WeiboUser parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    WeiboUser obj = new WeiboUser(jsonObject);
    obj.openId = Result.toString(jsonObject.get("openid"));
    obj.name = Result.toString(jsonObject.opt("name"));
    obj.nick = Result.toString(jsonObject.opt("nick"));
    obj.regTime = Result.parseTimeSeconds(jsonObject.opt("regtime"));
    Object year = jsonObject.get("birth_year");
    Object month = jsonObject.get("birth_month");
    Object day = jsonObject.get("birth_day");
    obj.birth =
        Result.parseDate(year.toString() + month.toString() + day.toString(), "yyyy-MM-dd",
            Locale.CHINA);
    obj.countryCode = Result.toString(jsonObject.opt("country_code"));
    obj.provinceCode = Result.toString(jsonObject.opt("province_code"));
    obj.cityCode = Result.toString(jsonObject.opt("city_code"));
    JSONArray jsonArray = jsonObject.optJSONArray("comp");
    if (jsonArray != null) {
      List<Company> companies = new ArrayList<Company>();
      for (int i = 0; i < jsonArray.length(); i++) {
        companies.add(Company.parse(jsonArray.optJSONObject(i)));
      }
      obj.companies = companies;
    }
    jsonArray = jsonObject.optJSONArray("edu");
    if (jsonArray != null) {
      List<Education> educations = new ArrayList<Education>();
      for (int i = 0; i < jsonArray.length(); i++) {
        educations.add(Education.parse(jsonArray.optJSONObject(i)));
      }
      obj.educations = educations;
    }
    obj.fansNum = Result.parseInteger(jsonObject.opt("fansnum"));
    obj.favNum = Result.parseInteger(jsonObject.opt("favnum"));
    obj.head = Result.toString(jsonObject.opt("head"));
    obj.homeCountryCode = Result.toString(jsonObject.opt("homecountry_code"));
    obj.homeProvinceCode = Result.toString(jsonObject.opt("homeprovince_code"));
    obj.homeCityCode = Result.toString(jsonObject.opt("homecity_code"));
    obj.hometownCode = Result.toString(jsonObject.opt("hometown_code"));
    obj.homepage = Result.toString(jsonObject.opt("homepage"));
    obj.idolNum = Result.parseInteger(jsonObject.opt("idolnum"));
    obj.industryCode = Result.toString(jsonObject.opt("industry_code"));
    obj.introduction = Result.toString(jsonObject.opt("introduction"));
    obj.isEnt = Result.parseBoolean(jsonObject.opt("isent"));
    obj.isMyBlack = Result.parseBoolean(jsonObject.opt("ismyblack"));
    obj.isMyFans = Result.parseBoolean(jsonObject.opt("ismyfans"));
    obj.isMyIdol = Result.parseBoolean(jsonObject.opt("isMyIdol"));
    obj.isRealName = Result.parseBoolean(jsonObject.opt("isrealname"));
    obj.isVip = Result.parseBoolean(jsonObject.opt("isvip"));
    obj.location = Result.toString(jsonObject.opt("location"));
    obj.mutualFansNum = Result.parseInteger(jsonObject.opt("mutual_fans_num"));
    obj.sendPrivate = SendPrivate.parse(Result.parseInteger(jsonObject.opt("send_private_flag")));
    obj.gender = Gender.parse(Result.parseInteger(jsonObject.opt("sex")));
    jsonArray = jsonObject.optJSONArray("tag");
    if (jsonArray != null) {
      List<Tag> tags = new ArrayList<Tag>();
      for (int i = 0; i < jsonArray.length(); i++) {
        tags.add(Tag.parse(jsonArray.optJSONObject(i)));
      }
      obj.tags = tags;
    }
    jsonArray = jsonObject.optJSONArray("tweetinfo");
    if (jsonArray != null) {
      List<TweetInfo> tweets = new ArrayList<TweetInfo>();
      for (int i = 0; i < jsonArray.length(); i++) {
        tweets.add(TweetInfo.parse(jsonArray.optJSONObject(i)));
      }
      obj.tweets = tweets;
    }
    obj.tweetNum = Result.parseInteger(jsonObject.opt("tweetnum"));
    obj.verifyInfo = Result.toString(jsonObject.opt("verifyinfo"));
    obj.exp = Result.parseInteger(jsonObject.opt("exp"));
    obj.level = Result.parseInteger(jsonObject.opt("level"));
    obj.seqId = Result.toString(jsonObject.opt("seqid"));
    return obj;
  }
}
