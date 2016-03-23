package com.belerweb.social.weixin.api;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

import com.belerweb.social.SDK;
import com.belerweb.social.bean.Error;
import com.belerweb.social.bean.Result;
import com.belerweb.social.exception.SocialException;
import com.belerweb.social.weixin.bean.AccessToken;
import com.belerweb.social.weixin.bean.ApiTicket;
import com.belerweb.social.weixin.bean.JSApiTicket;
import com.belerweb.social.weixin.bean.Message;
import com.belerweb.social.weixin.bean.QRCreation;
import com.belerweb.social.weixin.bean.QRTicket;
import com.belerweb.social.weixin.bean.QRType;

/**
 * 微信SDK
 */
public final class Weixin extends SDK {

  private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

  private String appId;
  private String secret;
  private String redirectUri;
  private String token;

  private OAuth2 oAuth2;
  private User user;
  private Group group;
  private Media media;
  private Menu menu;

  private AccessToken accessToken;
  private Date accessTokenTime;

  private JSApiTicket jsApiTicket;
  private Date jsApiTicketTime;

  private ApiTicket apiTicket;
  private Date apiTicketTime;

  /**
   * 只传入token实例化微信SDK，适合于只开发基于微信基础接口的被动接受消息类应用，如智能应答机器人。不推荐适用。
   * 
   * @param token 在公众平台网站的高级功能 –
   *        开发模式页，点击“成为开发者”按钮，填写URL和Token，其中URL是开发者用来接收微信服务器数据的接口URL。Token可由开发者可以任意填写
   *        ，用作生成签名（该Token会和接口URL中包含的Token进行比对，从而验证安全性）。
   */
  public Weixin(String token) {
    super(DEFAULT_CHARSET);
    this.token = token;
  }

  /**
   * 通过appId和secret实例化微信SDK，适合于只开发基于微信高级接口的OAuth2应用，如客服功能。
   * 
   * @param appId 公众号的唯一标识
   * @param secret 公众号的appsecret
   */
  public Weixin(String appId, String secret) {
    super(DEFAULT_CHARSET);
    this.appId = appId;
    this.secret = secret;
  }


  /**
   * 通过token、appId和secret实例化微信SDK，支持微信基础和高级接口。推荐适用
   * 
   * @param appId 公众号的唯一标识
   * @param secret 公众号的appsecret
   * @param token 在公众平台网站的高级功能 –
   *        开发模式页，点击“成为开发者”按钮，填写URL和Token，其中URL是开发者用来接收微信服务器数据的接口URL。Token可由开发者可以任意填写
   *        ，用作生成签名（该Token会和接口URL中包含的Token进行比对，从而验证安全性）。
   */
  public Weixin(String appId, String secret, String token) {
    this(appId, secret);
    this.token = token;
  }

  public Weixin(String appid, String secret, String redirectUri, String token) {
    this(appid, secret, token);
    this.redirectUri = redirectUri;
  }

  /**
   * 验证消息真实性
   * 
   * 文档地址：http://mp.weixin.qq.com/wiki/index.php?title=验证消息真实性
   * 
   * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
   * @param timestamp 时间戳
   * @param nonce 随机数
   * @return 消息有效返回true，否则返回false
   */
  public boolean validate(String signature, String timestamp, String nonce) {
    String[] chars = new String[] {token, timestamp, nonce,};
    Arrays.sort(chars);
    String sha1 = DigestUtils.shaHex(StringUtils.join(chars));
    if (sha1.equals(signature)) {
      return true;
    }

    return false;
  }

  /**
   * 签名传入的参数,按照字典顺序排序后连接起来sha1 文档地址：<a href=
   * "http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html#.E9.99.84.E5.BD.954-.E5.8D.A1.E5.88.B8.E6.89.A9.E5.B1.95.E5.AD.97.E6.AE.B5.E5.8F.8A.E7.AD.BE.E5.90.8D.E7.94.9F.E6.88.90.E7.AE.97.E6.B3.95"
   * >卡券扩展字段及签名生成算法</a>
   * 
   * @param args
   * @return
   */
  public String signature(String... args) {
    Arrays.sort(args);
    return DigestUtils.shaHex(StringUtils.join(args));
  }

