package com.belerweb.social.weixin.api;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.json.JSONObject;

import com.belerweb.social.API;
import com.belerweb.social.bean.Error;
import com.belerweb.social.bean.Result;
import com.belerweb.social.exception.SocialException;
import com.belerweb.social.http.Http;
import com.belerweb.social.weixin.bean.MediaType;

/**
 * 上传下载多媒体文件
 * 
 * 文档地址：http://mp.weixin.qq.com/wiki/index.php?title=上传下载多媒体文件
 * 
 * 公众号在使用接口时，对多媒体文件、多媒体消息的获取和调用等操作，是通过media_id来进行的。通过本接口，公众号可以上传或下载多媒体文件。但请注意，每个多媒体文件（media_id）会在上传、
 * 用户发送到微信服务器3天后自动删除，以节省服务器资源。
 * 
 */
public class Media extends API {

  protected Media(Weixin weixin) {
    super(weixin);
  }

  /**
   * 上传多媒体文件，将把上传成功后的mediaId设置回传入的media中
   * 
   * @param type 媒体文件类型
   * @param media form-data中媒体文件标识，有filename、filelength、content-type等信息
   */
  public Result<com.belerweb.social.weixin.bean.Media> upload(MediaType type,
      com.belerweb.social.weixin.bean.Media media) {
    return upload(weixin.getAccessToken().getToken(), type, media);
  }

  /**
   * 上传多媒体文件，将把上传成功后的mediaId设置回传入的media中
   * 
   * 图片（image）: 256K，支持JPG格式
   * 
   * 语音（voice）：256K，播放长度不超过60s，支持AMR与MP3格式
   * 
   * 视频（video）：2MB，支持MP4格式
   * 
   * 缩略图（thumb）：64KB，支持JPG格式
   * 
   * @param accessToken 调用接口凭证
   * @param type 媒体文件类型
   * @param media form-data中媒体文件标识，有filename、filelength、content-type等信息
   */
  public Result<com.belerweb.social.weixin.bean.Media> upload(String accessToken, MediaType type,
      com.belerweb.social.weixin.bean.Media media) {
    String url =
        "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=" + accessToken + "&type="
            + type.value();
    HttpPost request = new HttpPost(url);
    MultipartEntityBuilder builder =
        MultipartEntityBuilder.create().addBinaryBody("media", media.getContent(),
            ContentType.create(media.getContentType()), media.getName());
    request.setEntity(builder.build());
    try {
      HttpResponse response = Http.CLIENT.execute(request);
      String json = IOUtils.toString(response.getEntity().getContent());
      JSONObject jsonObject = new JSONObject(json);
      Error error = Error.parse(jsonObject);
      if (error != null) {
        return new Result<com.belerweb.social.weixin.bean.Media>(error);
      }
      media.setId(jsonObject.getString("media_id"));
      return new Result<com.belerweb.social.weixin.bean.Media>(media);
    } catch (ClientProtocolException e) {
      throw new SocialException(e);
    } catch (IOException e) {
      throw new SocialException(e);
    }
  }

  /**
   * 下载多媒体文件
   * 
   * @param mediaId 媒体文件ID
   */
  public Result<com.belerweb.social.weixin.bean.Media> get(String mediaId) {
    return get(weixin.getAccessToken().getToken(), mediaId);
  }

  /**
   * 下载多媒体文件
   * 
   * 公众号可调用本接口来获取多媒体文件。请注意，调用该接口需http协议。
   * 
   * @param accessToken 调用接口凭证
   * @param mediaId 媒体文件ID
   */
  public Result<com.belerweb.social.weixin.bean.Media> get(String accessToken, String mediaId) {
    String url =
        "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=" + accessToken
            + "&media_id=" + mediaId;
    try {
      HttpResponse response = Http.CLIENT.execute(new HttpGet(url));
      Header disposition = response.getFirstHeader("Content-disposition");
      HttpEntity entity = response.getEntity();
      if (disposition == null) {
        return new Result<com.belerweb.social.weixin.bean.Media>(Error.parse(new JSONObject(IOUtils
            .toString(entity.getContent()))));
      }

      String fileName = disposition.getValue();
      fileName = fileName.substring(fileName.indexOf("\"") + 1, fileName.lastIndexOf("\""));
      com.belerweb.social.weixin.bean.Media media = new com.belerweb.social.weixin.bean.Media();
      media.setId(mediaId);
      media.setName(fileName);
      media.setContentType(entity.getContentType().getValue());
      media.setContent(IOUtils.toByteArray(entity.getContent()));
      return new Result<com.belerweb.social.weixin.bean.Media>(media);
    } catch (ClientProtocolException e) {
      throw new SocialException(e);
    } catch (IOException e) {
      throw new SocialException(e);
    }
  }
}
