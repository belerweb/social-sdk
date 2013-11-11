package com.belerweb.social.weixin.bean;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

/**
 * 获取关注者列表结果
 */
public class GetFollowersResult extends JsonBean {

  public GetFollowersResult() {}

  private GetFollowersResult(JSONObject jsonObject) {
    super(jsonObject);
  }

  private Integer total;// 关注该公众账号的总用户数
  private Integer count;// 拉取的OPENID个数，最大值为10000
  private List<String> openIds;// OPENID的列表
  private String nextOpenid;// 拉取列表的后一个用户的OPENID

  /**
   * 关注该公众账号的总用户数
   */
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  /**
   * 拉取的OPENID个数，最大值为10000
   */
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  /**
   * OPENID的列表
   */
  public List<String> getOpenIds() {
    return openIds;
  }

  public void setOpenIds(List<String> openIds) {
    this.openIds = openIds;
  }

  /**
   * 拉取列表的后一个用户的OPENID
   */
  public String getNextOpenid() {
    return nextOpenid;
  }

  public void setNextOpenid(String nextOpenid) {
    this.nextOpenid = nextOpenid;
  }

  public static GetFollowersResult parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    GetFollowersResult obj = new GetFollowersResult(jsonObject);
    obj.total = Result.parseInteger(jsonObject.get("total"));
    obj.count = Result.parseInteger(jsonObject.get("count"));
    obj.nextOpenid = Result.toString(jsonObject.opt("next_openid"));
    JSONArray openIdArray = jsonObject.getJSONObject("data").getJSONArray("openid");
    List<String> openIds = new ArrayList<String>();
    for (int i = 0; i < openIdArray.length(); i++) {
      openIds.add(openIdArray.getString(i));
    }
    obj.openIds = openIds;
    return obj;
  }

}
