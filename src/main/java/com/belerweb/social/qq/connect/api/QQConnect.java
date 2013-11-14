package com.belerweb.social.qq.connect.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;

import com.belerweb.social.SDK;
import com.belerweb.social.bean.Result;

public final class QQConnect extends SDK {

  private String clientId;
  private String clientSecret;
  private String redirectUri;

  private OAuth2 oAuth2;
  private User user;

  public QQConnect(String clientId, String clientSecret) {
    this.clientId = clientId;
    this.clientSecret = clientSecret;
  }

  public QQConnect(String clientId, String clientSecret, String redirectUri) {
    this(clientId, clientSecret);
    this.redirectUri = redirectUri;
  }

  /**
   * 收听腾讯微博上的用户。
   * 
   * 文档地址：http://wiki.connect.qq.com/add_idol
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openId 用户的ID，与QQ号码一一对应。
   * @param name 要收听的用户的账户名列表。最多30个。
   */
  public Result<Error> addIdol(String accessToken, String openId, List<String> name) {
    return addIdol(accessToken, getClientId(), openId, name, null);
  }

  /**
   * 收听腾讯微博上的用户。
   * 
   * 文档地址：http://wiki.connect.qq.com/add_idol
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openId 用户的ID，与QQ号码一一对应。
   * @param name 要收听的用户的账户名列表。最多30个。
   * @param fopenids 要收听的用户的openid列表。最多30个。 name和fopenids至少选一个，若同时存在则以name值为主。
   */
  public Result<Error> addIdol(String accessToken, String openId, List<String> name,
      List<String> fopenids) {
    return addIdol(accessToken, getClientId(), openId, name, fopenids);
  }

  /**
   * 收听腾讯微博上的用户。
   * 
   * 文档地址：http://wiki.connect.qq.com/add_idol
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param oauthConsumerKey 申请QQ登录成功后，分配给应用的appid
   * @param openId 用户的ID，与QQ号码一一对应。
   * @param name 要收听的用户的账户名列表。最多30个。
   * @param fopenids 要收听的用户的openid列表。最多30个。 name和fopenids至少选一个，若同时存在则以name值为主。
   */
  public Result<Error> addIdol(String accessToken, String oauthConsumerKey, String openId,
      List<String> name, List<String> fopenids) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    addParameter(params, "access_token", accessToken);
    addParameter(params, "oauth_consumer_key", oauthConsumerKey);
    addParameter(params, "openid", openId);
    if (name != null && !name.isEmpty()) {
      addParameter(params, "name", StringUtils.join(name, ","));
    }
    if (fopenids != null && !fopenids.isEmpty()) {
      addParameter(params, "fopenids", StringUtils.join(fopenids, "_"));
    }
    addParameter(params, "format", "json");
    return Result.parse(post("https://graph.qq.com/relation/add_idol", params), Error.class);
  }

  public OAuth2 getOAuth2() {
    if (oAuth2 == null) {
      oAuth2 = new OAuth2(this);
    }
    return oAuth2;
  }

  public User getUser() {
    if (user == null) {
      user = new User(this);
    }
    return user;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public String getRedirectUri() {
    return redirectUri;
  }

  public void setRedirectUri(String redirectUri) {
    this.redirectUri = redirectUri;
  }

}
