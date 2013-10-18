package com.belerweb.social.weibo.bean;

import java.util.Date;

import org.json.JSONObject;

import com.belerweb.social.bean.Gender;
import com.belerweb.social.bean.OnlineStatus;
import com.belerweb.social.bean.Result;

/**
 * 评论
 * 
 * 文档地址：http://open.weibo.com/wiki/常见返回对象数据结构#.E7.94.A8.E6.88.B7.EF.BC.88user.EF.BC.89
 */
public class User {

  /**
   * 用户UID
   */
  private String id;

  /**
   * 字符串型的用户UID
   */
  private String idstr;

  /**
   * 用户昵称
   */
  private String screenName;

  /**
   * 友好显示名称
   */
  private String name;

  /**
   * 用户所在省级ID
   */
  private Integer province;

  /**
   * 用户所在城市ID
   */
  private Integer city;

  /**
   * 用户所在地
   */
  private String location;

  /**
   * 用户个人描述
   */
  private String description;

  /**
   * 用户博客地址
   */
  private String url;

  /**
   * 用户头像地址，50×50像素
   */
  private String profileImageUrl;

  /**
   * 用户的微博统一URL地址
   */
  private String profileUrl;

  /**
   * 用户的个性化域名
   */
  private String domain;

  /**
   * 用户的微号
   */
  private String weihao;

  /**
   * 性别
   */
  private Gender gender;

  /**
   * 粉丝数
   */
  private Integer followersCount;

  /**
   * 关注数
   */
  private Integer friendsCount;

  /**
   * 微博数
   */
  private Integer statusesCount;

  /**
   * 收藏数
   */
  private Integer favouritesCount;

  /**
   * 用户创建（注册）时间
   */
  private Date createdAt;

  /**
   * 暂未支持
   */
  private Boolean following;

  /**
   * 是否允许所有人给我发私信
   */
  private Boolean allowAllActMsg;

  /**
   * 是否允许标识用户的地理位置
   */
  private Boolean geoEnabled;

  /**
   * 是否是微博认证用户，即加V用户
   */
  private Boolean verified;

  /**
   * 暂未支持
   */
  private Integer verifiedType;

  /**
   * 用户备注信息，只有在查询用户关系时才返回此字段
   */
  private String remark;

  /**
   * 用户的最近一条微博信息字段 详细
   */
  private Status status;

  /**
   * 是否允许所有人对我的微博进行评论
   */
  private Boolean allowAllComment;

  /**
   * 用户大头像地址
   */
  private String avatarLarge;

  /**
   * 认证原因
   */
  private String verifiedReason;

  /**
   * 该用户是否关注当前登录用户
   */
  private Boolean followMe;

  /**
   * 用户的在线状态
   */
  private OnlineStatus onlineStatus;

  /**
   * 用户的互粉数
   */
  private Integer biFollowersCount;

  /**
   * 用户当前的语言版本，zh-cn：简体中文，zh-tw：繁体中文，en：英语
   */
  private String lang;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getIdstr() {
    return idstr;
  }

  public void setIdstr(String idstr) {
    this.idstr = idstr;
  }

  public String getScreenName() {
    return screenName;
  }

