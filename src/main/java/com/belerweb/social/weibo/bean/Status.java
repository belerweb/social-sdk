package com.belerweb.social.weibo.bean;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.json.JSONObject;

import com.belerweb.social.bean.Result;

/**
 * 微博
 * 
 * 文档地址：http://open.weibo.com/wiki/常见返回对象数据结构#.E5.BE.AE.E5.8D.9A.EF.BC.88status.EF.BC.89
 */
public class Status {

  private String id;// 微博ID
  private String mid;// 微博MID
  private String idstr;// 字符串型的微博ID
  private Date createdAt;// 微博创建时间
  private String text;// 微博信息内容
  private String source;// 微博来源
  private Boolean favorited;// 是否已收藏
  private Boolean truncated;// 是否被截断
  private String inReplyToStatusId;// （暂未支持）回复ID
  private String inReplyToUserId;// 暂未支持）回复人UID
  private String inReplyToScreenName;// 暂未支持）回复人昵称
  private String thumbnailPic;// 缩略图片地址，没有时不返回此字段
  private String bmiddlePic;// 中等尺寸图片地址，没有时不返回此字段
  private String originalPic;// 原始图片地址，没有时不返回此字段
  private Geo geo;// 地理信息字段
  private User user;// 微博作者的用户信息字段
  private Status retweetedStatus;// 被转发的原微博信息字段，当该微博为转发微博时返回
  private Integer repostsCount;// 转发数
  private Integer commentsCount;// 评论数
  private Integer attitudesCount;// 表态数
  private Integer mlevel;// 暂未支持
  private Visible visible;// 微博的可见性及指定可见分组信息
  private List<String> picUrls;// 微博配图地址。多图时返回多图链接。无配图返回“[]”
  private List<String> ad;// 微博流内的推广微博ID

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
   * 微博MID
   */
  public String getMid() {
    return mid;
  }

  public void setMid(String mid) {
    this.mid = mid;
  }

  /**
   * 字符串型的微博ID
   */
  public String getIdstr() {
    return idstr;
  }

  public void setIdstr(String idstr) {
    this.idstr = idstr;
  }

  /**
   * 微博创建时间
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * 微博信息内容
   */
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  /**
   * 微博来源
   */
  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  /**
   * 是否已收藏
   */
  public Boolean getFavorited() {
    return favorited;
  }

  public void setFavorited(Boolean favorited) {
    this.favorited = favorited;
  }

  /**
   * 是否被截断
   */
  public Boolean getTruncated() {
    return truncated;
  }

  public void setTruncated(Boolean truncated) {
    this.truncated = truncated;
  }

  /**
   * （暂未支持）回复ID
   */
  public String getInReplyToStatusId() {
    return inReplyToStatusId;
  }

  public void setInReplyToStatusId(String inReplyToStatusId) {
    this.inReplyToStatusId = inReplyToStatusId;
  }

  /**
   * （暂未支持）回复人UID
   */
  public String getInReplyToUserId() {
    return inReplyToUserId;
  }

  public void setInReplyToUserId(String inReplyToUserId) {
    this.inReplyToUserId = inReplyToUserId;
  }

  /**
   * （暂未支持）回复人昵称
   */
  public String getInReplyToScreenName() {
    return inReplyToScreenName;
  }

  public void setInReplyToScreenName(String inReplyToScreenName) {
    this.inReplyToScreenName = inReplyToScreenName;
  }

  /**
   * 缩略图片地址，没有时不返回此字段
   */
  public String getThumbnailPic() {
    return thumbnailPic;
  }

  public void setThumbnailPic(String thumbnailPic) {
    this.thumbnailPic = thumbnailPic;
  }

  /**
   * 中等尺寸图片地址，没有时不返回此字段
   */
  public String getBmiddlePic() {
    return bmiddlePic;
  }

  public void setBmiddlePic(String bmiddlePic) {
    this.bmiddlePic = bmiddlePic;
  }

