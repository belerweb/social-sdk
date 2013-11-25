package com.belerweb.social.qq.connect.bean;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

public class RepostList extends JsonBean {

  public RepostList() {}

  private RepostList(JSONObject jsonObject) {
    super(jsonObject);
  }

  private Date timestamp;
  private Boolean hasNext;
  private Integer totalNum;
  private List<TweetInfo> tweets;
  private Map<String, String> nameNickMap = new HashMap<String, String>();

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

  public Integer getTotalNum() {
    return totalNum;
  }

  public void setTotalNum(Integer totalNum) {
    this.totalNum = totalNum;
  }

  public List<TweetInfo> getTweets() {
    return tweets;
  }

  public void setTweets(List<TweetInfo> tweets) {
    this.tweets = tweets;
  }

  public static RepostList parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    RepostList obj = new RepostList(jsonObject);
    obj.timestamp = Result.parseTimeSeconds(jsonObject.get("timestamp"));
    obj.hasNext = Result.parseBoolean(jsonObject.get("hasnext"));
    obj.totalNum = Result.parseInteger(jsonObject.get("totalnum"));
    obj.tweets = Result.parse(jsonObject.optJSONArray("info"), TweetInfo.class);
    JSONObject map = jsonObject.optJSONObject("user");
    if (map != null) {
      Iterator<?> keys = map.keys();
      while (keys.hasNext()) {
        String key = keys.next().toString();
        obj.nameNickMap.put(key, map.get(key).toString());
      }
    }
    return obj;
  }

}
