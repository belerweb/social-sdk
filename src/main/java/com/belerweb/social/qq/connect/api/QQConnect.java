package com.belerweb.social.qq.connect.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.json.JSONObject;

import com.belerweb.social.SDK;
import com.belerweb.social.bean.Error;
import com.belerweb.social.bean.Result;
import com.belerweb.social.qq.connect.bean.NewT;

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
    return addIdol(accessToken, openId, name, null);
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

  /**
   * 取消收听腾讯微博上的用户。
   * 
   * 文档地址：http://wiki.connect.qq.com/del_idol
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openId 用户的ID，与QQ号码一一对应。
   * @param name 要取消收听的用户的账户名。 可选，name和fopenid至少选一个，若同时存在则以name值为主。
   */
  public Result<Error> delIdol(String accessToken, String openId, String name) {
    return delIdol(accessToken, openId, name, null);
  }

  /**
   * 取消收听腾讯微博上的用户。
   * 
   * 文档地址：http://wiki.connect.qq.com/del_idol
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openId 用户的ID，与QQ号码一一对应。
   * @param name 要取消收听的用户的账户名。 可选，name和fopenid至少选一个，若同时存在则以name值为主。
   * @param fopenid 要取消收听的用户的openid。可选，name和fopenid至少选一个，若同时存在则以name值为主。
   */
  public Result<Error> delIdol(String accessToken, String openId, String name, String fopenid) {
    return delIdol(accessToken, getClientId(), openId, name, fopenid);
  }

  /**
   * 取消收听腾讯微博上的用户。
   * 
   * 文档地址：http://wiki.connect.qq.com/del_idol
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param oauthConsumerKey 申请QQ登录成功后，分配给应用的appid
   * @param openId 用户的ID，与QQ号码一一对应。
   * @param name 要取消收听的用户的账户名。 可选，name和fopenid至少选一个，若同时存在则以name值为主。
   * @param fopenid 要取消收听的用户的openid。可选，name和fopenid至少选一个，若同时存在则以name值为主。
   */
  public Result<Error> delIdol(String accessToken, String oauthConsumerKey, String openId,
      String name, String fopenid) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    addParameter(params, "access_token", accessToken);
    addParameter(params, "oauth_consumer_key", oauthConsumerKey);
    addParameter(params, "openid", openId);
    addNotNullParameter(params, "name", name);
    addNotNullParameter(params, "fopenid", fopenid);
    addParameter(params, "format", "json");
    return Result.parse(post("https://graph.qq.com/relation/del_idol", params), Error.class);
  }

  /**
   * 登录用户发表一篇新日志。
   * 
   * 文档地址：http://wiki.connect.qq.com/add_one_blog
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openId 用户的ID，与QQ号码一一对应。
   * @param title 日志标题（纯文本，最大长度128个字节，utf-8编码）。
   * @param content 文章内容（html数据，最大长度100*1024个字节，utf-8编码）.
   */
  public Result<Error> addOneBlog(String accessToken, String openId, String title, String content) {
    return addOneBlog(accessToken, getClientId(), openId, title, content);
  }

  /**
   * 登录用户发表一篇新日志。
   * 
   * 文档地址：http://wiki.connect.qq.com/add_one_blog
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param oauthConsumerKey 申请QQ登录成功后，分配给应用的appid
   * @param openId 用户的ID，与QQ号码一一对应。
   * @param title 日志标题（纯文本，最大长度128个字节，utf-8编码）。
   * @param content 文章内容（html数据，最大长度100*1024个字节，utf-8编码）.
   */
  public Result<Error> addOneBlog(String accessToken, String oauthConsumerKey, String openId,
      String title, String content) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    addParameter(params, "access_token", accessToken);
    addParameter(params, "oauth_consumer_key", oauthConsumerKey);
    addParameter(params, "openid", openId);
    addParameter(params, "title", title);
    addParameter(params, "content", content);
    addParameter(params, "format", "json");
    return Result.parse(post("https://graph.qq.com/blog/add_one_blog", params), Error.class);
  }

  /**
   * 发表一条微博信息（纯文本）到腾讯微博平台上。注意连续两次发布的微博内容不可以重复。
   * 
   * 文档地址：http://wiki.connect.qq.com/add_t
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param oauthConsumerKey 申请QQ登录成功后，分配给应用的appid
   * @param openId 用户的ID，与QQ号码一一对应。
   * @param content
   *        表示要发表的微博内容。必须为UTF-8编码，最长为140个汉字，也就是420字节。如果微博内容中有URL，后台会自动将该URL转换为短URL，每个URL折算成11个字节。
   *        若在此处@好友，需正确填写好友的微博账号，而非昵称。
   */
  public Result<NewT> addT(String accessToken, String oauthConsumerKey, String openId,
      String content) {
    return addT(accessToken, oauthConsumerKey, openId, content, null, null, null, true, true);
  }

  /**
   * 发表一条微博信息（纯文本）到腾讯微博平台上。注意连续两次发布的微博内容不可以重复。
   * 
   * 文档地址：http://wiki.connect.qq.com/add_t
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param oauthConsumerKey 申请QQ登录成功后，分配给应用的appid
   * @param openId 用户的ID，与QQ号码一一对应。
   * @param content
   *        表示要发表的微博内容。必须为UTF-8编码，最长为140个汉字，也就是420字节。如果微博内容中有URL，后台会自动将该URL转换为短URL，每个URL折算成11个字节。
   *        若在此处@好友，需正确填写好友的微博账号，而非昵称。
   * @param clientIp 用户ip。必须正确填写用户侧真实ip，不能为内网ip及以127或255开头的ip，以分析用户所在地。
   * @param lon 用户所在地理位置的经度。为实数，最多支持10位有效数字。有效范围：-180.0到+180.0，+表示东经，默认为0.0。
   * @param lat 用户所在地理位置的纬度。为实数，最多支持10位有效数字。有效范围：-90.0到+90.0，+表示北纬，默认为0.0。
   * @param sync 标识是否将发布的微博同步到QQ空间（0：同步； 1：不同步；），默认为0。该参数只支持OAuth1.0，OAuth2.0暂不支持。
   * @param compatible 容错标志，支持按位操作，默认为0。0x20：微博内容长度超过140字则报错；0：以上错误均做容错处理，即发表普通微博。
   */
  public Result<NewT> addT(String accessToken, String oauthConsumerKey, String openId,
      String content, String clientIp, Double lon, Double lat, Boolean sync, Boolean compatible) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    addParameter(params, "access_token", accessToken);
    addParameter(params, "oauth_consumer_key", oauthConsumerKey);
    addParameter(params, "openid", openId);
    addParameter(params, "content", content);
    addNotNullParameter(params, "clientip", clientIp);
    addNotNullParameter(params, "lon", lon);
    addNotNullParameter(params, "lat", lat);
    if (sync != null) {
      addParameter(params, "syncflag", sync ? "0" : "1");
    }
    if (compatible != null) {
      addParameter(params, "compatibleflag", compatible ? "0" : "0x20");
    }
    addParameter(params, "format", "json");
    JSONObject jsonObject = new JSONObject(post("https://graph.qq.com/t/add_t", params));
    Error error = Error.parse(jsonObject);
    if (error != null) {
      return new Result<NewT>(error);
    }
    return Result.parse(jsonObject.getJSONObject("data"), NewT.class);
  }

  /**
   * 根据微博ID删除指定微博。
   * 
   * 文档地址：http://wiki.connect.qq.com/del_t
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param oauthConsumerKey 申请QQ登录成功后，分配给应用的appid
   * @param openId 用户的ID，与QQ号码一一对应。
   * @param id 微博消息的ID，用来唯一标识一条微博消息。
   */
  public Result<Error> delT(String accessToken, String oauthConsumerKey, String openId, String id) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    addParameter(params, "access_token", accessToken);
    addParameter(params, "oauth_consumer_key", oauthConsumerKey);
    addParameter(params, "openid", openId);
    addParameter(params, "id", id);
    addParameter(params, "format", "json");
    return Result.parse(post("https://graph.qq.com/t/del_t", params), Error.class);
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
