package com.belerweb.social.weibo.bean;

import org.json.JSONObject;

public class RevokeOAuth2Result extends Result<Boolean> {

  private RevokeOAuth2Result(Error error) {
    super(error);
  }

  private RevokeOAuth2Result(Boolean result) {
    super(result);
  }

  public static RevokeOAuth2Result perse(String json) {
    JSONObject jsonObject = new JSONObject(json);
    Error error = Error.parse(jsonObject);
    if (error == null) {
      return new RevokeOAuth2Result(Result.perseBoolean(jsonObject.get("result")));
    }

    return new RevokeOAuth2Result(error);
  }

}
