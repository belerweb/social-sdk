package com.belerweb.social.weibo.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.Result;

/**
 * 消息未读数
 */
public class Remind {

  private Integer status;// 新微博未读数
  private Integer follower;// 新粉丝数
  private Integer cmt;// 新评论数
  private Integer dm;// 新私信数
  private Integer mentionStatus;// 新提及我的微博数
  private Integer mentionCmt;// 新提及我的评论数
  private Integer group;// 微群消息未读数
  private Integer privateGroup;// 私有微群消息未读数
  private Integer notice;// 新通知未读数
  private Integer invite;// 新邀请未读数
  private Integer badge;// 新勋章数
  private Integer photo;// 相册消息未读数
  private Integer msgbox;// 消息未读数

  /**
   * 新微博未读数
   */
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * 新粉丝数
   */
  public Integer getFollower() {
    return follower;
  }

  public void setFollower(Integer follower) {
    this.follower = follower;
  }

  /**
   * 新评论数
   */
  public Integer getCmt() {
    return cmt;
  }

  public void setCmt(Integer cmt) {
    this.cmt = cmt;
  }

  /**
   * 新私信数
   */
  public Integer getDm() {
    return dm;
  }

  public void setDm(Integer dm) {
    this.dm = dm;
  }

  /**
   * 新提及我的微博数
   */
  public Integer getMentionStatus() {
    return mentionStatus;
  }

  public void setMentionStatus(Integer mentionStatus) {
    this.mentionStatus = mentionStatus;
  }

  /**
   * 新提及我的评论数
   */
  public Integer getMentionCmt() {
    return mentionCmt;
  }

  public void setMentionCmt(Integer mentionCmt) {
    this.mentionCmt = mentionCmt;
  }

  /**
   * 微群消息未读数
   */
  public Integer getGroup() {
    return group;
  }

  public void setGroup(Integer group) {
    this.group = group;
  }

  /**
   * 私有微群消息未读数
   */
  public Integer getPrivateGroup() {
    return privateGroup;
  }

  public void setPrivateGroup(Integer privateGroup) {
    this.privateGroup = privateGroup;
  }

  /**
   * 新通知未读数
   */
  public Integer getNotice() {
    return notice;
  }

  public void setNotice(Integer notice) {
    this.notice = notice;
  }

  /**
   * 新邀请未读数
   */
  public Integer getInvite() {
    return invite;
  }

  public void setInvite(Integer invite) {
    this.invite = invite;
  }

  /**
   * 新勋章数
   */
  public Integer getBadge() {
    return badge;
  }

  public void setBadge(Integer badge) {
    this.badge = badge;
  }

  /**
   * 相册消息未读数
   */
  public Integer getPhoto() {
    return photo;
  }

  public void setPhoto(Integer photo) {
    this.photo = photo;
  }

  /**
   * 消息未读数
   */
  public Integer getMsgbox() {
    return msgbox;
  }

  public void setMsgbox(Integer msgbox) {
    this.msgbox = msgbox;
  }

  public static Remind parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    Remind obj = new Remind();
    obj.status = Result.parseInteger(jsonObject.opt("status"));
    obj.follower = Result.parseInteger(jsonObject.opt("follower"));
    obj.cmt = Result.parseInteger(jsonObject.opt("cmt"));
    obj.dm = Result.parseInteger(jsonObject.opt("dm"));
    obj.mentionStatus = Result.parseInteger(jsonObject.opt("mention_status"));
    obj.mentionCmt = Result.parseInteger(jsonObject.opt("mention_cmt"));
    obj.group = Result.parseInteger(jsonObject.opt("group"));
    obj.privateGroup = Result.parseInteger(jsonObject.opt("private_group"));
    obj.notice = Result.parseInteger(jsonObject.opt("notice"));
    obj.invite = Result.parseInteger(jsonObject.opt("invite"));
    obj.badge = Result.parseInteger(jsonObject.opt("badge"));
    obj.photo = Result.parseInteger(jsonObject.opt("photo"));
    obj.msgbox = Result.parseInteger(jsonObject.opt("msgbox"));
    return obj;
  }
}
