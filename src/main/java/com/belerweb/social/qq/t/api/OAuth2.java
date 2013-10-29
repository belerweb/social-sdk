package com.belerweb.social.qq.t.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;

import com.belerweb.social.API;

public final class OAuth2 extends API {

  OAuth2(QQT t) {
    super(t);
  }

  /**
   * 获取Authorization Code
   * 
   * 从 {@link QQT} 从获取clientId，redirectUri，responseType为code ，其余参数默认
   * 
   * @see OAuth2#authorize(String, String, String, String, String, Boolean)
   */
  public String authorize() {
    return authorize(t.getRedirectUri());
  }


  /**
   * 获取Authorization Code
   * 
   * 从 {@link QQT} 从获取clientId，responseType为code ，其余参数默认
   * 
   * @see OAuth2#authorize(String, String, String, String, String, Boolean)
   */
  public String authorize(String redirectUri) {
    return authorize(t.getClientId(), redirectUri, "code", null, null, null);
  }

  /**
   * 获取Authorization Code
   * 
   * 文档地址：http://wiki.t.qq.com/使用authorization_code获取access_token
   * 
   * @param clientId 必须，申请应用时分配的app_key
   * @param redirectUri 必须，授权回调地址，必须和应用注册的地址一致(地址长度上限为256个字节)
   * @param responseType 必须，授权类型，为code
   * @param wap 
   *        主要用于指定手机授权页的版本，无此参数默认显示pc授权页面。wap=1时，跳转到wap1.0的授权页。wap=2时，跳转到wap2.0的授权页。不带本参数时，手机访问默认跳到wap2
   *        .0的授权页
   * @param state 
   *        用于保持请求和回调的状态，授权请求成功后原样带回给第三方。该参数用于防止csrf攻击（跨站请求伪造攻击），强烈建议第三方带上该参数。参数设置建议为简单随机数+session的方式
   * @param forceLogin 针对pc授权页。forcelogin=true，强制弹出登录授权页面
   *        forcelogin=false，用户已经登录并且已经授权第三方应用，则不再弹出授权页面 默认为forcelogin=true
   */
  public String authorize(String clientId, String redirectUri, String responseType, String wap,
      String state, Boolean forceLogin) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    t.addParameter(params, "client_id", clientId);
    t.addParameter(params, "redirect_uri", redirectUri);
    t.addParameter(params, "response_type", responseType);
    t.addNotNullParameter(params, "wap", wap);
    t.addNotNullParameter(params, "state", state);
    t.addTrueParameter(params, "forcelogin", forceLogin);
    return "https://open.t.qq.com/cgi-bin/oauth2/authorize?" + StringUtils.join(params, "&");
  }

}
