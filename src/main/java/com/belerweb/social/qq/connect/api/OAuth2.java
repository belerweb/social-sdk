package com.belerweb.social.qq.connect.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.json.JSONObject;

import com.belerweb.social.API;
import com.belerweb.social.bean.Result;
import com.belerweb.social.qq.connect.bean.AccessToken;
import com.belerweb.social.qq.connect.bean.Display;
import com.belerweb.social.qq.connect.bean.Gut;
import com.belerweb.social.qq.connect.bean.OpenID;
import com.belerweb.social.qq.connect.bean.Scope;

public final class OAuth2 extends API {

  OAuth2(QQConnect connect) {
    super(connect);
  }

  /**
   * 获取Authorization Code
   * 
   * @see OAuth2#authorize(Boolean)
   */
  public String authorize() {
    return authorize(false);
  }


  /**
   * 获取Authorization Code
   * 
   * @see OAuth2#authorize(String, Boolean)
   */
  public String authorize(String redirectUri) {
    return authorize(redirectUri, false);
  }

  /**
   * 获取Authorization Code
   * 
   * 从 {@link QQConnect} 从获取clientId，redirectUri，responseType为code，state使用authorize，scope使用
   * {@link Scope#ALL}，其余参数默认
   * 
   * @see OAuth2#authorize(String, String, String, String, Scope[], Display, Gut, Boolean)
   */
  public String authorize(Boolean wap) {
    return authorize(connect.getRedirectUri(), wap);
  }

  /**
   * 获取Authorization Code
   * 
   * 从 {@link QQConnect} 从获取clientId，responseType为code，state使用authorize，scope使用 {@link Scope#ALL}
   * ，其余参数默认
   * 
   * @see OAuth2#authorize(String, String, String, String, Scope[], Display, Gut, Boolean)
   */
  public String authorize(String redirectUri, Boolean wap) {
    return authorize(connect.getClientId(), redirectUri, "code", "authorize", Scope.ALL, null,
        null, wap);
  }

  /**
   * 获取Authorization Code
   * 
   * 文档地址：http://wiki.connect.qq.com/使用authorization_code获取access_token
   * 
   * @param clientId 必须，申请QQ登录成功后，分配给应用的appid。
   * @param redirectUri 必须，成功授权后的回调地址，必须是注册appid时填写的主域名下的地址，建议设置为网站首页或网站的用户中心。注意需要将url进行URLEncode。
   * @param responseType 必须，授权类型，此值固定为“code”。
   * @param state 必须，client端的状态值。用于第三方应用防止CSRF攻击，成功授权后回调时会原样带回。请务必严格按照流程检查用户与state参数状态的绑定。
   * @param scope 可选，请求用户授权时向用户显示的可进行授权的列表
   * @param display 可选，仅PC网站接入时使用。用于展示的样式。不传则默认展示为PC下的样式。如果传入“mobile”，则展示为mobile端下的样式。
   * @param gut 仅WAP网站接入时使用。QQ登录页面版本（1：wml版本； 2：xhtml版本），默认值为1。
   * @param wap 是否使wap版，默认为false
   */
  public String authorize(String clientId, String redirectUri, String responseType, String state,
      Scope[] scope, Display display, Gut gut, Boolean wap) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    connect.addParameter(params, "response_type", responseType);
    connect.addParameter(params, "client_id", clientId);
    connect.addParameter(params, "redirect_uri", redirectUri);
    connect.addParameter(params, "state", state);
    if (scope != null) {
      connect.addParameter(params, "scope", StringUtils.join(scope, ","));
    }
    if (Display.MOBILE.equals(display)) {
      connect.addParameter(params, "display", "mobile");
    }
    if (Gut.XHTML.equals(gut)) {
      connect.addParameter(params, "g_ut", gut.toString());
    }

