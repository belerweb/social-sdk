package com.belerweb.social.qq.connect.bean;

import java.util.Date;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

/**
 * 新发布的微博的返回信息
 */
public class NewT extends JsonBean {

  public NewT() {}

  private NewT(JSONObject jsonObject) {
    super(jsonObject);
  }

  private Long id;
  private Date time;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public static NewT parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    NewT obj = new NewT(jsonObject);
    obj.id = Result.parseLong(jsonObject.get("id"));
    obj.time = new Date(Result.parseLong(jsonObject.get("time")) * 1000);
    return obj;
  }
}
