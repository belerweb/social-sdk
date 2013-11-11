package com.belerweb.social.weixin.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;

import com.belerweb.social.API;
import com.belerweb.social.bean.Result;
import com.belerweb.social.weixin.bean.GetFollowersResult;

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

  /**
   * 获取所欲关注者列表，包含用户详细信息，该接口采用循环多次获取用户详细信息的方式。如果关注者太多可能会很慢。还会超过微信API调用次数限制。请谨慎调用。建议只在第一次同步关注着信息时调用。
   */
  public Result<List<com.belerweb.social.weixin.bean.User>> getFollowUsers() {
    return getFollowUsers(weixin.getAccessToken().getToken());
  }

  /**
   * 获取所欲关注者列表，包含用户详细信息，该接口采用循环多次获取用户详细信息的方式。如果关注者太多可能会很慢。还会超过微信API调用次数限制。请谨慎调用。建议只在第一次同步关注着信息时调用。
   * 
   * @param accessToken 调用接口凭证
   */
  public Result<List<com.belerweb.social.weixin.bean.User>> getFollowUsers(String accessToken) {
    List<com.belerweb.social.weixin.bean.User> users =
        new ArrayList<com.belerweb.social.weixin.bean.User>();
    Result<GetFollowersResult> followersResult = getFollowers(accessToken);
    if (followersResult.success()) {
      for (String openId : followersResult.getResult().getOpenIds()) {
        Result<com.belerweb.social.weixin.bean.User> userResult = userInfo(accessToken, openId);
        if (userResult.success()) {
          users.add(userResult.getResult());
        } else {
          return new Result<List<com.belerweb.social.weixin.bean.User>>(userResult.getError());
        }
      }

      return new Result<List<com.belerweb.social.weixin.bean.User>>(users);
    }
    return new Result<List<com.belerweb.social.weixin.bean.User>>(followersResult.getError());
  }

  /**
   * 获取所欲关注者列表
   */
  public Result<GetFollowersResult> getFollowers() {
    return getFollowers(weixin.getAccessToken().getToken());
  }

  /**
   * 获取所欲关注者列表
   * 
   * @param accessToken 调用接口凭证
   */
  public Result<GetFollowersResult> getFollowers(String accessToken) {
    GetFollowersResult result = new GetFollowersResult();
    List<String> openIds = new ArrayList<String>();
    Result<GetFollowersResult> followers = getFollowers(accessToken, null);
    while (followers.success()) {
      for (String openId : followers.getResult().getOpenIds()) {
        openIds.add(openId);
      }
      String nextOpenid = followers.getResult().getNextOpenid();
      if (StringUtils.isBlank(nextOpenid)) {
        break;
      }
      followers = getFollowers(accessToken, nextOpenid);
    }
    if (!followers.success()) {
      return new Result<GetFollowersResult>(followers.getError());
    }
    result.setTotal(openIds.size());
    result.setCount(openIds.size());
    result.setOpenIds(openIds);
    return new Result<GetFollowersResult>(result);
  }

  /**
   * 获取关注者列表
   * 
   * 公众号可通过本接口来获取帐号的关注者列表，关注者列表由一串OpenID（加密后的微信号，每个用户对每个公众号的OpenID是唯一的）组成。一次拉取调用最多拉取10000个关注者的OpenID
   * ，可以通过多次拉取的方式来满足需求。
   * 
   * 文档地址：http://mp.weixin.qq.com/wiki/index.php?title=获取关注者列表
   * 
   * @param accessToken 调用接口凭证
   * @param openId 第一个拉取的OPENID，不填默认从头开始拉取
   */
  public Result<GetFollowersResult> getFollowers(String accessToken, String openId) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    weixin.addParameter(params, "access_token", accessToken);
    weixin.addNotNullParameter(params, "openid", openId);
    String json = weixin.get("https://api.weixin.qq.com/cgi-bin/user/get", params);
    return Result.parse(json, GetFollowersResult.class);
  }

}
