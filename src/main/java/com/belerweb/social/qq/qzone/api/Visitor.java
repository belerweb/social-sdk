package com.belerweb.social.qq.qzone.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.belerweb.social.captcha.api.Yundama;
import com.belerweb.social.captcha.bean.YundamaType;
import com.belerweb.social.exception.SocialException;
import com.belerweb.social.http.Http;
import com.belerweb.social.http.HttpException;
import com.belerweb.social.qq.mail.bean.ValidationCode;

public class Visitor {

  private String qq;
  private String password;
  private Yundama yundama;
  private HttpClient http;

  private String loginUi;
  private String loginSig;
  private String skey;

  private boolean session;

  public Visitor(String qq, String password, Yundama yundama) {
    this.qq = qq;
    this.password = password;
    this.yundama = yundama;
    this.http = Http.newClient();
  }

  private void openLogin() throws ClientProtocolException, IOException, HttpException {
    String uri = "http://user.qzone.qq.com/" + qq + "/friendvisitor";
    HttpResponse response = http.execute(new HttpGet(uri));
    if (!Http.isRequestSuccess(response)) {
      throw new SocialException("Step 1, open login ui failed.");
    }

    Document doc = Jsoup.parse(Http.responseToString(response));
    loginUi = doc.select("#login_frame").get(0).attr("src");
    HttpGet request = new HttpGet(loginUi);
    request.addHeader(new BasicHeader("Referer", uri));
    response = http.execute(request);
    if (!Http.isRequestSuccess(response)) {
      throw new SocialException("Step 2, open login ui failed.");
    }

    doc = Jsoup.parse(Http.responseToString(response));
    Matcher matcher =
        Pattern.compile("login_sig\\s*:\\s*[\"']([^\"']+)[\"']").matcher(
            doc.select("script").get(0).html());
    if (!matcher.find()) {
      throw new SocialException("Step 3, login page isn't contain login_sig.");
    }
    loginSig = matcher.group(1);
  }

