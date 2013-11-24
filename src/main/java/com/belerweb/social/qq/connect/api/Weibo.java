package com.belerweb.social.qq.connect.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONObject;

import com.belerweb.social.API;
import com.belerweb.social.bean.Error;
import com.belerweb.social.bean.Result;
import com.belerweb.social.qq.connect.bean.WeiboUser;

/**
 * 腾讯微博API
 */
public final class Weibo extends API {

  protected Weibo(QQConnect connect) {
    super(connect);
  }

  /**
   * 获取腾讯微博登录用户的用户资料。
   * 
   * 文档地址：http://wiki.connect.qq.com/get_info
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openid 用户的ID，与QQ号码一一对应。
   */
  public Result<WeiboUser> getInfo(String accessToken, String openid) {
    return getInfo(connect.getClientId(), accessToken, openid);
  }

  /**
   * 获取腾讯微博登录用户的用户资料。
   * 
   * 文档地址：http://wiki.connect.qq.com/get_info
   * 
   * @param oAuthConsumerKey 申请QQ登录成功后，分配给应用的appid
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openid 用户的ID，与QQ号码一一对应。
   */
  public Result<WeiboUser> getInfo(String oAuthConsumerKey, String accessToken, String openid) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    connect.addParameter(params, "oauth_consumer_key", oAuthConsumerKey);
    connect.addParameter(params, "access_token", accessToken);
    connect.addParameter(params, "openid", openid);
    connect.addParameter(params, "format", "json");
    String json = connect.get("https://graph.qq.com/user/get_info", params);
    JSONObject jsonObject = new JSONObject(json);
    Error error = Error.parse(jsonObject);
    if (error != null) {
      return new Result<WeiboUser>(error);
    }
    return Result.parse(jsonObject.getJSONObject("data"), WeiboUser.class);
  }

  /**
   * 获取腾讯微博其他用户详细信息。
   * 
   * 文档地址：http://wiki.connect.qq.com/get_other_info
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openid 用户的ID，与QQ号码一一对应。
   * @param name 其他用户的账户名。可选，name和fopenid至少选一个，若同时存在则以name值为主。
   */
  public Result<WeiboUser> getOtherInfo(String accessToken, String openid, String name) {
    return getOtherInfo(connect.getClientId(), accessToken, openid, name, null);
  }

  /**
   * 获取腾讯微博其他用户详细信息。
   * 
   * 文档地址：http://wiki.connect.qq.com/get_other_info
   * 
   * @param oAuthConsumerKey 申请QQ登录成功后，分配给应用的appid
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openid 用户的ID，与QQ号码一一对应。
   * @param name 其他用户的账户名。可选，name和fopenid至少选一个，若同时存在则以name值为主。
   * @param fopenid 其他用户的账户名。可选，name和fopenid至少选一个，若同时存在则以name值为主。
   */
  public Result<WeiboUser> getOtherInfo(String oAuthConsumerKey, String accessToken, String openid,
      String name, String fopenid) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    connect.addParameter(params, "oauth_consumer_key", oAuthConsumerKey);
    connect.addParameter(params, "access_token", accessToken);
    connect.addParameter(params, "openid", openid);
    connect.addParameter(params, "format", "json");
    connect.addNotNullParameter(params, "name", name);
    connect.addNotNullParameter(params, "fopenid", fopenid);
    String json = connect.get("https://graph.qq.com/user/get_other_info", params);
    JSONObject jsonObject = new JSONObject(json);
    Error error = Error.parse(jsonObject);
    if (error != null) {
      return new Result<WeiboUser>(error);
    }
    return Result.parse(jsonObject.getJSONObject("data"), WeiboUser.class);
  }

}
