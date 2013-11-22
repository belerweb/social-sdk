package com.belerweb.social.qq.connect.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

public class PicUploadResult extends JsonBean {

  public PicUploadResult() {}

  private PicUploadResult(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String albumId;
  private String lLoc;
  private String sLoc;
  private String largeUrl;
  private String smallUrl;
  private Integer width;
  private Integer height;

  public String getAlbumId() {
    return albumId;
  }

  public void setAlbumId(String albumId) {
    this.albumId = albumId;
  }

  public String getlLoc() {
    return lLoc;
  }

  public void setlLoc(String lLoc) {
    this.lLoc = lLoc;
  }

  public String getsLoc() {
    return sLoc;
  }

  public void setsLoc(String sLoc) {
    this.sLoc = sLoc;
  }

  public String getLargeUrl() {
    return largeUrl;
  }

  public void setLargeUrl(String largeUrl) {
    this.largeUrl = largeUrl;
  }

  public String getSmallUrl() {
    return smallUrl;
  }

  public void setSmallUrl(String smallUrl) {
    this.smallUrl = smallUrl;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public static PicUploadResult parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    PicUploadResult obj = new PicUploadResult(jsonObject);
    obj.albumId = Result.toString(jsonObject.opt("albumid"));
    obj.lLoc = Result.toString(jsonObject.opt("lloc"));
    obj.sLoc = Result.toString(jsonObject.opt("sloc"));
    obj.largeUrl = Result.toString(jsonObject.opt("large_url"));
    obj.smallUrl = Result.toString(jsonObject.opt("small_url"));
    obj.width = Result.parseInteger(jsonObject.opt("width"));
    obj.height = Result.parseInteger(jsonObject.opt("height"));
    return obj;
  }
}
