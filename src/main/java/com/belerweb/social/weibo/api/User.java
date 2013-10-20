package com.belerweb.social.weibo.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;

import com.belerweb.social.bean.Result;
import com.belerweb.social.exception.SocialException;
import com.belerweb.social.weibo.bean.UserCounts;

/**
 * 读取用户信息接口
 */
public final class User extends API {

  protected User(Weibo weibo) {
    super(weibo);
  }

  /**
   * 获取用户信息/根据用户ID获取用户信息
   * 
   * 访问级别：普通接口
   * 
   * 频次限制：是
   * 
   * 文档地址：https://api.weibo.com/2/users/show.json
   * 
   * @param source 采用OAuth授权方式不需要此参数，其他授权方式为必填参数，数值为应用的AppKey。
   * @param accessToken 采用OAuth授权方式为必填参数，其他授权方式不需要此参数，OAuth授权后获得。
   * @param uid 需要查询的用户ID。
   * @param screename 需要查询的用户昵称。
   * 
   *        参数uid与screen_name二者必选其一，且只能选其一
   */
  public Result<com.belerweb.social.weibo.bean.User> show(String source, String accessToken,
      String uid, String screenName) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    weibo.addNotNullParameter(params, "source", source);
    weibo.addNotNullParameter(params, "access_token", accessToken);
    weibo.addNotNullParameter(params, "uid", uid);
    weibo.addNotNullParameter(params, "screen_name", screenName);
    String json = weibo.post("https://api.weibo.com/2/users/show.json", params);
    return Result.parse(json, com.belerweb.social.weibo.bean.User.class);
  }

  /**
   * 通过个性域名获取用户信息/通过个性化域名获取用户资料以及用户最新的一条微博
   * 
   * 访问级别：普通接口
   * 
   * 频次限制：是
   * 
   * 文档地址：https://api.weibo.com/2/users/domain_show.json
   * 
   * @param source 采用OAuth授权方式不需要此参数，其他授权方式为必填参数，数值为应用的AppKey。
   * @param accessToken 采用OAuth授权方式为必填参数，其他授权方式不需要此参数，OAuth授权后获得。
   * @param domain 需要查询的个性化域名。
   */
  public Result<com.belerweb.social.weibo.bean.User> domainShow(String source, String accessToken,
      String domain) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    weibo.addNotNullParameter(params, "source", source);
    weibo.addNotNullParameter(params, "access_token", accessToken);
    weibo.addParameter(params, "domain", domain);
    String json = weibo.post("https://api.weibo.com/2/users/domain_show.json", params);
    return Result.parse(json, com.belerweb.social.weibo.bean.User.class);
  }

  /**
   * 批量获取用户的粉丝数、关注数、微博数
   * 
   * 访问级别：普通接口
   * 
   * 频次限制：是
   * 
   * 文档地址：https://api.weibo.com/2/users/counts.json
   * 
   * @param source 采用OAuth授权方式不需要此参数，其他授权方式为必填参数，数值为应用的AppKey。
   * @param accessToken 采用OAuth授权方式为必填参数，其他授权方式不需要此参数，OAuth授权后获得。
   * @param uids 需要获取数据的用户UID，最多不超过100个。
   */
  public Result<UserCounts> counts(String source, String accessToken, List<String> uids) {
    if (uids == null || uids.size() > 100) {
      throw new SocialException("需要获取数据的用户UID，必须且最多不超过100个");
    }

    List<NameValuePair> params = new ArrayList<NameValuePair>();
    weibo.addNotNullParameter(params, "source", source);
    weibo.addNotNullParameter(params, "access_token", accessToken);
    weibo.addParameter(params, "uids", StringUtils.join(uids, ","));
    String result = weibo.post("https://api.weibo.com/2/users/domain_show.json", params);
    return Result.parse(result, UserCounts.class);
  }

}
