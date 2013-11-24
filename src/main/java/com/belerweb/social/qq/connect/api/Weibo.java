package com.belerweb.social.qq.connect.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONObject;

import com.belerweb.social.API;
import com.belerweb.social.bean.Error;
import com.belerweb.social.bean.Result;
import com.belerweb.social.qq.connect.bean.FanList;
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

  /**
   * 获取登录用户的听众列表。
   * 
   * 文档地址：http://wiki.connect.qq.com/get_fanslist
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openid 用户的ID，与QQ号码一一对应。
   * @param reqNum 必须。请求获取的听众个数。取值范围为1-30。
   * @param startIndex 必须。请求获取听众列表的起始位置。第一页：0；继续向下翻页：reqnum*（page-1）。
   */
  public Result<FanList> getFansList(String accessToken, String openid, int reqNum, int startIndex) {
    return getFansList(connect.getClientId(), accessToken, openid, reqNum, startIndex, null, null,
        null);
  }

  /**
   * 获取登录用户的听众列表。
   * 
   * 文档地址：http://wiki.connect.qq.com/get_fanslist
   * 
   * @param oAuthConsumerKey 申请QQ登录成功后，分配给应用的appid
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openid 用户的ID，与QQ号码一一对应。
   * @param reqNum 必须。请求获取的听众个数。取值范围为1-30。
   * @param startIndex 必须。请求获取听众列表的起始位置。第一页：0；继续向下翻页：reqnum*（page-1）。
   * @param newMode 
   *        获取听众信息的模式。获取听众信息的模式，默认值为0。0：旧模式，新添加的听众信息排在前面，最多只能拉取1000个听众的信息。1：新模式，可以拉取所有听众的信息，暂时不支持排序。
   * @param install 判断获取的是安装应用的听众，还是未安装应用的听众。 0：不考虑该参数；1：获取已安装应用的听众信息；2：获取未安装应用的听众信息。
   * @param sex 按性别过滤标识，默认为0。此参数当mode=0时使用，支持排序。 1：获取的是男性听众信息；2：获取的是女性听众信息；0：不进行性别过滤，获取所有听众信息。
   */
  public Result<FanList> getFansList(String oAuthConsumerKey, String accessToken, String openid,
      int reqNum, int startIndex, Boolean newMode, Integer install, Integer sex) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    connect.addParameter(params, "oauth_consumer_key", oAuthConsumerKey);
    connect.addParameter(params, "access_token", accessToken);
    connect.addParameter(params, "openid", openid);
    connect.addParameter(params, "format", "json");
    connect.addParameter(params, "reqnum", reqNum);
    connect.addParameter(params, "startindex", startIndex);
    if (Boolean.TRUE.equals(newMode)) {
      connect.addParameter(params, "mode", "1");
    }
    connect.addNotNullParameter(params, "install", install);
    connect.addNotNullParameter(params, "sex", sex);
    String json = connect.get("https://graph.qq.com/relation/get_fanslist", params);
    JSONObject jsonObject = new JSONObject(json);
    Error error = Error.parse(jsonObject);
    if (error != null) {
      return new Result<FanList>(error);
    }
    return Result.parse(jsonObject.getJSONObject("data"), FanList.class);
  }

}
