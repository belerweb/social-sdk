package com.belerweb.social.qq.connect.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import com.belerweb.social.API;
import com.belerweb.social.bean.Result;

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
    return getSimpleUserInfo(accessToken, connect.getClientSecret(), openid);
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
  public Result<User> getUserInfo(String accessToken, String oAuthConsumerKey, String openid) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    weibo.addParameter(params, "access_token", accessToken);
    weibo.addParameter(params, "oauth_consumer_key", oAuthConsumerKey);
    weibo.addParameter(params, "openid", openid);
    weibo.addNotNullParameter(params, "access_token", accessToken);
    weibo.addNotNullParameter(params, "format", "json");
    String json = weibo.get("https://graph.qq.com/user/get_user_info", params);
    return Result.parse(json, User.class);
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
    weibo.addParameter(params, "access_token", accessToken);
    weibo.addParameter(params, "oauth_consumer_key", oAuthConsumerKey);
    weibo.addParameter(params, "openid", openid);
    weibo.addNotNullParameter(params, "access_token", accessToken);
    weibo.addNotNullParameter(params, "format", "json");
    String json = weibo.get("https://openmobile.qq.com/user/get_simple_userinfo", params);
    return Result.parse(json, com.belerweb.social.qq.connect.bean.User.class);
  }

}
