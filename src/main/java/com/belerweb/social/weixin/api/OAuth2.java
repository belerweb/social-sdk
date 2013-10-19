package com.belerweb.social.weixin.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;

import com.belerweb.social.weixin.bean.Scope;

public final class OAuth2 {

  private Weixin weixin;

  OAuth2(Weixin weixin) {
    this.weixin = weixin;
  }

  /**
   * 获取Authorization Code
   * 
   * 从 {@link Weixin} 从获取clientId，redirectUri，responseType为code ，其余参数默认
   * 
   * @see OAuth2#authorize(String, String, String, String, String, Boolean)
   */
  public String authorize() {
    return authorize(weixin.getRedirectUri());
  }


  /**
   * 获取Authorization Code
   * 
   * 从 {@link Weixin} 从获取clientId，responseType为code ，其余参数默认
   * 
   * @see OAuth2#authorize(String, String, String, String, String, Boolean)
   */
  public String authorize(String redirectUri) {
    return authorize(weixin.getAppid(), redirectUri, "code", null, null, null);
  }

  /**
   * 获取Authorization Code
   * 
   * 文档地址：http://mp.weixin.qq.com/wiki/index.php?title=网页授权获取用户基本信息
   * 
   * @param appId 必须，公众号的唯一标识
   * @param redirectUri 必须，授权后重定向的回调链接地址
   * @param responseType 必须，返回类型，请填写code
   * @param scope 必须，应用授权作用域
   * @param state 重定向后会带上state参数，开发者可以填写任意参数值
   * @param wechatRedirect 直接在微信打开链接，可以不填此参数。做页面302重定向时候，必须带此参数
   */
  public String authorize(String appId, String redirectUri, String responseType, Scope scope,
      String state, Boolean wechatRedirect) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    weixin.addParameter(params, "appid", appId);
    weixin.addParameter(params, "redirect_uri", redirectUri);
    weixin.addParameter(params, "response_type", responseType);
    weixin.addParameter(params, "scope", scope);
    weixin.addNotNullParameter(params, "state", state);
    String result =
        "https://open.weixin.qq.com/connect/oauth2/authorize?" + StringUtils.join(params, "&");
    if (Boolean.TRUE.equals(wechatRedirect)) {
      result = result + "#wechat_redirect";
    }
    return result;
  }

}
