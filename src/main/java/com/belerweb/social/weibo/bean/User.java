package com.belerweb.social.weibo.bean;

import java.util.Date;
import java.util.Locale;

import org.json.JSONObject;

import com.belerweb.social.bean.Gender;
import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.OnlineStatus;
import com.belerweb.social.bean.Result;

/**
 * 用户
 * 
 * 文档地址：http://open.weibo.com/wiki/常见返回对象数据结构#.E7.94.A8.E6.88.B7.EF.BC.88user.EF.BC.89
 */
public class User extends JsonBean {

  public User() {}

  private User(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String id;// 用户UID
  private String idstr;// 字符串型的用户UID
  private String screenName;// 用户昵称
  private String name;// screenName
  private Integer province;// 用户所在省级ID
  private Integer city;// 用户所在城市ID
  private String location;// 用户所在地
  private String description;// 用户个人描述
  private String url;// 用户博客地址
  private String profileImageUrl;// 用户头像地址，50×50像素
  private String profileUrl;// 用户的微博统一URL地址
  private String domain;// 用户的个性化域名
  private String weihao;// 用户的微号
  private Gender gender;// 性别
  private Integer followersCount;// 粉丝数
  private Integer friendsCount;// 关注数
  private Integer statusesCount;// 微博数
  private Integer favouritesCount;// 收藏数
  private Date createdAt;// 用户创建（注册）时间
  private Boolean following;// 暂未支持
  private Boolean allowAllActMsg;// 是否允许所有人给我发私信
  private Boolean geoEnabled;// 是否允许标识用户的地理位置
  private Boolean verified;// 是否是微博认证用户，即加V用户
  private Integer verifiedType;// 暂未支持
  private String remark;// 用户备注信息，只有在查询用户关系时才返回此字段
  private Status status;// 用户的最近一条微博信息字段 详细
  private Boolean allowAllComment;// 是否允许所有人对我的微博进行评论
  private String avatarLarge;// 用户大头像地址
  private String verifiedReason;// 认证原因
  private Boolean followMe;// 该用户是否关注当前登录用户
  private OnlineStatus onlineStatus;// 用户的在线状态
  private Integer biFollowersCount;// 用户的互粉数
  private String lang;// 用户当前的语言版本，zh-cn：简体中文，zh-tw：繁体中文，en：英语

  /**
   * 用户UID
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  /**
   * 字符串型的用户UID
   */
  public String getIdstr() {
    return idstr;
  }

  public void setIdstr(String idstr) {
    this.idstr = idstr;
  }

  /**
   * 用户昵称
   */
  public String getScreenName() {
    return screenName;
  }

  public void setScreenName(String screenName) {
    this.screenName = screenName;
  }

  /**
   * 友好显示名称
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * 用户所在省级ID
   */
  public Integer getProvince() {
    return province;
  }

  public void setProvince(Integer province) {
    this.province = province;
  }

  /**
   * 用户所在城市ID
   */
  public Integer getCity() {
    return city;
  }

  public void setCity(Integer city) {
    this.city = city;
  }

  /**
   * 用户所在地
   */
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  /**
   * 用户个人描述
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * 用户博客地址
   */
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * 用户头像地址，50×50像素
   */
  public String getProfileImageUrl() {
    return profileImageUrl;
  }

  public void setProfileImageUrl(String profileImageUrl) {
    this.profileImageUrl = profileImageUrl;
  }

  /**
   * 用户的微博统一URL地址
   */
  public String getProfileUrl() {
    return profileUrl;
  }

  public void setProfileUrl(String profileUrl) {
    this.profileUrl = profileUrl;
  }

  /**
   * 用户的个性化域名
   */
  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  /**
   * 用户的微号
   */
  public String getWeihao() {
    return weihao;
  }

  public void setWeihao(String weihao) {
    this.weihao = weihao;
  }

  /**
   * 性别
   */
  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  /**
   * 粉丝数
   */
  public Integer getFollowersCount() {
    return followersCount;
  }

  public void setFollowersCount(Integer followersCount) {
    this.followersCount = followersCount;
  }

  /**
   * 关注数
   */
  public Integer getFriendsCount() {
    return friendsCount;
  }

  public void setFriendsCount(Integer friendsCount) {
    this.friendsCount = friendsCount;
  }

  /**
   * 微博数
   */
  public Integer getStatusesCount() {
    return statusesCount;
  }

  public void setStatusesCount(Integer statusesCount) {
    this.statusesCount = statusesCount;
  }

  /**
   * 收藏数
   */
  public Integer getFavouritesCount() {
    return favouritesCount;
  }

  public void setFavouritesCount(Integer favouritesCount) {
    this.favouritesCount = favouritesCount;
  }

  /**
   * 用户创建（注册）时间
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * 暂未支持
   */
  public Boolean getFollowing() {
    return following;
  }

  public void setFollowing(Boolean following) {
    this.following = following;
  }

  /**
   * 是否允许所有人给我发私信
   */
  public Boolean getAllowAllActMsg() {
    return allowAllActMsg;
  }

  public void setAllowAllActMsg(Boolean allowAllActMsg) {
    this.allowAllActMsg = allowAllActMsg;
  }

  /**
   * 是否允许标识用户的地理位置
   */
  public Boolean getGeoEnabled() {
    return geoEnabled;
  }

  public void setGeoEnabled(Boolean geoEnabled) {
    this.geoEnabled = geoEnabled;
  }

  /**
   * 是否是微博认证用户，即加V用户
   */
  public Boolean getVerified() {
    return verified;
  }

  public void setVerified(Boolean verified) {
    this.verified = verified;
  }

  /**
   * 暂未支持
   */
  public Integer getVerifiedType() {
    return verifiedType;
  }

  public void setVerifiedType(Integer verifiedType) {
    this.verifiedType = verifiedType;
  }

  /**
   * 用户备注信息，只有在查询用户关系时才返回此字段
   */
  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  /**
   * 用户的最近一条微博信息字段 详细
   */
  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  /**
   * 是否允许所有人对我的微博进行评论
   */
  public Boolean getAllowAllComment() {
    return allowAllComment;
  }

  public void setAllowAllComment(Boolean allowAllComment) {
    this.allowAllComment = allowAllComment;
  }

  /**
   * 用户大头像地址
   */
  public String getAvatarLarge() {
    return avatarLarge;
  }

  public void setAvatarLarge(String avatarLarge) {
    this.avatarLarge = avatarLarge;
  }

  /**
   * 认证原因
   */
  public String getVerifiedReason() {
    return verifiedReason;
  }

  public void setVerifiedReason(String verifiedReason) {
    this.verifiedReason = verifiedReason;
  }

  /**
   * 该用户是否关注当前登录用户
   */
  public Boolean getFollowMe() {
    return followMe;
  }

  public void setFollowMe(Boolean followMe) {
    this.followMe = followMe;
  }

  /**
   * 用户的在线状态
   */
  public OnlineStatus getOnlineStatus() {
    return onlineStatus;
  }

  public void setOnlineStatus(OnlineStatus onlineStatus) {
    this.onlineStatus = onlineStatus;
  }

  /**
   * 用户的互粉数
   */
  public Integer getBiFollowersCount() {
    return biFollowersCount;
  }

  public void setBiFollowersCount(Integer biFollowersCount) {
    this.biFollowersCount = biFollowersCount;
  }

  /**
   * 用户当前的语言版本，zh-cn：简体中文，zh-tw：繁体中文，en：英语
   */
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
    User obj = new User(jsonObject);
    obj.id = Result.toString(jsonObject.get("id"));
    obj.idstr = Result.toString(jsonObject.opt("idstr"));
    obj.screenName = Result.toString(jsonObject.opt("screen_name"));
    obj.name = Result.toString(jsonObject.opt("name"));
    obj.province = Result.parseInteger(jsonObject.opt("province"));
    obj.city = Result.parseInteger(jsonObject.opt("city"));
    obj.location = Result.toString(jsonObject.opt("location"));
    obj.description = Result.toString(jsonObject.opt("description"));
    obj.url = Result.toString(jsonObject.opt("url"));
    obj.profileImageUrl = Result.toString(jsonObject.opt("profile_image_url"));
    obj.profileUrl = Result.toString(jsonObject.opt("profile_url"));
    obj.domain = Result.toString(jsonObject.opt("domain"));
    obj.weihao = Result.toString(jsonObject.opt("weihao"));
    obj.gender = Gender.parse(jsonObject.optString("gender", null));
    obj.followersCount = Result.parseInteger(jsonObject.opt("followers_count"));
    obj.friendsCount = Result.parseInteger(jsonObject.opt("friends_count"));
    obj.statusesCount = Result.parseInteger(jsonObject.opt("statuses_count"));
    obj.favouritesCount = Result.parseInteger(jsonObject.opt("favourites_count"));
    obj.createdAt =
        Result
            .parseDate(jsonObject.opt("created_at"), "EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
    obj.following = Result.parseBoolean(jsonObject.opt("following"));
    obj.allowAllActMsg = Result.parseBoolean(jsonObject.opt("allow_all_act_msg"));
    obj.geoEnabled = Result.parseBoolean(jsonObject.opt("geo_enabled"));
    obj.verified = Result.parseBoolean(jsonObject.opt("verified"));
    obj.verifiedType = Result.parseInteger(jsonObject.opt("verified_type"));
    obj.remark = Result.toString(jsonObject.opt("remark"));
    obj.status = Status.parse(jsonObject.optJSONObject("status"));
    obj.allowAllComment = Result.parseBoolean(jsonObject.opt("allow_all_comment"));
    obj.avatarLarge = Result.toString(jsonObject.opt("avatar_large"));
    obj.verifiedReason = Result.toString(jsonObject.opt("verified_reason"));
    obj.followMe = Result.parseBoolean(jsonObject.opt("follow_me"));
    obj.onlineStatus =
        OnlineStatus.parse(Result.parseInteger(jsonObject.optString("online_status")));
    obj.biFollowersCount = Result.parseInteger(jsonObject.opt("bi_followers_count"));
    obj.lang = Result.toString(jsonObject.opt("lang"));
    return obj;
  }
}