  /**
   * 原始图片地址，没有时不返回此字段
   */
  public String getOriginalPic() {
    return originalPic;
  }

  public void setOriginalPic(String originalPic) {
    this.originalPic = originalPic;
  }

  /**
   * 地理信息字段
   */
  public Geo getGeo() {
    return geo;
  }

  public void setGeo(Geo geo) {
    this.geo = geo;
  }

  /**
   * 微博作者的用户信息字段
   */
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  /**
   * 被转发的原微博信息字段，当该微博为转发微博时返回
   */
  public Status getRetweetedStatus() {
    return retweetedStatus;
  }

  public void setRetweetedStatus(Status retweetedStatus) {
    this.retweetedStatus = retweetedStatus;
  }

  /**
   * 转发数
   */
  public Integer getRepostsCount() {
    return repostsCount;
  }

  public void setRepostsCount(Integer repostsCount) {
    this.repostsCount = repostsCount;
  }

  /**
   * 评论数
   */
  public Integer getCommentsCount() {
    return commentsCount;
  }

  public void setCommentsCount(Integer commentsCount) {
    this.commentsCount = commentsCount;
  }

  /**
   * 表态数
   */
  public Integer getAttitudesCount() {
    return attitudesCount;
  }

  public void setAttitudesCount(Integer attitudesCount) {
    this.attitudesCount = attitudesCount;
  }

  /**
   * 暂未支持
   */
  public Integer getMlevel() {
    return mlevel;
  }

  public void setMlevel(Integer mlevel) {
    this.mlevel = mlevel;
  }

  /**
   * 微博的可见性及指定可见分组信息
   */
  public Visible getVisible() {
    return visible;
  }

  public void setVisible(Visible visible) {
    this.visible = visible;
  }

  /**
   * 微博配图地址。多图时返回多图链接。无配图返回“[]”
   */
  public List<String> getPicUrls() {
    return picUrls;
  }

  public void setPicUrls(List<String> picUrls) {
    this.picUrls = picUrls;
  }

  /**
   * 微博流内的推广微博ID
   */
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
    obj.createdAt =
        Result
            .parseDate(jsonObject.opt("created_at"), "EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
    obj.text = Result.toString(jsonObject.get("text"));
    obj.source = Result.toString(jsonObject.opt("source"));
    obj.favorited = Result.parseBoolean(jsonObject.opt("favorited"));
    obj.truncated = Result.parseBoolean(jsonObject.opt("truncated"));
    obj.inReplyToStatusId = Result.toString(jsonObject.opt("in_reply_to_status_id"));
    obj.inReplyToUserId = Result.toString(jsonObject.opt("in_reply_to_user_id"));
    obj.inReplyToScreenName = Result.toString(jsonObject.opt("in_reply_to_screen_name"));
    obj.thumbnailPic = Result.toString(jsonObject.opt("thumbnail_pic"));
    obj.bmiddlePic = Result.toString(jsonObject.opt("bmiddle_pic"));
    obj.originalPic = Result.toString(jsonObject.opt("original_pic"));
    obj.geo = Geo.parse(jsonObject.optJSONObject("geo"));
    obj.user = User.parse(jsonObject.optJSONObject("user"));
    obj.retweetedStatus = Status.parse(jsonObject.optJSONObject("retweeted_status"));
    obj.repostsCount = Result.parseInteger(jsonObject.opt("reposts_count"));
    obj.commentsCount = Result.parseInteger(jsonObject.opt("comments_count"));
    obj.attitudesCount = Result.parseInteger(jsonObject.opt("attitudes_count"));
    obj.mlevel = Result.parseInteger(jsonObject.opt("mlevel"));
    obj.visible = Visible.parse(jsonObject.optJSONObject("visible"));
    obj.picUrls = Result.parse(jsonObject.optJSONArray("pic_urls"), String.class);
    obj.ad = Result.parse(jsonObject.optJSONArray("ad"), String.class);
    return obj;
  }
}
