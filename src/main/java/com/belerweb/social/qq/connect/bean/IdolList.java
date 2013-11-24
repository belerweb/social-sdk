package com.belerweb.social.qq.connect.bean;

import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

public class IdolList extends JsonBean {

  public IdolList() {}

  private IdolList(JSONObject jsonObject) {
    super(jsonObject);
  }

  private Date timestamp;
  private Boolean hasNext;
  private List<WeiboUser> fans;

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public Boolean getHasNext() {
    return hasNext;
  }

  public void setHasNext(Boolean hasNext) {
    this.hasNext = hasNext;
  }

  public List<WeiboUser> getFans() {
    return fans;
  }

  public void setFans(List<WeiboUser> fans) {
    this.fans = fans;
  }

  public static IdolList parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    IdolList obj = new IdolList(jsonObject);
    obj.timestamp = Result.parseTimeSeconds(jsonObject.get("timestamp"));
    obj.hasNext = Result.parseBoolean(jsonObject.get("hasnext"));
    obj.fans = Result.parse(jsonObject.optJSONArray("info"), WeiboUser.class);
    return obj;
  }

}
