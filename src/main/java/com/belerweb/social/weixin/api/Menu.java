package com.belerweb.social.weixin.api;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import com.belerweb.social.API;
import com.belerweb.social.bean.Error;
import com.belerweb.social.bean.Result;
import com.belerweb.social.exception.SocialException;
import com.belerweb.social.weixin.bean.MenuType;

/**
 * 自定义菜单接口
 * 
 * 文档地址：http://mp.weixin.qq.com/wiki/index.php?title=自定义菜单创建接口
 */
public class Menu extends API {

  protected Menu(Weixin weixin) {
    super(weixin);
  }

  /**
   * 自定义菜单创建接口
   * 
   * @param menus 菜单
   */
  public Result<Error> create(List<com.belerweb.social.weixin.bean.Menu> menus) {
    return create(weixin.getAccessToken().getToken(), menus);
  }

  /**
   * 自定义菜单创建接口
   * 
   * @param accessToken 调用接口凭证
   * @param menus 菜单
   */
  public Result<Error> create(String accessToken, List<com.belerweb.social.weixin.bean.Menu> menus) {
    JSONArray menuArray = new JSONArray();
    for (com.belerweb.social.weixin.bean.Menu menu : menus) {
      JSONObject obj = new JSONObject();
      MenuType type = menu.getType();
      obj.put("name", menu.getName());
      if (type != null) {
        obj.put("type", type.value());
        if (type == MenuType.CLICK) {
          obj.put("key", menu.getKey());
        }
        if (type == MenuType.VIEW) {
          obj.put("view", menu.getUrl());
        }
      }
      List<com.belerweb.social.weixin.bean.Menu> subs = menu.getSubs();
      if (subs != null) {
        JSONArray _menuArray = new JSONArray();
        for (com.belerweb.social.weixin.bean.Menu _menu : subs) {
          JSONObject _obj = new JSONObject();
          MenuType _type = _menu.getType();
          _obj.put("name", _menu.getName());
          if (_type != null) {
            _obj.put("type", _type.value());
            if (_type == MenuType.CLICK) {
              _obj.put("key", _menu.getKey());
            }
            if (_type == MenuType.VIEW) {
              _obj.put("url", _menu.getUrl());
            }
          }
          _menuArray.put(_obj);
        }
        obj.put("sub_button", _menuArray);
      }
      menuArray.put(obj);
    }
    JSONObject request = new JSONObject();
    request.put("button", menuArray);
    try {
      String json =
          weixin.post("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken,
              new StringEntity(request.toString(), "UTF-8"));
      return Result.parse(json, Error.class);
    } catch (UnsupportedEncodingException e) {
      throw new SocialException(e);
    }
  }

  /**
   * 自定义菜单查询接口
   */
  public Result<List<com.belerweb.social.weixin.bean.Menu>> get() {
    return get(weixin.getAccessToken().getToken());
  }

  /**
   * 自定义菜单查询接口
   * 
   * @param accessToken 调用接口凭证
   */
  public Result<List<com.belerweb.social.weixin.bean.Menu>> get(String accessToken) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    weixin.addParameter(params, "access_token", accessToken);
    String json = weixin.get("https://api.weixin.qq.com/cgi-bin/menu/get", params);
    JSONObject jsonObject = new JSONObject(json);
    Error error = Error.parse(jsonObject);
    if (error != null) {
      return new Result<List<com.belerweb.social.weixin.bean.Menu>>(error);
    }
    List<com.belerweb.social.weixin.bean.Menu> menus =
        new ArrayList<com.belerweb.social.weixin.bean.Menu>();
    JSONObject menu = jsonObject.optJSONObject("menu");
    if (menu != null) {
      menus = Result.parse(menu.optJSONArray("button"), com.belerweb.social.weixin.bean.Menu.class);
    }
    return new Result<List<com.belerweb.social.weixin.bean.Menu>>(menus);
  }

  /**
   * 自定义菜单删除接口
   */
  public Result<Error> delete() {
    return delete(weixin.getAccessToken().getToken());
  }

  /**
   * 自定义菜单删除接口
   * 
   * @param accessToken 调用接口凭证
   */
  public Result<Error> delete(String accessToken) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    weixin.addParameter(params, "access_token", accessToken);
    String json = weixin.get("https://api.weixin.qq.com/cgi-bin/menu/delete", params);
    return Result.parse(json, Error.class);
  }

}
