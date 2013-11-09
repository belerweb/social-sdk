package com.belerweb.social.weixin.bean;


/**
 * 语音格式
 */
public enum VoiceType {

  /**
   * amr
   */
  AMR("amr"),

  /**
   * speex
   */
  SPEEX("speex");

  private String type;

  private VoiceType(String type) {
    this.type = type;
  }

  public String value() {
    return type;
  }

  @Override
  public String toString() {
    return type;
  }

  public static VoiceType parse(Object val) {
    if (AMR.type.equals(val)) {
      return AMR;
    }
    if (SPEEX.type.equals(val)) {
      return SPEEX;
    }
    return null;
  }
}