    String url = "https://graph.qq.com/oauth2.0/authorize?";
    if (Boolean.TRUE.equals(wap)) {
      url = "https://graph.z.qq.com/moc2/authorize?";
    }
    return url + StringUtils.join(params, "&");
  }

  /**
   * 通过Authorization Code获取Access Token，此接口适用于PC网站。
   * 
   * 从 {@link QQConnect} 从获取clientId，clientSecret，redirectUri，grantType为authorization_code
   * 
   * @see OAuth2#accessToken(String, String, String, String, String, Boolean)
   */
  public Result<AccessToken> accessToken(String code) {
    return accessToken(code, connect.getRedirectUri());
  }

  /**
   * 通过Authorization Code获取Access Token，此接口适用于PC网站。
   * 
   * 从 {@link QQConnect} 从获取clientId，clientSecret，grantType为authorization_code
   * 
   * @see OAuth2#accessToken(String, String, String, String, String, Boolean)
   */
  public Result<AccessToken> accessToken(String code, String redirectUri) {
    return accessToken(code, redirectUri, null);
  }

  /**
   * 通过Authorization Code获取Access Token
   * 
   * 从 {@link QQConnect} 从获取clientId，clientSecret，redirectUri，grantType为authorization_code
   * 
   * @see OAuth2#accessToken(String, String, String, String, String, Boolean)
   */
  public Result<AccessToken> accessToken(String code, Boolean wap) {
    return accessToken(code, connect.getRedirectUri(), wap);
  }

  /**
   * 通过Authorization Code获取Access Token
   * 
   * 从 {@link QQConnect} 从获取clientId，clientSecret，grantType为authorization_code
   * 
   * @see OAuth2#accessToken(String, String, String, String, String, Boolean)
   */
  public Result<AccessToken> accessToken(String code, String redirectUri, Boolean wap) {
    return accessToken(connect.getClientId(), connect.getClientSecret(), "authorization_code",
        code, redirectUri, wap);
  }

  /**
   * 通过Authorization Code获取Access Token
   * 
   * 文档地址：http://wiki.connect.qq.com/使用authorization_code获取access_token
   * 
   * @param clientId 申请QQ登录成功后，分配给网站的appid。
   * @param clientSecret 申请QQ登录成功后，分配给网站的appkey。
   * @param grantType 授权类型，在本步骤中，此值为“authorization_code”。
   * @param code 上一步返回的authorization code。如果用户成功登录并授权，则会跳转到指定的回调地址，并在URL中带上Authorization
   *        Code。注意此code会在10分钟内过期。
   * @param redirectUri 与上面一步中传入的redirect_uri保持一致。
   * @param wap 是否使wap版，默认为false
   */
  public Result<AccessToken> accessToken(String clientId, String clientSecret, String grantType,
      String code, String redirectUri, Boolean wap) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    connect.addParameter(params, "client_id", clientId);
    connect.addParameter(params, "client_secret", clientSecret);
    connect.addParameter(params, "grant_type", grantType);
    connect.addParameter(params, "code", code);
    connect.addParameter(params, "redirect_uri", redirectUri);
    String url = "https://graph.qq.com/oauth2.0/token";
    if (Boolean.TRUE.equals(wap)) {
      url = "https://graph.z.qq.com/moc2/token";
    }
    String result = connect.get(url, params).trim();
    return parseAccessTokenResult(result);
  }

  /**
   * 权限自动续期，获取Access Token，此方法适用于PC网站。
   * 
   * 从 {@link QQConnect}中获取 clientId, clientSecret
   * 
   * @see OAuth2#refreshAccessToken(String, String, String, String, Boolean)
   * @param refreshToken {@link AccessToken}中的refresToken。
   */
  public Result<AccessToken> refreshAccessToken(String refreshToken) {
    return refreshAccessToken(connect.getClientId(), connect.getClientSecret(), refreshToken);
  }

  /**
   * 权限自动续期，获取Access Token，此方法适用于PC网站。
   * 
   * @see OAuth2#refreshAccessToken(String, String, String, String, Boolean)
   * @param refreshToken {@link AccessToken}中的refresToken。
   */
  public Result<AccessToken> refreshAccessToken(String clientId, String clientSecret,
      String refreshToken) {
    return refreshAccessToken(clientId, clientSecret, "refresh_token", refreshToken, null);
  }

  /**
   * 权限自动续期，获取Access Token
   * 
   * 从 {@link QQConnect}中获取 clientId, clientSecret
   * 
   * @see OAuth2#refreshAccessToken(String, String, String, String, Boolean)
   * @param refreshToken {@link AccessToken}中的refresToken。
   * @param wap 是否使wap版，默认为false
   */
  public Result<AccessToken> refreshAccessToken(String refreshToken, Boolean wap) {
    return refreshAccessToken(connect.getClientId(), connect.getClientSecret(), refreshToken, wap);
  }

  /**
   * 权限自动续期，获取Access Token
   * 
   * @see OAuth2#refreshAccessToken(String, String, String, String, Boolean)
   * @param refreshToken {@link AccessToken}中的refresToken。
   * @param wap 是否使wap版，默认为false
   */
  public Result<AccessToken> refreshAccessToken(String clientId, String clientSecret,
      String refreshToken, Boolean wap) {
    return refreshAccessToken(clientId, clientSecret, "refresh_token", refreshToken, wap);
  }

  /**
   * 权限自动续期，获取Access Token
   * 
   * 文档地址：http://wiki.connect.qq.com/使用authorization_code获取access_token
   * 
   * @param clientId 申请QQ登录成功后，分配给网站的appid。
   * @param clientSecret 申请QQ登录成功后，分配给网站的appkey。
   * @param grantType 授权类型，在本步骤中，此值为“refresh_token”。
   * @param refresToken {@link AccessToken}中的refresToken。
   * @param wap 是否使wap版，默认为false
   */
  public Result<AccessToken> refreshAccessToken(String clientId, String clientSecret,
      String grantType, String refreshToken, Boolean wap) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    connect.addParameter(params, "client_id", clientId);
    connect.addParameter(params, "client_secret", clientSecret);
    connect.addParameter(params, "grant_type", grantType);
    connect.addParameter(params, "refresh_token", refreshToken);
    String url = "https://graph.qq.com/oauth2.0/token";
    if (Boolean.TRUE.equals(wap)) {
      url = "https://graph.z.qq.com/moc2/token";
    }
    String result = connect.get(url, params);
    return parseAccessTokenResult(result);
  }

  /**
   * 获取用户OpenID，此接口适用于PC网站访问
   * 
   * 文档地址：http://wiki.connect.qq.com/获取用户openid_oauth2-0
   * 
   * @param accessToken 授权令牌
   */

  public Result<OpenID> openId(String accessToken) {
    return openId(accessToken, null);
  }

  /**
   * 获取用户OpenID
   * 
   * 文档地址：http://wiki.connect.qq.com/获取用户openid_oauth2-0
   * 
   * @param accessToken 授权令牌
   * @param wap 是否使wap网站访问
   */
  public Result<OpenID> openId(String accessToken, Boolean wap) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    connect.addParameter(params, "access_token", accessToken);
    String url = "https://graph.qq.com/oauth2.0/me";
    if (Boolean.TRUE.equals(wap)) {
      url = "https://graph.z.qq.com/moc2/me";
    }
    String result = connect.get(url, params).trim();
    JSONObject jsonObject;
    if (result.startsWith("callback")) {// PC网站的正确返回结果
      jsonObject =
          new JSONObject(result.substring(result.indexOf("{"), result.lastIndexOf("}") + 1));
    } else {// WAP网站返回结果或错误信息
      jsonObject = new JSONObject();
      String[] results = result.split("\\&");
      for (String param : results) {
        String[] keyValue = param.split("\\=");
        jsonObject.put(keyValue[0], keyValue.length > 0 ? keyValue[1] : null);
      }
      String errorCode = jsonObject.optString("code", null);
      if (errorCode != null) {
        jsonObject.put("ret", errorCode);// To match Error.parse()
      }
    }
    return Result.parse(jsonObject, OpenID.class);
  }

  private Result<AccessToken> parseAccessTokenResult(String result) {
    JSONObject jsonObject;
    if (result.startsWith("callback")) {// 错误信息
                                        // callback({"error":100021,"error_description":"get access token error"});
      jsonObject =
          new JSONObject(result.substring(result.indexOf("{"), result.lastIndexOf("}") + 1));
      return Result.parse(jsonObject, AccessToken.class);
    } else {// 正确结果
      jsonObject = new JSONObject();
      String[] results = result.split("\\&");
      for (String param : results) {
        String[] keyValue = param.split("\\=");
        jsonObject.put(keyValue[0], keyValue.length > 0 ? keyValue[1] : null);
      }
      String errorCode = jsonObject.optString("code", null);
      if (errorCode != null) {
        jsonObject.put("ret", errorCode);// To match Error.parse()
      }
    }
    return Result.parse(jsonObject, AccessToken.class);
  }

}
