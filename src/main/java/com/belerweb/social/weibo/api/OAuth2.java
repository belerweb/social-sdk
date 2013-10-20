package com.belerweb.social.weibo.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;

import com.belerweb.social.bean.Result;
import com.belerweb.social.exception.SocialException;
import com.belerweb.social.weibo.bean.AccessToken;
import com.belerweb.social.weibo.bean.Display;
import com.belerweb.social.weibo.bean.RevokeOAuth2Result;
import com.belerweb.social.weibo.bean.Scope;
import com.belerweb.social.weibo.bean.TokenInfo;

public final class OAuth2 extends API {

  OAuth2(Weibo weibo) {
    super(weibo);
  }


  /**
   * OAuth2的authorize接口
   * 
   * 从 {@link Weibo} 从获取clientId，redirectUri，scope 使用 {@link Scope#ALL}，其余参数默认
   * 
   * @see OAuth2#authorize(String, String, Scope[], String, Display, Boolean, String)
   */
  public String authorize() {
    return authorize(weibo.getRedirectUri());
  }


  /**
   * OAuth2的authorize接口
   * 
   * 从 {@link Weibo} 从获取clientId，scope 使用 {@link Scope#ALL}，其余参数默认
   * 
   * @see OAuth2#authorize(String, String, Scope[], String, Display, Boolean, String)
   * 
   * @param redirectUri 授权回调地址，站外应用需与设置的回调地址一致，站内应用需填写canvas page的地址。
   */
  public String authorize(String redirectUri) {
    return authorize(weibo.getClientId(), redirectUri, new Scope[] {Scope.ALL}, null, null, null,
        null);
  }

  /**
   * OAuth2的authorize接口
   * 
   * 文档地址：http://open.weibo.com/wiki/Oauth2/authorize
   * 
   * @param clientId 申请应用时分配的AppKey。
   * @param redirectUri 授权回调地址，站外应用需与设置的回调地址一致，站内应用需填写canvas page的地址。
   * @param scope 申请scope权限所需参数，可一次申请多个scope权限，用逗号分隔。<a
   *        href="http://open.weibo.com/wiki/Scope">使用文档</a>
   * @param state 用于保持请求和回调的状态，在回调时，会在Query
   *        Parameter中回传该参数。开发者可以用这个参数验证请求有效性，也可以记录用户请求授权页前的位置。这个参数可用于防止跨站请求伪造（CSRF）攻击
   * @param display 授权页面的终端类型，取值见下面的说明。
   * @param forceLogin 是否强制用户重新登录，true：是，false：否。默认false。
   * @param language 授权页语言，缺省为中文简体版，en为英文版。
   */
  public String authorize(String clientId, String redirectUri, Scope[] scope, String state,
      Display display, Boolean forceLogin, String language) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    weibo.addParameter(params, "client_id", clientId);
    weibo.addParameter(params, "redirect_uri", redirectUri);
    if (scope != null) {
      weibo.addParameter(params, "scope", StringUtils.join(scope, ","));
    }
    weibo.addNotNullParameter(params, "state", state);
    weibo.addNotNullParameter(params, "display", display);
    weibo.addTrueParameter(params, "forcelogin", forceLogin);
    weibo.addNotNullParameter(params, "language", language);

    return "https://api.weibo.com/oauth2/authorize?" + StringUtils.join(params, "&");
  }

  /**
   * 从 {@link Weibo} 从获取clientId，clientSecret，grantType，redirectUri 使用 authorization_code
   * 
   * @see OAuth2#accessToken(String, String, String, String, String)
   */
  public Result<AccessToken> accessToken(String code) {
    return accessToken(weibo.getClientId(), weibo.getClientSecret(), "authorization_code", code,
        weibo.getRedirectUri());
  }

  /**
   * 从 {@link Weibo} 从获取clientId，clientSecret，grantType 使用 authorization_code
   * 
   * @see OAuth2#accessToken(String, String, String, String, String)
   */
  public Result<AccessToken> accessToken(String code, String redirectUri) {
    return accessToken(weibo.getClientId(), weibo.getClientSecret(), "authorization_code", code,
        redirectUri);
  }

  /**
   * OAuth2的access_token接口
   * 
   * 文档地址：http://open.weibo.com/wiki/OAuth2/access_token
   * 
   * @param clientId 申请应用时分配的AppKey。
   * @param clientSecret 申请应用时分配的AppSecret。
   * @param grantType 请求的类型，填写authorization_code
   * @param code grant_type为authorization_code时，调用authorize获得的code值。
   * @param redirectUri grant_type为authorization_code时，回调地址，需需与注册应用里的回调地址一致。
   */
  public Result<AccessToken> accessToken(String clientId, String clientSecret, String grantType,
      String code, String redirectUri) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    weibo.addParameter(params, "client_id", clientId);
    weibo.addParameter(params, "client_secret", clientSecret);
    weibo.addParameter(params, "grant_type", grantType);
    if ("authorization_code".equals(grantType)) {
      weibo.addParameter(params, "code", code);
      weibo.addParameter(params, "redirect_uri", redirectUri);
    }
    String result = weibo.post("https://api.weibo.com/oauth2/access_token", params);
    return Result.perse(result, AccessToken.class);
  }

  /**
   * 查询用户access_token的授权相关信息，包括授权时间，过期时间和scope权限。
   * 
   * 文档地址：http://open.weibo.com/wiki/Oauth2/get_token_info
   * 
   * @param accessToken 用户授权时生成的access_token。
   */
  public Result<TokenInfo> getTokenInfo(String accessToken) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    weibo.addParameter(params, "access_token", accessToken);
    String result = weibo.post("https://api.weibo.com/oauth2/get_token_info", params);
    return Result.perse(result, TokenInfo.class);
  }

  /**
   * 用于OAuth1.0 access token 更换至 OAuth2.0 access
   * token，帮助开发者使用新版接口和OAuth2.0时平滑迁移用户。详细的OAuth1.0调用方式和SDK资源参见：<a
   * href="http://open.weibo.com/wiki/Oauth">http://open.weibo.com/wiki/Oauth</a>
   * 
   * 文档地址：http://open.weibo.com/wiki/Oauth2/get_oauth2_token
   * 
   * @param oauthConsumerKey 创建应用时生成的APP KEY。
   * @param oauthToken oauth的token。
   * @param oauthSignatureMethod 签名方法，建议使用“HMAC-SHA1”。
   * @param oauthTimestamp 生成Base String时的时间戳。
   * @param oauthNonce 单次值，一个随机字符串，防止重复攻击。该参数只支持ASCII码的字符串。
   * @param oauthVersion OAuth协议版本。填写“1.0”。
   * @param oauthSignature 签名值，是由根据上面的几个参数生成的 Base String经HMAC-SHA1算法计算得出。
   */
  public void getOAuth2Token(String oauthConsumerKey, String oauthToken,
      String oauthSignatureMethod, Long oauthTimestamp, String oauthNonce, String oauthVersion,
      String oauthSignature) {
    throw new SocialException("方法还未实现...");
  }

  /**
   * 授权回收接口，帮助开发者主动取消用户的授权。
   * 
   * 文档地址：http://open.weibo.com/wiki/Oauth2/revokeoauth2
   * 
   * @param accessToken 用户授权应用的access_token
   */
  public RevokeOAuth2Result revokeOAuth2(String accessToken) {
    String result = weibo.post("https://api.weibo.com/oauth2/revokeoauth2");
    return RevokeOAuth2Result.perse(result);
  }

}
