package com.belerweb.social.qq.connect.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import com.belerweb.social.API;
import com.belerweb.social.bean.Error;
import com.belerweb.social.bean.Result;
import com.belerweb.social.qq.connect.bean.Album;

/**
 * 访问用户资料
 */
public final class User extends API {

  protected User(QQConnect connect) {
    super(connect);
  }

  /**
   * 获取登录用户在QQ空间的信息，包括昵称、头像、性别及黄钻信息（包括黄钻等级、是否年费黄钻等）。此接口仅支持网站调用
   * 
   * 文档地址：http://wiki.connect.qq.com/get_user_info
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openid 用户的ID，与QQ号码一一对应。
   *        可通过调用https://graph.qq.com/oauth2.0/me?access_token=YOUR_ACCESS_TOKEN 来获取。
   */
  public Result<com.belerweb.social.qq.connect.bean.User> getUserInfo(String accessToken,
      String openid) {
    return getUserInfo(accessToken, connect.getClientId(), openid);
  }

  /**
   * 获取登录用户在QQ空间的信息，包括昵称、头像、性别及黄钻信息（包括黄钻等级、是否年费黄钻等）。此接口仅支持网站调用
   * 
   * 文档地址：http://wiki.connect.qq.com/get_user_info
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param oAuthConsumerKey 申请QQ登录成功后，分配给应用的appid
   * @param openid 用户的ID，与QQ号码一一对应。
   *        可通过调用https://graph.qq.com/oauth2.0/me?access_token=YOUR_ACCESS_TOKEN 来获取。
   */
  public Result<com.belerweb.social.qq.connect.bean.User> getUserInfo(String accessToken,
      String oAuthConsumerKey, String openid) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    connect.addParameter(params, "access_token", accessToken);
    connect.addParameter(params, "oauth_consumer_key", oAuthConsumerKey);
    connect.addParameter(params, "openid", openid);
    connect.addNotNullParameter(params, "format", "json");
    String json = connect.get("https://graph.qq.com/user/get_user_info", params);
    return Result.parse(json, com.belerweb.social.qq.connect.bean.User.class);
  }

  /**
   * 获取移动端应用的登录用户在QQ空间的简单个人信息，包括昵称、头像和黄钻信息（包括黄钻等级、是否年费黄钻等），以及用户的QQ头像。 此接口仅支持移动端应用调用
   * 
   * 文档地址：http://wiki.connect.qq.com/get_simple_userinfo
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param oAuthConsumerKey 申请QQ登录成功后，分配给应用的appid
   * @param openid 用户的ID，与QQ号码一一对应。
   *        可通过调用https://graph.qq.com/oauth2.0/me?access_token=YOUR_ACCESS_TOKEN 来获取。
   */
  public Result<com.belerweb.social.qq.connect.bean.User> getSimpleUserInfo(String accessToken,
      String oAuthConsumerKey, String openid) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    connect.addParameter(params, "access_token", accessToken);
    connect.addParameter(params, "oauth_consumer_key", oAuthConsumerKey);
    connect.addParameter(params, "openid", openid);
    connect.addNotNullParameter(params, "format", "json");
    String json = connect.get("https://openmobile.qq.com/user/get_simple_userinfo", params);
    return Result.parse(json, com.belerweb.social.qq.connect.bean.User.class);
  }

  /**
   * 获取已登录用户的关于QQ会员业务的基本资料。
   * 
   * 基本资料包括以下信息：是否为“普通包月会员”，是否为“年费会员”，QQ会员等级信息，是否为“豪华版QQ会员”，是否为“钻皇会员”，是否为“SVIP”。
   * 
   * 文档地址：http://wiki.connect.qq.com/get_vip_info
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openid 用户的ID，与QQ号码一一对应。
   */
  public Result<com.belerweb.social.qq.connect.bean.User> getVipInfo(String accessToken,
      String openid) {
    return getVipInfo(accessToken, connect.getClientId(), openid);
  }

  /**
   * 获取已登录用户的关于QQ会员业务的基本资料。
   * 
   * 基本资料包括以下信息：是否为“普通包月会员”，是否为“年费会员”，QQ会员等级信息，是否为“豪华版QQ会员”，是否为“钻皇会员”，是否为“SVIP”。
   * 
   * 文档地址：http://wiki.connect.qq.com/get_vip_info
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param oAuthConsumerKey 申请QQ登录成功后，分配给应用的appid
   * @param openid 用户的ID，与QQ号码一一对应。
   */
  public Result<com.belerweb.social.qq.connect.bean.User> getVipInfo(String accessToken,
      String oAuthConsumerKey, String openid) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    connect.addParameter(params, "access_token", accessToken);
    connect.addParameter(params, "oauth_consumer_key", oAuthConsumerKey);
    connect.addParameter(params, "openid", openid);
    connect.addParameter(params, "format", "json");
    String json = connect.get("https://graph.qq.com/user/get_vip_info", params);
    return Result.parse(json, com.belerweb.social.qq.connect.bean.User.class);
  }

  /**
   * 获取已登录用户的关于QQ会员业务的详细资料。
   * 
   * 详细资料包括：用户会员的历史属性，用户会员特权的到期时间，用户最后一次充值会员业务的支付渠道，用户开通会员的主要驱动因素。
   * 
   * 文档地址：http://wiki.connect.qq.com/get_vip_rich_info
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openid 用户的ID，与QQ号码一一对应。
   */
  public Result<com.belerweb.social.qq.connect.bean.User> getVipRichInfo(String accessToken,
      String openid) {
    return getVipRichInfo(connect.getClientId(), accessToken, openid);
  }

  /**
   * 获取已登录用户的关于QQ会员业务的详细资料。
   * 
   * 详细资料包括：用户会员的历史属性，用户会员特权的到期时间，用户最后一次充值会员业务的支付渠道，用户开通会员的主要驱动因素。
   * 
   * 文档地址：http://wiki.connect.qq.com/get_vip_rich_info
   * 
   * @param oAuthConsumerKey 申请QQ登录成功后，分配给应用的appid
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openid 用户的ID，与QQ号码一一对应。
   */
  public Result<com.belerweb.social.qq.connect.bean.User> getVipRichInfo(String oAuthConsumerKey,
      String accessToken, String openid) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    connect.addParameter(params, "oauth_consumer_key", oAuthConsumerKey);
    connect.addParameter(params, "access_token", accessToken);
    connect.addParameter(params, "openid", openid);
    connect.addParameter(params, "format", "json");
    String json = connect.get("https://graph.qq.com/user/get_vip_rich_info", params);
    return Result.parse(json, com.belerweb.social.qq.connect.bean.User.class);
  }

  /**
   * 获取登录用户的相册列表。
   * 
   * 文档地址：http://wiki.connect.qq.com/list_album
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openid 用户的ID，与QQ号码一一对应。
   */
  public Result<Album> listAlbum(String accessToken, String openid) {
    return listAlbum(connect.getClientId(), accessToken, openid);
  }

  /**
   * 获取登录用户的相册列表。
   * 
   * 文档地址：http://wiki.connect.qq.com/list_album
   * 
   * @param oAuthConsumerKey 申请QQ登录成功后，分配给应用的appid
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openid 用户的ID，与QQ号码一一对应。
   */
  public Result<Album> listAlbum(String oAuthConsumerKey, String accessToken, String openid) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    connect.addParameter(params, "oauth_consumer_key", oAuthConsumerKey);
    connect.addParameter(params, "access_token", accessToken);
    connect.addParameter(params, "openid", openid);
    connect.addParameter(params, "format", "json");
    String json = connect.get("https://graph.qq.com/photo/list_album", params);
    JSONObject jsonObject = new JSONObject(json);
    Error error = Error.parse(jsonObject);
    if (error != null) {
      return new Result<Album>(error);
    }
    List<Album> results = new ArrayList<Album>();
    JSONArray jsonArray = jsonObject.getJSONArray("album");
    for (int i = 0; i < jsonArray.length(); i++) {
      results.add(Album.parse(jsonArray.getJSONObject(i)));
    }
    return new Result<Album>(results);
  }

}
