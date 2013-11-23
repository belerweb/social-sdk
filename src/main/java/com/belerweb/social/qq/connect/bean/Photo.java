package com.belerweb.social.qq.connect.bean;

import java.util.Date;
import java.util.Locale;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

public class Photo extends JsonBean {

  public Photo() {}

  private Photo(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String sLoc;
  private String lLoc;
  private String name;
  private String description;
  private Date updatedTime;
  private Date uploadedTime;
  private String smallUrl;
  private Image largeImage;

  public String getsLoc() {
    return sLoc;
  }

  public void setsLoc(String sLoc) {
    this.sLoc = sLoc;
  }

  public String getlLoc() {
    return lLoc;
  }

  public void setlLoc(String lLoc) {
    this.lLoc = lLoc;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public Date getUploadedTime() {
    return uploadedTime;
  }

  public void setUploadedTime(Date uploadedTime) {
    this.uploadedTime = uploadedTime;
  }

  public String getSmallUrl() {
    return smallUrl;
  }

  public void setSmallUrl(String smallUrl) {
    this.smallUrl = smallUrl;
  }

  public Image getLargeImage() {
    return largeImage;
  }

  public void setLargeImage(Image largeImage) {
    this.largeImage = largeImage;
  }

  public static Photo parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    Photo obj = new Photo(jsonObject);
    obj.sLoc = Result.toString(jsonObject.opt("sloc"));
    obj.lLoc = Result.toString(jsonObject.opt("lloc"));
    obj.name = Result.toString(jsonObject.opt("name"));
    obj.description = Result.toString(jsonObject.opt("desc"));
    obj.updatedTime = Result.parseTimeSeconds(jsonObject.opt("updated_time"));
    obj.uploadedTime =
        Result.parseDate(jsonObject.opt("uploaded_time"), "yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    obj.smallUrl = Result.toString(jsonObject.opt("small_url"));
    obj.largeImage = Image.parse(jsonObject.optJSONObject("large_image"));
    return obj;
  }

}
