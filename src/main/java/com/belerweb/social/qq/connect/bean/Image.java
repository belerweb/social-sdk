package com.belerweb.social.qq.connect.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

public class Image extends JsonBean {

  public Image() {}

  private Image(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String url;
  private Integer width;
  private Integer height;

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public static Image parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    Image obj = new Image(jsonObject);
    obj.url = Result.toString(jsonObject.opt("url"));
    obj.width = Result.parseInteger(jsonObject.opt("width"));
    obj.height = Result.parseInteger(jsonObject.opt("height"));
    return obj;
  }
}
