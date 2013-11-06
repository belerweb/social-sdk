package com.belerweb.social.weibo.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

/**
 * 微博的可见性及指定可见分组信息
 */
public class Visible extends JsonBean {

  public Visible() {}

  private Visible(JSONObject jsonObject) {
    super(jsonObject);
  }

  private Integer type;// 0：普通微博，1：私密微博，3：指定分组微博，4：密友微博
  private Integer listId;// 分组的组号

  /**
   * 0：普通微博，1：私密微博，3：指定分组微博，4：密友微博
   */
  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  /**
   * 分组的组号
   */
  public Integer getListId() {
    return listId;
  }

  public void setListId(Integer listId) {
    this.listId = listId;
  }

  public static Visible parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    Visible obj = new Visible(jsonObject);
    obj.type = Result.parseInteger(jsonObject.opt("type"));
    obj.listId = Result.parseInteger(jsonObject.opt("list_id"));
    return obj;
  }
}