  /**
   * jsapi_ticket签名算法
   * 
   * 文档地址：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html#.E9.99.84.E5.BD.951-
   * JS-SDK.E4.BD.BF.E7.94.A8.E6.9D.83.E9.99.90.E7.AD.BE.E5.90.8D.E7.AE.97.E6.B3.95
   * 
   * @param url 网页的url地址不包括 {@code #} 后面的参数(不包含锚的值).但是包括所有的请求参数
   * @param timestamp 时间戳
   * @param nonce 随机数
   * @return 返回签名后的字符串
   */
  public String jsapiSignature(String url, long timestamp, String nonce) {
    StringBuilder content = new StringBuilder();
    content.append("jsapi_ticket=").append(getJsApiTicket().getTicket());
    content.append("&noncestr=").append(nonce);
    content.append("&timestamp=").append(timestamp);
    content.append("&url=").append(url);
    return DigestUtils.shaHex(content.toString());
  }


  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public String getRedirectUri() {
    return redirectUri;
  }

  public void setRedirectUri(String redirectUri) {
    this.redirectUri = redirectUri;
  }

  /**
   * 获取access token
   * 
   * access_token是公众号的全局唯一票据，公众号调用各接口时都需使用access_token。正常情况下access_token有效期为7200秒，
   * 重复获取将导致上次获取的access_token失效。
   * 
   * 公众号可以使用AppID和AppSecret调用本接口来获取access_token。AppID和AppSecret可在开发模式中获得（需要已经成为开发者，且帐号没有异常状态）。
   */
  public synchronized AccessToken getAccessToken() {
    if (accessToken == null || accessTokenTime == null
        || (new Date().getTime() - accessTokenTime.getTime()) / 1000 > accessToken.getExpiresIn()) {
      List<NameValuePair> params = new ArrayList<NameValuePair>();
      addParameter(params, "appid", appId);
      addParameter(params, "secret", secret);
      addParameter(params, "grant_type", "client_credential");
      String json =
          get("https://api.weixin.qq.com/cgi-bin/token?" + StringUtils.join(params, "&"), params);
      Result<AccessToken> result = Result.parse(json, AccessToken.class);
      if (result.success()) {
        accessToken = result.getResult();
        accessTokenTime = new Date();
      }
    }

    return accessToken;
  }

  /**
   * api_ticket 是用于调用微信卡券JS API的临时票据，有效期为7200 秒，通过access_token 来获取。
   * 
   * 文档地址:<a href=
   * "http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html#.E8.8E.B7.E5.8F.96api_ticket"
   * >获取api_ticket</a>
   * 
   * 由于获取api_ticket 的api 调用次数非常有限，频繁刷新api_ticket 会导致api调用受限，影响自身业务，开发者需在自己的服务存储与更新api_ticket。
   */
  public synchronized ApiTicket getApiTicket() {
    if (apiTicket == null || apiTicketTime == null
        || (new Date().getTime() - apiTicketTime.getTime()) / 1000 > apiTicket.getExpiresIn()) {
      List<NameValuePair> params = new ArrayList<NameValuePair>();
      addParameter(params, "access_token", getAccessToken().getToken());
      addParameter(params, "type", "wx_card");
      String json =
          get("https://api.weixin.qq.com/cgi-bin/ticket/getticket?" + StringUtils.join(params, "&"),
              params);
      Result<ApiTicket> result = Result.parse(json, ApiTicket.class);
      if (result.success()) {
        apiTicket = result.getResult();
        apiTicketTime = new Date();
      }
    }

    return apiTicket;
  }

