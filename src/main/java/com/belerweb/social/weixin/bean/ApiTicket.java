package com.belerweb.social.weixin.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

/**
 * api_ticket 是用于调用微信卡券JS API的临时票据，有效期为7200 秒，通过access_token 来获取。
 */
public class ApiTicket extends JsonBean {

  public ApiTicket() {}

  private ApiTicket(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String ticket;// ticket是公众号用于调用微信卡券JS API的临时票据
  private Long expiresIn;// api_ticket接口调用凭证超时时间，单位（秒）

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

  public static ApiTicket parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    ApiTicket obj = new ApiTicket(jsonObject);
    obj.ticket = jsonObject.getString("ticket");
    obj.expiresIn = Result.parseLong(jsonObject.opt("expires_in"));
    return obj;
  }
}
