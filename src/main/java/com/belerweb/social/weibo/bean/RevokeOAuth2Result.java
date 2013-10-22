package com.belerweb.social.weibo.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.Error;
import com.belerweb.social.bean.Result;

public class RevokeOAuth2Result extends Result<Boolean> {

  private RevokeOAuth2Result(Error error) {
    super(error);
  }

  private RevokeOAuth2Result(Boolean result) {
    super(result);
  }

  public static RevokeOAuth2Result parse(String json) {
    JSONObject jsonObject = new JSONObject(json);
    Error error = Error.parse(jsonObject);
    if (error == null) {
      return new RevokeOAuth2Result(Result.parseBoolean(jsonObject.get("result")));
    }

    return new RevokeOAuth2Result(error);
  }

}