  /**
   * jsapi_ticket是公众号用于调用微信JS接口的临时票据。正常情况下，jsapi_ticket的有效期为7200秒，通过access_token来获取。
   * 
   * 文档地址:http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html#.E9.99.84.E5.BD.951-
   * JS-SDK.E4.BD.BF.E7.94.A8.E6.9D.83.E9.99.90.E7.AD.BE.E5.90.8D.E7.AE.97.E6.B3.95
   * 
   * 由于获取jsapi_ticket的api调用次数非常有限，频繁刷新jsapi_ticket会导致api调用受限，影响自身业务，开发者必须在自己的服务全局缓存jsapi_ticket 。
   */
  public synchronized JSApiTicket getJsApiTicket() {
    if (jsApiTicket == null || jsApiTicketTime == null
        || (new Date().getTime() - jsApiTicketTime.getTime()) / 1000 > jsApiTicket.getExpiresIn()) {
      List<NameValuePair> params = new ArrayList<NameValuePair>();
      addParameter(params, "access_token", getAccessToken().getToken());
      addParameter(params, "type", "jsapi");
      String json =
          get("https://api.weixin.qq.com/cgi-bin/ticket/getticket?" + StringUtils.join(params, "&"),
              params);
      Result<JSApiTicket> result = Result.parse(json, JSApiTicket.class);
      if (result.success()) {
        jsApiTicket = result.getResult();
        jsApiTicketTime = new Date();
      }
    }

    return jsApiTicket;
  }

  /**
   * 自动获取accessToken并创建二维码ticket
   * 
   * 每次创建二维码ticket需要提供一个开发者自行设定的参数（scene_id）
   * 
   * 文档地址：http://mp.weixin.qq.com/wiki/index.php?title=生成带参数的二维码
   * 
   * @param type 二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久
   * @param sceneId 场景值ID，临时二维码时为32位整型，永久二维码时最大值为1000
   */
  public Result<QRTicket> createQR(QRType type, Integer sceneId) {
    return createQR(getAccessToken().getToken(), type, sceneId);
  }

  /**
   * 创建二维码ticket
   * 
   * 每次创建二维码ticket需要提供一个开发者自行设定的参数（scene_id）
   * 
   * 文档地址：http://mp.weixin.qq.com/wiki/index.php?title=生成带参数的二维码
   * 
   * @param accessToken access_token是公众号的全局唯一票据
   * @param type 二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久
   * @param sceneId 场景值ID，临时二维码时为32位整型，永久二维码时最大值为1000
   */
  public Result<QRTicket> createQR(String accessToken, QRType type, Integer sceneId) {
    QRCreation request = new QRCreation();
    request.setType(type);
    request.setSceneId(sceneId);
    try {
      String json =
          post("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + accessToken,
              new StringEntity(request.toString()));
      return Result.parse(json, QRTicket.class);
    } catch (UnsupportedEncodingException e) {
      throw new SocialException(e);
    }
  }

  /**
   * 发送客服消息
   * 
   * 当用户主动发消息给公众号的时候，微信将会把消息数据推送给开发者，开发者在一段时间内（目前为24小时）可以调用客服消息接口，通过POST一个JSON数据包来发送消息给普通用户，
   * 在24小时内不限制发送次数。此接口主要用于客服等有人工消息处理环节的功能，方便开发者为用户提供更加优质的服务。
   * 
   * 文档地址：http://mp.weixin.qq.com/wiki/index.php?title=发送客服消息
   * 
   * @param message 消息
   */
  public Result<Boolean> sendCustomMessage(Message message) {
    return sendCustomMessage(getAccessToken().getToken(), message);
  }

