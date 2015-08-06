package com.belerweb.social.weixin.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

/**
 * 二维码 Ticket
 */
public class QRTicket extends JsonBean {

  public QRTicket() {}

  private QRTicket(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String ticket;// 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
  private Integer expireSeconds = 604800;// 该二维码有效时间，以秒为单位。 最大不超过1800。

  /**
   * 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。
   */
  public String getTicket() {
    return ticket;
  }

  public void setTicket(String ticket) {
    this.ticket = ticket;
  }

  /**
   * 获取二维码ticket后，开发者可用ticket换取二维码图片。请注意，本接口无须登录态即可调用。
   */
  public String getQRUrl() {
    return "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + ticket;
  }

  /**
   * 该二维码有效时间，以秒为单位。 最大不超过1800。
   */
  public Integer getExpireSeconds() {
    return expireSeconds;
  }

  public void setExpireSeconds(Integer expireSeconds) {
    this.expireSeconds = expireSeconds;
  }

  public static QRTicket parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    QRTicket obj = new QRTicket(jsonObject);
    obj.ticket = jsonObject.getString("ticket");
    obj.expireSeconds = Result.parseInteger(jsonObject.opt("expire_seconds"));
    return obj;
  }

}
