package com.belerweb.social.bean;

import org.json.JSONObject;

public abstract class JsonBean {

  private JSONObject jsonObject;

  protected JsonBean() {}

  protected JsonBean(JSONObject jsonObject) {
    this.jsonObject = jsonObject;
  }

  public JSONObject getJsonObject() {
    return jsonObject;
  }

}
