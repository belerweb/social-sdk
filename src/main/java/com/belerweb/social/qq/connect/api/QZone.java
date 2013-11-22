package com.belerweb.social.qq.connect.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import com.belerweb.social.API;
import com.belerweb.social.bean.Error;
import com.belerweb.social.bean.Result;
import com.belerweb.social.exception.SocialException;
import com.belerweb.social.http.Http;
import com.belerweb.social.qq.connect.bean.Album;
import com.belerweb.social.qq.connect.bean.AlbumPrivilege;
import com.belerweb.social.qq.connect.bean.PicUploadResult;

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

  /**
   * 登录用户上传照片，支持单张上传和批量上传。
   * 
   * 文档地址：http://wiki.connect.qq.com/upload_pic
   * 
   * @param oAuthConsumerKey 申请QQ登录成功后，分配给应用的appid
   * @param accessToken 可通过使用Authorization_Code获取Access_Token 或来获取。access_token有3个月有效期。
   * @param openid 用户的ID，与QQ号码一一对应。
   * @param title 照片的命名，必须以.jpg, .gif, .png, .jpeg, .bmp此类后缀结尾。
   * @param picture
   * @param photoDesc 照片描述，注意照片描述不能超过200个字符。
   * @param albumId 相册id。可不填，不填时则根据“mobile”标识选择默认上传的相册。
   * @param mobile
   *        标志位，0表示PC，1表示手机。用于当不传相册id时（即albumid为空时）控制是否传到手机相册。（1）如果传1，则当albumid为空时，图片会上传到手机相册；（2）
   *        如果不传或传0，则当albumid为空时，图片会上传到贴图相册；
   * @param lon 照片拍摄时的地理位置的经度。请使用原始数据（纯经纬度，0-360）。
   * @param lat 照片拍摄时的地理位置的纬度。请使用原始数据（纯经纬度，0-360）。
   * @param needFeed 标识上传照片时是否要发feed（0：不发feed； 1：发feed）。如果不填则默认为发feed。
   * @param successNum 批量上传照片时，已成功上传的张数，指明上传完成情况。单张上传时可以不填，不填则默认为0。
   * @param picNum
   *        批量上传照片的总张数，如果不填则默认为1。如果picnum=1，为单张上传，发送单张上传feed；如果picnum>1，为批量上传，发送批量上传feed。批量上传方式：
   *        picnum为一次上传照片的张数
   *        ，successnum初始值为0，每调用一次照片上传接口后递增其值。信息中心中的feed表现形式：批量上传时最新的7张在feed中展示。其中最新上传的一张图片展示为大图
   *        ，剩下的六张按从新到旧的顺序展示为小图，其他图片不在feed中展示。
   */
  public Result<PicUploadResult> uploadPic(String oAuthConsumerKey, String accessToken,
      String openid, String title, byte[] picture, String photoDesc, String albumId,
      Boolean mobile, Double lon, Double lat, Boolean needFeed, Integer successNum, Integer picNum) {
    HttpPost request = new HttpPost("https://graph.qq.com/photo/upload_pic");
    MultipartEntityBuilder builder =
        MultipartEntityBuilder.create().addBinaryBody("picture", picture,
            ContentType.create("image/" + title.substring(title.lastIndexOf(".") + 1)), title);
    builder.addTextBody("oauth_consumer_key", oAuthConsumerKey);
    builder.addTextBody("access_token", accessToken);
    builder.addTextBody("openid", openid);
    builder.addTextBody("format", "json");
    builder.addTextBody("title", title);
    if (photoDesc != null) {
      builder.addTextBody("photodesc", photoDesc);
    }
    if (albumId != null) {
      builder.addTextBody("albumid", albumId);
    }
    if (Boolean.TRUE.equals(mobile)) {
      builder.addTextBody("mobile", "1");
    }
    if (lon != null) {
      builder.addTextBody("x", lon.toString());
    }
    if (lat != null) {
      builder.addTextBody("y", lat.toString());
    }
    if (Boolean.FALSE.equals(needFeed)) {
      builder.addTextBody("needfeed", "0");
    }
    if (successNum != null) {
      builder.addTextBody("successnum", successNum.toString());
    }
    if (picNum != null) {
      builder.addTextBody("picnum", picNum.toString());
    }
    request.setEntity(builder.build());
    try {
      HttpResponse response = Http.CLIENT.execute(request);
      String json = IOUtils.toString(response.getEntity().getContent());
      return Result.parse(json, PicUploadResult.class);
    } catch (ClientProtocolException e) {
      throw new SocialException(e);
    } catch (IOException e) {
      throw new SocialException(e);
    }
  }

}
