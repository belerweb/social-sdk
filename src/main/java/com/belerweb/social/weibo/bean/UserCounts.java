package com.belerweb.social.weibo.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

/**
 * 用户的粉丝数、关注数、微博数
 */
public class UserCounts extends JsonBean {

  public UserCounts() {}

  private UserCounts(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String id;// 微博ID
  private Integer followersCount;// 粉丝数
  private Integer friendsCount;// 关注数
  private Integer statusesCount;// 微博数
  private Integer privateFriendsCount;// 暂未支持

  /**
   * 微博ID
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
   * 暂未支持
   */
  public Integer getPrivateFriendsCount() {
    return privateFriendsCount;
  }

  public void setPrivateFriendsCount(Integer privateFriendsCount) {
    this.privateFriendsCount = privateFriendsCount;
  }


  public static UserCounts parse(JSONObject jsonObject) {
    UserCounts obj = new UserCounts(jsonObject);
    obj.id = Result.toString(jsonObject.get("uid"));
    obj.followersCount = Result.parseInteger(jsonObject.opt("followers_count"));
    obj.friendsCount = Result.parseInteger(jsonObject.opt("friends_count"));
    obj.statusesCount = Result.parseInteger(jsonObject.opt("statuses_count"));
    obj.privateFriendsCount = Result.parseInteger(jsonObject.opt("private_friends_count"));
    return obj;
  }

}