  private ValidationCode loginCheck() throws ClientProtocolException, IOException, HttpException {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("regmaster", ""));
    params.add(new BasicNameValuePair("uin", qq));
    params.add(new BasicNameValuePair("appid", "549000912"));
    params.add(new BasicNameValuePair("js_ver", "10064"));
    params.add(new BasicNameValuePair("js_type", "1"));
    params.add(new BasicNameValuePair("login_sig", loginSig));
    params
        .add(new BasicNameValuePair("u1", "http://qzs.qq.com/qzone/v5/loginsucc.html?para=reload"));
    params.add(new BasicNameValuePair("r", String.valueOf(Math.random())));
    HttpGet request =
        new HttpGet("http://check.ptlogin2.qq.com/check?" + StringUtils.join(params, "&"));
    request.addHeader(new BasicHeader("Referer", loginUi));
    request.addHeader(new BasicHeader("Accept-Language", "zh-cn,zh"));
    HttpResponse response = http.execute(request);
    if (!Http.isRequestSuccess(response)) {
      throw new SocialException("Step 4, check if validation code failed.");
    }
    return new ValidationCode(Http.responseToString(response));
  }

  private byte[] getValidationCode() throws ClientProtocolException, IOException, HttpException {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("uin", qq));
    params.add(new BasicNameValuePair("aid", "549000912"));
    params.add(new BasicNameValuePair(String.valueOf(Math.random()), ""));
    HttpGet request =
        new HttpGet("http://captcha.qq.com/getimage?" + StringUtils.join(params, "&"));
    request.addHeader(new BasicHeader("Referer", loginUi));
    request.addHeader(new BasicHeader("Accept-Language", "zh-cn,zh"));
    HttpResponse response = http.execute(request);
    if (!Http.isRequestSuccess(response)) {
      throw new SocialException("Step 5, get validation code image failed.");
    }
    return IOUtils.toByteArray(response.getEntity().getContent());
  }

  private void login() throws ClientProtocolException, IOException, DecoderException, HttpException {
    openLogin();
    ValidationCode validationCode = loginCheck();
    String code = validationCode.getCode();
    if (validationCode.need()) {
      code = yundama.decode(getValidationCode(), YundamaType.ALPHANUMERIC).getResult();
    }

    String p = DigestUtils.md5Hex(password).toUpperCase();
    byte[] byte1 = Hex.decodeHex(p.toCharArray());
    byte[] byte2 = Hex.decodeHex(validationCode.getUid().toCharArray());
    byte[] bytes = new byte[byte1.length + byte2.length];
    System.arraycopy(byte1, 0, bytes, 0, byte1.length);
    System.arraycopy(byte2, 0, bytes, byte1.length, byte2.length);
    p = DigestUtils.md5Hex(bytes).toUpperCase();
    p = DigestUtils.md5Hex(p + code.toUpperCase()).toUpperCase();

    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("u", qq));
    params.add(new BasicNameValuePair("p", p));
    params.add(new BasicNameValuePair("verifycode", code));
    params.add(new BasicNameValuePair("aid", "549000912"));
    params.add(new BasicNameValuePair("u1",
        "http%3A%2F%2Fqzs.qq.com%2Fqzone%2Fv5%2Floginsucc.html%3Fpara%3Dreload"));
    params.add(new BasicNameValuePair("h", "1"));
    params.add(new BasicNameValuePair("ptredirect", "0"));
    params.add(new BasicNameValuePair("ptlang", "2052"));
    params.add(new BasicNameValuePair("from_ui", "1"));
    params.add(new BasicNameValuePair("dump", ""));
    params.add(new BasicNameValuePair("low_login_enable", "0"));
    params.add(new BasicNameValuePair("regmaster", ""));
    params.add(new BasicNameValuePair("fp", "loginerroralert"));
    params.add(new BasicNameValuePair("action", "2-22-1389885147889"));
    params.add(new BasicNameValuePair("mibao_css", ""));
    params.add(new BasicNameValuePair("t", "1"));
    params.add(new BasicNameValuePair("g", "1"));
    params.add(new BasicNameValuePair("js_ver", "10064"));
    params.add(new BasicNameValuePair("js_type", "1"));
    params.add(new BasicNameValuePair("login_sig", loginSig));
    params.add(new BasicNameValuePair("pt_rsa", "0"));
    HttpGet request = new HttpGet("http://ptlogin2.qq.com/login?" + StringUtils.join(params, "&"));
    request.addHeader(new BasicHeader("Referer", loginUi));
    request.addHeader(new BasicHeader("Accept-Language", "zh-cn,zh"));
    HttpResponse response = http.execute(request);
    if (!Http.isRequestSuccess(response)) {
      throw new SocialException("Step 6, login failed.");
    }

    String html = Http.responseToString(response);
    if (!html.contains("登录成功")) {
      throw new SocialException("Step 7, login failed.");
    }

    for (Header header : response.getHeaders("Set-Cookie")) {
      Matcher matcher = Pattern.compile("skey=([^;]+);").matcher(header.getValue());
      if (matcher.find()) {
        skey = matcher.group(1);
        session = true;
      }
    }
    if (!session) {
      throw new SocialException("Step 8, get skey failed.");
    }
  }

  public JSONObject getSimple() throws SocialException {
    try {
      if (!session) {
        login();
      }
      long gtk = 5381;
      for (int i = 0, len = skey.length(); i < len; ++i) {
        gtk += (gtk << 5) + skey.charAt(i);
      }
      gtk = gtk & 2147483647;

      List<NameValuePair> params = new ArrayList<NameValuePair>();
      params.add(new BasicNameValuePair("uin", qq));
      params.add(new BasicNameValuePair("mask", "2"));
      params.add(new BasicNameValuePair("clear", "1"));
      params.add(new BasicNameValuePair("mod", "8"));
      params.add(new BasicNameValuePair("fupdate", "1"));
      params.add(new BasicNameValuePair("random", String.valueOf(Math.random())));
      params.add(new BasicNameValuePair("g_tk", String.valueOf(gtk)));
      HttpGet request =
          new HttpGet("http://g.qzone.qq.com/cgi-bin/friendshow/cgi_get_visitor_simple?"
              + StringUtils.join(params, "&"));
      request.addHeader(new BasicHeader("Referer",
          "http://ctc.qzs.qq.com/qzone/v8/pages/visitors/refuse.html"));
      request.addHeader(new BasicHeader("Accept-Language", "zh-cn,zh"));
      HttpResponse response = http.execute(request);
      if (!Http.isRequestSuccess(response)) {
        throw new SocialException("Step 9, get visitor simple failed.");
      }
      String html = Http.responseToString(response);
      JSONObject json =
          new JSONObject(html.substring(html.indexOf("{"), html.lastIndexOf("}") + 1));
      if (json.getInt("code") != 0) {
        session = false;
        http = Http.newClient();
        loginUi = null;
        loginSig = null;
        skey = null;
        return getSimple();
      }

      return json;
    } catch (ClientProtocolException e) {
      throw new SocialException(e);
    } catch (IOException e) {
      throw new SocialException(e);
    } catch (HttpException e) {
      throw new SocialException(e);
    } catch (DecoderException e) {
      throw new SocialException(e);
    }
  }

}
