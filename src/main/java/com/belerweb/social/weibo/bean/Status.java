package com.belerweb.social.weibo.bean;

import java.util.Date;
import java.util.List;

/**
 * 微博
 * 
 * 文档地址：http://open.weibo.com/wiki/常见返回对象数据结构#.E5.BE.AE.E5.8D.9A.EF.BC.88status.EF.BC.89
 */
public class Status {

  /**
   * 微博ID
   */
  private String id;

  /**
   * 微博MID
   */
  private String mid;

  /**
   * 字符串型的微博ID
   */
  private String idstr;

  /**
   * 微博创建时间
   */
  private Date createdAt;

  /**
   * 微博信息内容
   */
  private String text;

  /**
   * 微博来源
   */
  private String source;

  /**
   * 是否已收藏
   */
  private Boolean favorited;

  /**
   * 是否被截断
   */
  private Boolean truncated;

  /**
   * （暂未支持）回复ID
   */
  private String in_reply_to_status_id;

  /**
   * （暂未支持）回复人UID
   */
  private String in_reply_to_user_id;

  /**
   * （暂未支持）回复人昵称
   */
  private String in_reply_to_screen_name;

  /**
   * 缩略图片地址，没有时不返回此字段
   */
  private String thumbnail_pic;

  /**
   * 原始图片地址，没有时不返回此字段
   */
  private String original_pic;

  /**
   * 地理信息字段
   */
  private Geo geo;

  /**
   * 微博作者的用户信息字段
   */
  private User user;

  /**
   * 被转发的原微博信息字段，当该微博为转发微博时返回
   */
  private Status retweetedStatus;

  /**
   * 转发数
   */
  private Integer repostsCount;

  /**
   * 评论数
   */
  private Integer commentsCount;

  /**
   * 表态数
   */
  private Integer attitudesCount;

  /**
   * 暂未支持
   */
  private Integer mlevel;

  /**
   * 微博的可见性及指定可见分组信息
   */
  private Visible visible;

  /**
   * 微博配图地址。多图时返回多图链接。无配图返回“[]”
   */
  private List<String> picUrls;

  /**
   * 微博流内的推广微博ID
   */
  private List<String> ad;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMid() {
    return mid;
  }

  public void setMid(String mid) {
    this.mid = mid;
  }

  public String getIdstr() {
    return idstr;
  }

  public void setIdstr(String idstr) {
    this.idstr = idstr;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public Boolean getFavorited() {
    return favorited;
  }

  public void setFavorited(Boolean favorited) {
    this.favorited = favorited;
  }

  public Boolean getTruncated() {
    return truncated;
  }

  public void setTruncated(Boolean truncated) {
    this.truncated = truncated;
  }

  public String getIn_reply_to_status_id() {
    return in_reply_to_status_id;
  }

  public void setIn_reply_to_status_id(String in_reply_to_status_id) {
    this.in_reply_to_status_id = in_reply_to_status_id;
  }

  public String getIn_reply_to_user_id() {
    return in_reply_to_user_id;
  }

  public void setIn_reply_to_user_id(String in_reply_to_user_id) {
    this.in_reply_to_user_id = in_reply_to_user_id;
  }

  public String getIn_reply_to_screen_name() {
    return in_reply_to_screen_name;
  }

  public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
    this.in_reply_to_screen_name = in_reply_to_screen_name;
  }

  public String getThumbnail_pic() {
    return thumbnail_pic;
  }

  public void setThumbnail_pic(String thumbnail_pic) {
    this.thumbnail_pic = thumbnail_pic;
  }

  public String getOriginal_pic() {
    return original_pic;
  }

  public void setOriginal_pic(String original_pic) {
    this.original_pic = original_pic;
  }

  public Geo getGeo() {
    return geo;
  }

  public void setGeo(Geo geo) {
    this.geo = geo;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Status getRetweetedStatus() {
    return retweetedStatus;
  }

  public void setRetweetedStatus(Status retweetedStatus) {
    this.retweetedStatus = retweetedStatus;
  }

  public Integer getRepostsCount() {
    return repostsCount;
  }

  public void setRepostsCount(Integer repostsCount) {
    this.repostsCount = repostsCount;
  }

  public Integer getCommentsCount() {
    return commentsCount;
  }

  public void setCommentsCount(Integer commentsCount) {
    this.commentsCount = commentsCount;
  }

  public Integer getAttitudesCount() {
    return attitudesCount;
  }

  public void setAttitudesCount(Integer attitudesCount) {
    this.attitudesCount = attitudesCount;
  }

  public Integer getMlevel() {
    return mlevel;
  }

  public void setMlevel(Integer mlevel) {
    this.mlevel = mlevel;
  }

  public Visible getVisible() {
    return visible;
  }

  public void setVisible(Visible visible) {
    this.visible = visible;
  }

  public List<String> getPicUrls() {
    return picUrls;
  }

  public void setPicUrls(List<String> picUrls) {
    this.picUrls = picUrls;
  }

  public List<String> getAd() {
    return ad;
  }

  public void setAd(List<String> ad) {
    this.ad = ad;
  }

}
