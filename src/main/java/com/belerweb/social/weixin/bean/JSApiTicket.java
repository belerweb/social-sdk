package com.belerweb.social.weixin.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

/**
 * jsapi_ticket是公众号用于调用微信JS接口的临时票据。正常情况下，jsapi_ticket的有效期为7200秒，通过access_token来获取。
 */
public class JSApiTicket extends JsonBean {

  public JSApiTicket() {}

  private JSApiTicket(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String ticket;// ticket是公众号用于调用微信JS接口的临时票据
  private Long expiresIn;// jsapi_ticket接口调用凭证超时时间，单位（秒）

  public String getTicket() {
    return ticket;
  }

  public void setTicket(String ticket) {
    this.ticket = ticket;
  }

  public Long getExpiresIn() {
    return expiresIn;
  }

  public void setExpiresIn(Long expiresIn) {
    this.expiresIn = expiresIn;
  }

  public static JSApiTicket parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    JSApiTicket obj = new JSApiTicket(jsonObject);
    obj.ticket = jsonObject.getString("ticket");
    obj.expiresIn = Result.parseLong(jsonObject.opt("expires_in"));
    return obj;
  }
}
