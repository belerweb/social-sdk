package com.belerweb.social.weibo.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.Result;

/**
 * 用户的粉丝数、关注数、微博数
 */
public class UserCounts {

  /**
   * 微博ID
   */
  private String id;

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
   * 暂未支持
   */
  private Integer privateFriendsCount;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public Integer getPrivateFriendsCount() {
    return privateFriendsCount;
  }

  public void setPrivateFriendsCount(Integer privateFriendsCount) {
    this.privateFriendsCount = privateFriendsCount;
  }


  public static UserCounts parse(JSONObject jsonObject) {
    UserCounts obj = new UserCounts();
    obj.id = Result.toString(jsonObject.get("uid"));
    obj.followersCount = Result.parseInteger(jsonObject.opt("followers_count"));
    obj.friendsCount = Result.parseInteger(jsonObject.opt("friends_count"));
    obj.statusesCount = Result.parseInteger(jsonObject.opt("statuses_count"));
    obj.privateFriendsCount = Result.parseInteger(jsonObject.opt("private_friends_count"));
    return obj;
  }

}
