package com.belerweb.social.weibo.bean;

import org.json.JSONObject;

/**
 * 短链
 */
public class UrlShort {

  /**
   * 短链接
   */
  private String urlShort;

  /**
   * 原始长链接
   */
  private String urlLong;

  /**
   * 链接的类型，0：普通网页、1：视频、2：音乐、3：活动、5、投票
   */
  private Integer type;

  /**
   * 短链的可用状态，true：可用、false：不可用。
   */
  private Boolean result;

  public String getUrlShort() {
    return urlShort;
  }

  public void setUrlShort(String urlShort) {
    this.urlShort = urlShort;
  }

  public String getUrlLong() {
    return urlLong;
  }

  public void setUrlLong(String urlLong) {
    this.urlLong = urlLong;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Boolean getResult() {
    return result;
  }

  public void setResult(Boolean result) {
    this.result = result;
  }

  public static UrlShort parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    UrlShort obj = new UrlShort();
    obj.urlShort = Result.toString(jsonObject.opt("url_short"));
    obj.urlLong = Result.toString(jsonObject.opt("url_long"));
    obj.type = Result.perseInteger(jsonObject.opt("type"));
    obj.result = Result.perseBoolean(jsonObject.opt("result"));
    return obj;
  }
}
