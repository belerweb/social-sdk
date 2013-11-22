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
import com.belerweb.social.qq.connect.bean.AlbumPrivilege;

/**
 * QZone API，相册，日志...
 */
public final class QZone extends API {

  protected QZone(QQConnect connect) {
    super(connect);
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

  /**
   * 登录用户创建一个公共相册。注：每个用户最多可创建10个相册。
   * 
   * 文档地址：http://wiki.connect.qq.com/add_album
   * 
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openid 用户的ID，与QQ号码一一对应。
   * @param albumName 相册名，不能超过30个字符。
   */
  public Result<Album> addAlbum(String accessToken, String openid, String albumName) {
    return addAlbum(connect.getClientId(), accessToken, openid, albumName, null, null, null, null);
  }

  /**
   * 登录用户创建相册。注：每个用户最多可创建10个相册。
   * 
   * 文档地址：http://wiki.connect.qq.com/add_album
   * 
   * @param oAuthConsumerKey 申请QQ登录成功后，分配给应用的appid
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openid 用户的ID，与QQ号码一一对应。
   * @param albumName 相册名，不能超过30个字符。
   * @param albumDesc 相册描述，不能超过200个字符。
   * @param privilege 用户的ID，与QQ号码一一对应。 相册权限，
   * 
   *        其取值含义为： 1=公开；3=只主人可见； 4=QQ好友可见； 5=问答加密。
   * 
   *        不传则相册默认为公开权限。
   * 
   *        如果priv取值为5，即相册是问答加密的，则必须包含问题和答案两个参数：
   * 
   *        -question: 问题，不能超过30个字符。
   * 
   *        -answer: 答案，不能超过30个字符。
   */
  public Result<Album> addAlbum(String oAuthConsumerKey, String accessToken, String openid,
      String albumName, String albumDesc, AlbumPrivilege privilege, String question, String answer) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    connect.addParameter(params, "oauth_consumer_key", oAuthConsumerKey);
    connect.addParameter(params, "access_token", accessToken);
    connect.addParameter(params, "openid", openid);
    connect.addParameter(params, "format", "json");
    connect.addParameter(params, "albumname", albumName);
    connect.addNotNullParameter(params, "albumdesc", albumDesc);
    connect.addNotNullParameter(params, "priv", privilege);
    if (privilege == AlbumPrivilege.QUESTION) {
      connect.addParameter(params, "question", question);
      connect.addParameter(params, "answer", answer);
    }
    String json = connect.post("https://graph.qq.com/photo/add_album", params);
    return Result.parse(json, Album.class);
  }

}
