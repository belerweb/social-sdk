package com.belerweb.social.weibo.bean;

import org.json.JSONObject;

/**
 * 隐私设置
 */
public class Privacy {

  /**
   * 是否可以评论我的微博，0：所有人、1：关注的人、2：可信用户
   */
  private Integer comment;

  /**
   * 是否开启地理信息，0：不开启、1：开启
   */
  private Integer geo;

  /**
   * 是否可以给我发私信，0：所有人、1：我关注的人、2：可信用户
   */
  private Integer message;

  /**
   * 是否可以通过真名搜索到我，0：不可以、1：可以
   */
  private Integer realname;

  /**
   * 勋章是否可见，0：不可见、1：可见
   */
  private Integer badge;

  /**
   * 是否可以通过手机号码搜索到我，0：不可以、1：可以
   */
  private Integer mobile;

  /**
   * 是否开启webim， 0：不开启、1：开启
   */
  private Integer webim;

  public Integer getComment() {
    return comment;
  }

  public void setComment(Integer comment) {
    this.comment = comment;
  }

  public Integer getGeo() {
    return geo;
  }

  public void setGeo(Integer geo) {
    this.geo = geo;
  }

  public Integer getMessage() {
    return message;
  }

  public void setMessage(Integer message) {
    this.message = message;
  }

  public Integer getRealname() {
    return realname;
  }

  public void setRealname(Integer realname) {
    this.realname = realname;
  }

  public Integer getBadge() {
    return badge;
  }

  public void setBadge(Integer badge) {
    this.badge = badge;
  }

  public Integer getMobile() {
    return mobile;
  }

  public void setMobile(Integer mobile) {
    this.mobile = mobile;
  }

  public Integer getWebim() {
    return webim;
  }

  public void setWebim(Integer webim) {
    this.webim = webim;
  }

  public static Privacy parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    Privacy obj = new Privacy();
    obj.comment = Result.perseInteger(jsonObject.opt("comment"));
    obj.geo = Result.perseInteger(jsonObject.opt("geo"));
    obj.message = Result.perseInteger(jsonObject.opt("message"));
    obj.realname = Result.perseInteger(jsonObject.opt("realname"));
    obj.badge = Result.perseInteger(jsonObject.opt("badge"));
    obj.mobile = Result.perseInteger(jsonObject.opt("mobile"));
    obj.webim = Result.perseInteger(jsonObject.opt("webim"));
    return obj;
  }
}
