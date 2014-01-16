package com.belerweb.social.captcha.api;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.json.JSONObject;

import com.belerweb.social.bean.Error;
import com.belerweb.social.bean.Result;
import com.belerweb.social.captcha.bean.YundamaType;
import com.belerweb.social.exception.SocialException;
import com.belerweb.social.http.Http;
import com.belerweb.social.http.HttpException;

public class Yundama {

  private String appId = "85";
  private String appKey = "19fcd07d8de9c03b8cebec5d8bfe7d8e";
  private String username;
  private String password;

  public Yundama(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public Result<String> decode(byte[] img, YundamaType type) {
    HttpPost request = new HttpPost("http://api.yundama.com/api.php?method=upload");
    MultipartEntityBuilder builder =
        MultipartEntityBuilder.create()
            .addBinaryBody("file", img, ContentType.create("image/png"), "code.png")
            .addTextBody("username", username).addTextBody("password", password)
            .addTextBody("codetype", type.getType().toString()).addTextBody("appid", appId)
            .addTextBody("appkey", appKey).addTextBody("timeout", "60");
    request.setEntity(builder.build());
    try {
      HttpResponse response = Http.CLIENT.execute(request);
      String json = IOUtils.toString(response.getEntity().getContent());
      request.releaseConnection();
      JSONObject jsonObject = new JSONObject(json);
      Integer ret = Result.parseInteger(jsonObject.get("ret"));
      if (ret == 0) {
        String url =
            "http://api.yundama.com/api.php?method=result&cid="
                + Result.toString(jsonObject.get("cid"));
        long start = System.currentTimeMillis();
        while (true) {
          jsonObject = new JSONObject(Http.get(url));
          if (Result.parseInteger(jsonObject.get("ret")) == 0) {
            return new Result<String>(Result.toString(jsonObject.get("text")));
          }
          if (System.currentTimeMillis() - start > 10000) {
            return new Result<String>(new Error("TIMEOUT", "验证码识别超时。"));
          }
          try {
            Thread.sleep(300);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
      Error error = new Error();
      error.setErrorCode(ret.toString());
      return new Result<String>(error);
    } catch (ClientProtocolException e) {
      throw new SocialException(e);
    } catch (HttpException e) {
      throw new SocialException(e);
    } catch (IOException e) {
      throw new SocialException(e);
    }
  }
}
