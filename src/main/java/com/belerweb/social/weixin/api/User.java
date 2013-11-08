package com.belerweb.social.weixin.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import com.belerweb.social.API;
import com.belerweb.social.bean.Result;

/**
 * 网页授权获取用户基本信息
 * 
 * 如果用户在微信中（Web微信除外）访问公众号的第三方网页，公众号开发者可以通过此接口获取当前用户基本信息（包括昵称、性别、城市、国家）。利用用户信息，可以实现体验优化、用户来源统计、帐号绑定、
 * 用户身份鉴权等功能
 * 。请注意，“获取用户基本信息接口是在用户和公众号产生消息交互时，才能根据用户OpenID获取用户基本信息，而网页授权的方式获取用户基本信息，则无需消息交互，只是用户进入到公众号的网页
 * ，就可弹出请求用户授权的界面，用户授权后，就可获得其基本信息（此过程甚至不需要用户已经关注公众号。）”
 * 
 * 本接口是通过OAuth2.0来完成网页授权的，是安全可靠的，关于OAuth2.0的详细介绍，可以参考OAuth2.0协议标准。在微信公众号请求用户网页授权之前，
 * 开发者需要先到公众平台网站中配置授权回调域名。
 */
public class User extends API {

  protected User(Weixin weixin) {
    super(weixin);
  }

  /**
   * 拉取用户信息(需scope为 snsapi_userinfo)。适用于网页授权的用户。
   * 
   * 如果网页授权作用域为snsapi_userinfo，则此时开发者可以通过access_token和openid拉取用户信息了。
   * 
   * @param accessToken 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
   * @param openId 用户的唯一标识
   */
  public Result<com.belerweb.social.weixin.bean.User> snsapiUserInfo(String accessToken,
      String openId) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    weixin.addParameter(params, "access_token", accessToken);
    weixin.addParameter(params, "openid", openId);
    String json = weixin.get("https://api.weixin.qq.com/sns/userinfo", params);
    return Result.parse(json, com.belerweb.social.weixin.bean.User.class);
  }

  /**
   * 获取用户基本信息，适用于已关注公众帐号的用户。
   * 
   * 在关注者与公众号产生消息交互后，公众号可获得关注者的OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的。对于不同公众号，同一用户的openid不同）。
   * 公众号可通过本接口来根据OpenID获取用户基本信息，包括昵称、头像、性别、所在城市、语言和关注时间。
   * 
   * @param accessToken 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
   * @param openId 用户的唯一标识
   */
  public Result<com.belerweb.social.weixin.bean.User> userInfo(String accessToken, String openId) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    weixin.addParameter(params, "access_token", accessToken);
    weixin.addParameter(params, "openid", openId);
    String json = weixin.get("https://api.weixin.qq.com/cgi-bin/user/info", params);
    return Result.parse(json, com.belerweb.social.weixin.bean.User.class);
  }

}
