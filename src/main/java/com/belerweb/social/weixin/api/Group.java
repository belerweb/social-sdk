package com.belerweb.social.weixin.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONObject;

import com.belerweb.social.API;
import com.belerweb.social.bean.Error;
import com.belerweb.social.bean.Result;

/**
 * 分组管理接口
 */
public class Group extends API {

  protected Group(Weixin weixin) {
    super(weixin);
  }

  /**
   * 查询分组
   */
  public Result<List<com.belerweb.social.weixin.bean.Group>> get() {
    return get(weixin.getAccessToken().getToken());
  }

  /**
   * 查询分组
   * 
   * 文档地址：http://mp.weixin.qq.com/wiki/index.php?title=分组管理结果
   * 
   * @param accessToken 调用接口凭证
   */
  public Result<List<com.belerweb.social.weixin.bean.Group>> get(String accessToken) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    weixin.addParameter(params, "access_token", accessToken);
    String json = weixin.get("https://api.weixin.qq.com/cgi-bin/groups/get", params);
    JSONObject jsonObject = new JSONObject(json);
    Error error = Error.parse(jsonObject);
    if (error == null) {
      List<com.belerweb.social.weixin.bean.Group> groups =
          Result.parse(jsonObject.getJSONArray("groups"),
              com.belerweb.social.weixin.bean.Group.class);
      return new Result<List<com.belerweb.social.weixin.bean.Group>>(groups);
    }
    return new Result<List<com.belerweb.social.weixin.bean.Group>>(error);
  }

}
