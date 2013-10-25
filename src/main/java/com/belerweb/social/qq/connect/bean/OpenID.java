package com.belerweb.social.qq.connect.bean;

import org.json.JSONObject;

public class OpenID {

  private String clientId;
  private String openId; // openid是此网站上唯一对应用户身份的标识，网站可将此ID进行存储便于用户下次登录时辨识其身份，或将其与用户在网站上的原有账号进行绑定。

  /**
   * openid是此网站上唯一对应用户身份的标识，网站可将此ID进行存储便于用户下次登录时辨识其身份，或将其与用户在网站上的原有账号进行绑定。
   */
  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public static OpenID parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    OpenID obj = new OpenID();
    obj.clientId = jsonObject.getString("client_id");
    obj.openId = jsonObject.getString("openid");
    return obj;
  }
}
