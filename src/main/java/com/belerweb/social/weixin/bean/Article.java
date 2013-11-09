package com.belerweb.social.weixin.bean;

/**
 * 图文
 */
public class Article {

  private String title;// 图文消息标题
  private String description;// 图文消息描述
  private String picUrl;// 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
  private String url;// 点击图文消息跳转链接

  /**
   * 图文消息标题
   */
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * 图文消息描述
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
   */
  public String getPicUrl() {
    return picUrl;
  }

  public void setPicUrl(String picUrl) {
    this.picUrl = picUrl;
  }

  /**
   * 点击图文消息跳转链接
   */
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

}
