package com.belerweb.social.weibo.bean;

import java.util.Date;
import java.util.List;

import org.json.JSONObject;

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
  private String inReplyToStatusId;

  /**
   * （暂未支持）回复人UID
   */
  private String inReplyToUserId;

  /**
   * （暂未支持）回复人昵称
   */
  private String inReplyToScreenName;

  /**
   * 缩略图片地址，没有时不返回此字段
   */
  private String thumbnailPic;

  /**
   * 中等尺寸图片地址，没有时不返回此字段
   */
  private String bmiddlePic;

  /**
   * 原始图片地址，没有时不返回此字段
   */
  private String originalPic;

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

  public String getInReplyToStatusId() {
    return inReplyToStatusId;
  }

  public void setInReplyToStatusId(String inReplyToStatusId) {
    this.inReplyToStatusId = inReplyToStatusId;
  }

  public String getInReplyToUserId() {
    return inReplyToUserId;
  }

  public void setInReplyToUserId(String inReplyToUserId) {
    this.inReplyToUserId = inReplyToUserId;
  }

  public String getInReplyToScreenName() {
    return inReplyToScreenName;
  }

  public void setInReplyToScreenName(String inReplyToScreenName) {
    this.inReplyToScreenName = inReplyToScreenName;
  }

  public String getThumbnailPic() {
    return thumbnailPic;
  }

  public void setThumbnailPic(String thumbnailPic) {
    this.thumbnailPic = thumbnailPic;
  }

  public String getBmiddlePic() {
    return bmiddlePic;
  }

  public void setBmiddlePic(String bmiddlePic) {
    this.bmiddlePic = bmiddlePic;
  }

  public String getOriginalPic() {
    return originalPic;
  }

  public void setOriginalPic(String originalPic) {
    this.originalPic = originalPic;
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

  public static Status parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    Status obj = new Status();
    obj.id = Result.toString(jsonObject.get("id"));
    obj.mid = Result.toString(jsonObject.opt("mid"));
    obj.idstr = Result.toString(jsonObject.opt("idstr"));
    obj.createdAt = Result.perseDate(jsonObject.opt("created_at"));
    obj.text = Result.toString(jsonObject.get("text"));
    obj.source = Result.toString(jsonObject.opt("source"));
    obj.favorited = Result.perseBoolean(jsonObject.opt("favorited"));
    obj.truncated = Result.perseBoolean(jsonObject.opt("truncated"));
    obj.inReplyToStatusId = Result.toString(jsonObject.opt("in_reply_to_status_id"));
    obj.inReplyToUserId = Result.toString(jsonObject.opt("in_reply_to_user_id"));
    obj.inReplyToScreenName = Result.toString(jsonObject.opt("in_reply_to_screen_name"));
    obj.thumbnailPic = Result.toString(jsonObject.opt("thumbnail_pic"));
    obj.bmiddlePic = Result.toString(jsonObject.opt("bmiddle_pic"));
    obj.originalPic = Result.toString(jsonObject.opt("original_pic"));
    obj.geo = Geo.parse(jsonObject.optJSONObject("geo"));
    obj.user = User.parse(jsonObject.optJSONObject("user"));
    obj.retweetedStatus = Status.parse(jsonObject.optJSONObject("retweeted_status"));
    obj.repostsCount = Result.perseInteger(jsonObject.opt("reposts_count"));
    obj.commentsCount = Result.perseInteger(jsonObject.opt("comments_count"));
    obj.attitudesCount = Result.perseInteger(jsonObject.opt("attitudes_count"));
    obj.mlevel = Result.perseInteger(jsonObject.opt("mlevel"));
    obj.visible = Visible.parse(jsonObject.optJSONObject("visible"));
    obj.picUrls = Result.perse(jsonObject.optJSONArray("pic_urls"), String.class);
    obj.ad = Result.perse(jsonObject.optJSONArray("ad"), String.class);
    return obj;
  }
}
