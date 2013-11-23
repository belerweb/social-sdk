package com.belerweb.social.qq.connect.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

public class Tag extends JsonBean {

  public Tag() {}

  private Tag(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String id;// 个人标签id。
  private String name;// 标签名。


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static Tag parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    Tag obj = new Tag(jsonObject);
    obj.id = Result.toString(jsonObject.get("id"));
    obj.name = Result.toString(jsonObject.opt("name"));
    return obj;
  }
}
