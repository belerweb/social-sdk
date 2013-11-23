package com.belerweb.social.qq.connect.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

public class Video extends JsonBean {

  public Video() {}

  private Video(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String picUrl;// 缩略图。
  private String player;// 播放器地址。
  private String realUrl;// 视频原地址。
  private String shortUrl;// 视频的短url。
  private String title;// 视频标题。

  public String getPicUrl() {
    return picUrl;
  }

  public void setPicUrl(String picUrl) {
    this.picUrl = picUrl;
  }

  public String getPlayer() {
    return player;
  }

  public void setPlayer(String player) {
    this.player = player;
  }

  public String getRealUrl() {
    return realUrl;
  }

  public void setRealUrl(String realUrl) {
    this.realUrl = realUrl;
  }

  public String getShortUrl() {
    return shortUrl;
  }

  public void setShortUrl(String shortUrl) {
    this.shortUrl = shortUrl;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public static Video parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    Video obj = new Video(jsonObject);
    obj.picUrl = Result.toString(jsonObject.opt("picurl"));
    obj.player = Result.toString(jsonObject.opt("player"));
    obj.realUrl = Result.toString(jsonObject.opt("realurl"));
    obj.shortUrl = Result.toString(jsonObject.opt("shorturl"));
    obj.title = Result.toString(jsonObject.opt("title"));
    return obj;
  }
}
