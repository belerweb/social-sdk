package com.belerweb.social.qq.connect.bean;

import java.util.Date;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

public class TweetInfo extends JsonBean {

  public TweetInfo() {}

  private TweetInfo(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String id;// 微博唯一id。
  private String countryCode;// 发表微博时所作的国家代码。
  private String provinceCode;// 发表微博时所作的省份代码。
  private String cityCode;// 发表微博时所作的城市代码。
  private String emotionType;// 心情类型。
  private String emotionUrl;// 心情图片url。
  private String from;// 来源。
  private String fromUrl;// 来源url。
  private String image;// 图片url。
  private String geo;// 地理位置信息。
  private String location;// 发表者所在地。
  private Double longitude;// 经度。
  private Double latitude;// 纬度。
  private Music music;
  private String origText;// 微博原始内容。
  private Boolean self;// 是否自已发的的微博
  private Integer status;// 表示微博的状态。0：正常；1：微博被系统删除；2：审核中；3；微博被用户删除；4：源微博被系统审核删除。
  private String text;// 微博内容。
  private Date timestamp;// 服务器时间戳，不能用于翻页。
  private Integer type;// 表示微博的类型。1：原创发表；2：转播；3：私信；4：回复；5：没有内容的回复；6：提及；7：评论。
  private Video video;// 视频信息。
  private Integer count;// 转播次数。
  private Integer mCount;// 评论数。
  private Boolean isVip;// 用户是否为微博认证用户

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getEmotionType() {
    return emotionType;
  }

  public void setEmotionType(String emotionType) {
    this.emotionType = emotionType;
  }

  public String getEmotionUrl() {
    return emotionUrl;
  }

  public void setEmotionUrl(String emotionUrl) {
    this.emotionUrl = emotionUrl;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getFromUrl() {
    return fromUrl;
  }

  public void setFromUrl(String fromUrl) {
    this.fromUrl = fromUrl;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getGeo() {
    return geo;
  }

  public void setGeo(String geo) {
    this.geo = geo;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Music getMusic() {
    return music;
  }

  public void setMusic(Music music) {
    this.music = music;
  }

  public String getOrigText() {
    return origText;
  }

  public void setOrigText(String origText) {
    this.origText = origText;
  }

  public Boolean getSelf() {
    return self;
  }

  public void setSelf(Boolean self) {
    this.self = self;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Video getVideo() {
    return video;
  }

  public void setVideo(Video video) {
    this.video = video;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public Integer getmCount() {
    return mCount;
  }

  public void setmCount(Integer mCount) {
    this.mCount = mCount;
  }

  public Boolean getIsVip() {
    return isVip;
  }

  public void setIsVip(Boolean isVip) {
    this.isVip = isVip;
  }

  public static TweetInfo parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    TweetInfo obj = new TweetInfo(jsonObject);
    obj.id = Result.toString(jsonObject.get("id"));
    obj.countryCode = Result.toString(jsonObject.opt("country_code"));
    obj.provinceCode = Result.toString(jsonObject.opt("province_code"));
    obj.cityCode = Result.toString(jsonObject.opt("city_code"));
    obj.emotionType = Result.toString(jsonObject.opt("emotiontype"));
    obj.emotionUrl = Result.toString(jsonObject.opt("emotionurl"));
    obj.from = Result.toString(jsonObject.opt("from"));
    obj.fromUrl = Result.toString(jsonObject.opt("fromurl"));
    obj.image = Result.toString(jsonObject.opt("image"));
    obj.geo = Result.toString(jsonObject.opt("geo"));
    obj.location = Result.toString(jsonObject.opt("location"));
    obj.longitude = Result.parseDouble(jsonObject.opt("longitude"));
    obj.latitude = Result.parseDouble(jsonObject.opt("latitude"));
    obj.music = Music.parse(jsonObject.optJSONObject("music"));
    obj.origText = Result.toString(jsonObject.opt("origtext"));
    obj.self = Result.parseBoolean(jsonObject.opt("self"));
    obj.status = Result.parseInteger(jsonObject.opt("status"));
    obj.text = Result.toString(jsonObject.opt("text"));
    obj.timestamp = Result.parseTimeSeconds(jsonObject.opt("timestamp"));
    obj.type = Result.parseInteger(jsonObject.opt("type"));
    obj.video = Video.parse(jsonObject.optJSONObject("video"));
    obj.count = Result.parseInteger(jsonObject.opt("count"));
    obj.mCount = Result.parseInteger(jsonObject.opt("mcount"));
    obj.isVip = Result.parseBoolean(jsonObject.opt("isvip"));
    return obj;
  }
}
