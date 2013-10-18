package com.belerweb.social.weibo.bean;

import org.json.JSONObject;

/**
 * 消息未读数
 */
public class Remind {

  /**
   * 新微博未读数
   */
  private Integer status;

  /**
   * 新粉丝数
   */
  private Integer follower;

  /**
   * 新评论数
   */
  private Integer cmt;

  /**
   * 新私信数
   */
  private Integer dm;

  /**
   * 新提及我的微博数
   */
  private Integer mentionStatus;

  /**
   * 新提及我的评论数
   */
  private Integer mentionCmt;

  /**
   * 微群消息未读数
   */
  private Integer group;

  /**
   * 私有微群消息未读数
   */
  private Integer privateGroup;

  /**
   * 新通知未读数
   */
  private Integer notice;

  /**
   * 新邀请未读数
   */
  private Integer invite;

  /**
   * 新勋章数
   */
  private Integer badge;

  /**
   * 相册消息未读数
   */
  private Integer photo;

  /**
   * 消息未读数
   */
  private Integer msgbox;

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getFollower() {
    return follower;
  }

  public void setFollower(Integer follower) {
    this.follower = follower;
  }

  public Integer getCmt() {
    return cmt;
  }

  public void setCmt(Integer cmt) {
    this.cmt = cmt;
  }

  public Integer getDm() {
    return dm;
  }

  public void setDm(Integer dm) {
    this.dm = dm;
  }

  public Integer getMentionStatus() {
    return mentionStatus;
  }

  public void setMentionStatus(Integer mentionStatus) {
    this.mentionStatus = mentionStatus;
  }

  public Integer getMentionCmt() {
    return mentionCmt;
  }

  public void setMentionCmt(Integer mentionCmt) {
    this.mentionCmt = mentionCmt;
  }

  public Integer getGroup() {
    return group;
  }

  public void setGroup(Integer group) {
    this.group = group;
  }

  public Integer getPrivateGroup() {
    return privateGroup;
  }

  public void setPrivateGroup(Integer privateGroup) {
    this.privateGroup = privateGroup;
  }

  public Integer getNotice() {
    return notice;
  }

  public void setNotice(Integer notice) {
    this.notice = notice;
  }

  public Integer getInvite() {
    return invite;
  }

  public void setInvite(Integer invite) {
    this.invite = invite;
  }

  public Integer getBadge() {
    return badge;
  }

  public void setBadge(Integer badge) {
    this.badge = badge;
  }

  public Integer getPhoto() {
    return photo;
  }

  public void setPhoto(Integer photo) {
    this.photo = photo;
  }

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
    obj.status = Result.perseInteger(jsonObject.opt("status"));
    obj.follower = Result.perseInteger(jsonObject.opt("follower"));
    obj.cmt = Result.perseInteger(jsonObject.opt("cmt"));
    obj.dm = Result.perseInteger(jsonObject.opt("dm"));
    obj.mentionStatus = Result.perseInteger(jsonObject.opt("mention_status"));
    obj.mentionCmt = Result.perseInteger(jsonObject.opt("mention_cmt"));
    obj.group = Result.perseInteger(jsonObject.opt("group"));
    obj.privateGroup = Result.perseInteger(jsonObject.opt("private_group"));
    obj.notice = Result.perseInteger(jsonObject.opt("notice"));
    obj.invite = Result.perseInteger(jsonObject.opt("invite"));
    obj.badge = Result.perseInteger(jsonObject.opt("badge"));
    obj.photo = Result.perseInteger(jsonObject.opt("photo"));
    obj.msgbox = Result.perseInteger(jsonObject.opt("msgbox"));
    return obj;
  }
}
