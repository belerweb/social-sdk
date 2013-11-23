package com.belerweb.social.qq.connect.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

public class Music extends JsonBean {

  public Music() {}

  private Music(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String author;// 演唱者。
  private String url;// 音频地址。
  private String title;// 音频名字，歌名。


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public static Music parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    Music obj = new Music(jsonObject);
    obj.author = Result.toString(jsonObject.opt("author"));
    obj.url = Result.toString(jsonObject.opt("url"));
    obj.title = Result.toString(jsonObject.opt("title"));
    return obj;
  }
}
