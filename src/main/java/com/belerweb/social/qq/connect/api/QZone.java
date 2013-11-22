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

}