  public void setScreenName(String screenName) {
    this.screenName = screenName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getProvince() {
    return province;
  }

  public void setProvince(Integer province) {
    this.province = province;
  }

  public Integer getCity() {
    return city;
  }

  public void setCity(Integer city) {
    this.city = city;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getProfileImageUrl() {
    return profileImageUrl;
  }

  public void setProfileImageUrl(String profileImageUrl) {
    this.profileImageUrl = profileImageUrl;
  }

  public String getProfileUrl() {
    return profileUrl;
  }

  public void setProfile_url(String profileUrl) {
    this.profileUrl = profileUrl;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public String getWeihao() {
    return weihao;
  }

  public void setWeihao(String weihao) {
    this.weihao = weihao;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Integer getFollowersCount() {
    return followersCount;
  }

  public void setFollowersCount(Integer followersCount) {
    this.followersCount = followersCount;
  }

  public Integer getFriendsCount() {
    return friendsCount;
  }

  public void setFriendsCount(Integer friendsCount) {
    this.friendsCount = friendsCount;
  }

  public Integer getStatusesCount() {
    return statusesCount;
  }

  public void setStatusesCount(Integer statusesCount) {
    this.statusesCount = statusesCount;
  }

  public Integer getFavouritesCount() {
    return favouritesCount;
  }

  public void setFavouritesCount(Integer favouritesCount) {
    this.favouritesCount = favouritesCount;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Boolean getFollowing() {
    return following;
  }

  public void setFollowing(Boolean following) {
    this.following = following;
  }

  public Boolean getAllowAllActMsg() {
    return allowAllActMsg;
  }

  public void setAllowAllActMsg(Boolean allowAllActMsg) {
    this.allowAllActMsg = allowAllActMsg;
  }

  public Boolean getGeoEnabled() {
    return geoEnabled;
  }

  public void setGeoEnabled(Boolean geoEnabled) {
    this.geoEnabled = geoEnabled;
  }

  public Boolean getVerified() {
    return verified;
  }

  public void setVerified(Boolean verified) {
    this.verified = verified;
  }

  public Integer getVerifiedType() {
    return verifiedType;
  }

  public void setVerifiedType(Integer verifiedType) {
    this.verifiedType = verifiedType;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Boolean getAllowAllComment() {
    return allowAllComment;
  }

  public void setAllowAllComment(Boolean allowAllComment) {
    this.allowAllComment = allowAllComment;
  }

  public String getAvatarLarge() {
    return avatarLarge;
  }

  public void setAvatarLarge(String avatarLarge) {
    this.avatarLarge = avatarLarge;
  }

  public String getVerifiedReason() {
    return verifiedReason;
  }

  public void setVerifiedReason(String verifiedReason) {
    this.verifiedReason = verifiedReason;
  }

  public Boolean getFollowMe() {
    return followMe;
  }

  public void setFollowMe(Boolean followMe) {
    this.followMe = followMe;
  }

  public OnlineStatus getOnlineStatus() {
    return onlineStatus;
  }

  public void setOnlineStatus(OnlineStatus onlineStatus) {
    this.onlineStatus = onlineStatus;
  }

  public Integer getBiFollowersCount() {
    return biFollowersCount;
  }

  public void setBiFollowersCount(Integer biFollowersCount) {
    this.biFollowersCount = biFollowersCount;
  }

  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

  public static User parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    User obj = new User();
    obj.id = Result.toString(jsonObject.get("id"));
    obj.idstr = Result.toString(jsonObject.opt("idstr"));
    obj.screenName = Result.toString(jsonObject.opt("screen_name"));
    obj.name = Result.toString(jsonObject.opt("name"));
    obj.province = Result.perseInteger(jsonObject.opt("province"));
    obj.city = Result.perseInteger(jsonObject.opt("city"));
    obj.location = Result.toString(jsonObject.opt("location"));
    obj.description = Result.toString(jsonObject.opt("description"));
    obj.url = Result.toString(jsonObject.opt("url"));
    obj.profileImageUrl = Result.toString(jsonObject.opt("profile_image_url"));
    obj.profileUrl = Result.toString(jsonObject.opt("profile_url"));
    obj.domain = Result.toString(jsonObject.opt("domain"));
    obj.weihao = Result.toString(jsonObject.opt("weihao"));
    obj.gender = Gender.parse(jsonObject.optString("gender"));
    obj.followersCount = Result.perseInteger(jsonObject.opt("followers_count"));
    obj.friendsCount = Result.perseInteger(jsonObject.opt("friends_count"));
    obj.statusesCount = Result.perseInteger(jsonObject.opt("statuses_count"));
    obj.favouritesCount = Result.perseInteger(jsonObject.opt("favourites_count"));
    obj.createdAt = Result.perseDate(jsonObject.opt("created_at"));
    obj.following = Result.perseBoolean(jsonObject.opt("following"));
    obj.allowAllActMsg = Result.perseBoolean(jsonObject.opt("allow_all_act_msg"));
    obj.geoEnabled = Result.perseBoolean(jsonObject.opt("geo_enabled"));
    obj.verified = Result.perseBoolean(jsonObject.opt("verified"));
    obj.verifiedType = Result.perseInteger(jsonObject.opt("verified_type"));
    obj.remark = Result.toString(jsonObject.opt("remark"));
    obj.status = Status.parse(jsonObject.optJSONObject("status"));
    obj.allowAllComment = Result.perseBoolean(jsonObject.opt("allow_all_comment"));
    obj.avatarLarge = Result.toString(jsonObject.opt("avatar_large"));
    obj.verifiedReason = Result.toString(jsonObject.opt("verified_reason"));
    obj.followMe = Result.perseBoolean(jsonObject.opt("follow_me"));
    obj.onlineStatus =
        OnlineStatus.parse(Result.perseInteger(jsonObject.optString("online_status")));
    obj.biFollowersCount = Result.perseInteger(jsonObject.opt("bi_followers_count"));
    obj.lang = Result.toString(jsonObject.opt("lang"));
    return obj;
  }
}
