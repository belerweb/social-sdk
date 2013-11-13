package com.belerweb.social.weixin.bean;


/**
 * 媒体文件类型
 */
public enum MediaType {

  /**
   * 图片
   */
  IMAGE("image"),

  /**
   * 语音
   */
  VOICE("voice"),

  /**
   * 语音
   */
  VOICE_AMR("voice"),

  /**
   * 语音
   */
  VOICE_MP3("voice"),

  /**
   * 视频
   */
  VIDEO("video"),

  /**
   * 缩略图
   */
  THUMB("thumb");

  private String type;

  private MediaType(String type) {
    this.type = type;
  }

  public String value() {
    return type;
  }

  @Override
  public String toString() {
    return type;
  }

  public String contentType() {
    if (this == IMAGE || this == THUMB) {
      return "image/jpeg";
    }
    if (this == VOICE || this == VOICE_AMR) {
      return "audio/amr";
    }
    if (this == VOICE_MP3) {
      return "audio/mp3";
    }
    if (this == VIDEO) {
      return "audio/mp4";
    }
    return null;
  }

}