  /**
   * 发送客服消息
   * 
   * 当用户主动发消息给公众号的时候，微信将会把消息数据推送给开发者，开发者在一段时间内（目前为24小时）可以调用客服消息接口，通过POST一个JSON数据包来发送消息给普通用户，
   * 在24小时内不限制发送次数。此接口主要用于客服等有人工消息处理环节的功能，方便开发者为用户提供更加优质的服务。
   * 
   * 文档地址：http://mp.weixin.qq.com/wiki/index.php?title=发送客服消息
   * 
   * @param accessToken access_token是公众号的全局唯一票据
   * @param message 消息
   */
  public Result<Boolean> sendCustomMessage(String accessToken, Message message) {
    try {
      // {"errcode":0,"errmsg":"ok"}
      // {"errcode":45015,"errmsg":"response out of time limit"}
      String json =
          post("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + accessToken,
              new StringEntity(message.toJSON(), "UTF-8"));
      return new Result<Boolean>(Error.parse(new JSONObject(json)));
    } catch (UnsupportedEncodingException e) {
      throw new SocialException(e);
    }
  }

  /**
   * 发送模板消息
   * 
   * <p>
   * 为了保证用户不受到骚扰，在开发者出现需要主动提醒、通知用户时，才允许开发者在公众平台网站中模板消息库中选择模板，选择后获得模板ID，再根据模板ID向用户主动推送提醒、通知消息。
   * </p>
   * <p>
   * 模板消息调用时主要需要模板ID和模板中各参数的赋值内容。请注意：
   * <ol>
   * <li>模板中参数内容必须以".DATA"结尾，否则视为保留字;</li>
   * <li>模板保留符号"{{ }}"</li>
   * </ol>
   * </p>
   * 具体调用方法
   * <p>
   * 第一步：获取模板ID<br />
   * 通过在模板消息功能的模板库中使用需要的模板，可以获得模板ID。
   * </p>
   * <p>
   * 第二步：请求接口
   * </p>
   * 
   * 文档地址：https://mp.weixin.qq.com/advanced/tmplmsg?action=faq&lang=zh_CN
   * 
   * @param message 消息
   */
  public Result<Boolean> sendTemplateMessage(Message message) {
    return sendTemplateMessage(getAccessToken().getToken(), message);
  }

  /**
   * 发送模板消息
   * 
   * <p>
   * 为了保证用户不受到骚扰，在开发者出现需要主动提醒、通知用户时，才允许开发者在公众平台网站中模板消息库中选择模板，选择后获得模板ID，再根据模板ID向用户主动推送提醒、通知消息。
   * </p>
   * <p>
   * 模板消息调用时主要需要模板ID和模板中各参数的赋值内容。请注意：
   * <ol>
   * <li>模板中参数内容必须以".DATA"结尾，否则视为保留字;</li>
   * <li>模板保留符号"{{ }}"</li>
   * </ol>
   * </p>
   * 具体调用方法
   * <p>
   * 第一步：获取模板ID<br />
   * 通过在模板消息功能的模板库中使用需要的模板，可以获得模板ID。
   * </p>
   * <p>
   * 第二步：请求接口
   * </p>
   * 
   * 文档地址：https://mp.weixin.qq.com/advanced/tmplmsg?action=faq&lang=zh_CN
   * 
   * @param accessToken access_token是公众号的全局唯一票据
   * @param message 消息
   */
  public Result<Boolean> sendTemplateMessage(String accessToken, Message message) {
    try {
      String json =
          post("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="
              + accessToken, new StringEntity(message.toJSON(), "UTF-8"));
      return new Result<Boolean>(Error.parse(new JSONObject(json)));
    } catch (UnsupportedEncodingException e) {
      throw new SocialException(e);
    }
  }

  /**
   * 在公众平台网站的高级功能 –
   * 开发模式页，点击“成为开发者”按钮，填写URL和Token，其中URL是开发者用来接收微信服务器数据的接口URL。Token可由开发者可以任意填写，用作生成签名（
   * 该Token会和接口URL中包含的Token进行比对，从而验证安全性）
   */
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
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

  public Group getGroup() {
    if (group == null) {
      group = new Group(this);
    }

    return group;
  }

  public Media getMedia() {
    if (media == null) {
      media = new Media(this);
    }

    return media;
  }

  public Menu getMenu() {
    if (menu == null) {
      menu = new Menu(this);
    }

    return menu;
  }

}
