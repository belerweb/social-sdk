package com.belerweb.social.weixin.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

/**
 * 分组
 */
public class Group extends JsonBean {

  public Group() {}

  private Group(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String id;// 分组id，由微信分配
  private String name;// 分组名字，UTF8编码
  private Integer count;// 分组内用户数量

  /**
   * 分组id，由微信分配
   */
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  /**
   * 分组名字，UTF8编码
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * 分组内用户数量
   */
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public static Group parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    Group obj = new Group(jsonObject);
    obj.id = Result.toString(jsonObject.get("id"));
    obj.name = Result.toString(jsonObject.get("name"));
    obj.count = Result.parseInteger(jsonObject.get("count"));
    return obj;
  }


}
