package com.belerweb.social.qq.mail.api;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.SSLContext;
import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.belerweb.social.exception.SocialException;
import com.belerweb.social.qq.mail.bean.Group;
import com.belerweb.social.qq.mail.bean.User;
import com.belerweb.social.qq.mail.bean.ValidationCode;

/**
 * 获取QQ邮箱联系人
 */
public class Contact {
  private static final String[] AGENTS =
      new String[] {
          "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36",
          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1664.3 Safari/537.36",
          "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.66 Safari/535.11",
          "Mozilla/5.0 (X11; Linux i686) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.66 Safari/535.11",
          "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.66 Safari/535.11",
          "Mozilla/5.0 (Windows NT 6.2) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.66 Safari/535.11",
          "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.66 Safari/535.11",
          "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.66 Safari/535.11",
          "Mozilla/5.0 (Windows NT 6.0; WOW64) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.66 Safari/535.11",
          "Mozilla/5.0 (Windows NT 6.0) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.66 Safari/535.11",
          "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.66 Safari/535.11",
          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_3) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.66 Safari/535.11",
          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_2) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.66 Safari/535.11",
          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_8) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.66 Safari/535.11",
          "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_5_8) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.66 Safari/535.11",
          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; WOW64; Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1) ; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.0.04506; Media Center PC 5.0; .NET CLR 3.5.21022; GreenBrowser)",
          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Trident/4.0; SLCC1; .NET CLR 2.0.50727; Media Center PC 5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; GreenBrowser)",
          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Trident/4.0; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.5.30729; InfoPath.2; .NET CLR 3.0.30729; GreenBrowser)",
          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Trident/4.0; SLCC1; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; OfficeLiveConnector.1.4; OfficeLivePatch.1.3; GreenBrowser)",
          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; GTB6; .NET CLR 2.0.50727; GreenBrowser)",
          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; GTB6; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; .NET CLR 1.1.4322; GreenBrowser)",
          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; GTB6.3; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; .NET CLR 1.1.4322; GreenBrowser)",
          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; GTB0.0; InfoPath.1; GreenBrowser)",
          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; .NET CLR 4.0.20506; GreenBrowser)",
          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; .NET CLR 1.1.4322; InfoPath.2; GreenBrowser)",
          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; .NET CLR 1.0.3705; .NET CLR 1.1.4322; GreenBrowser)",
          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727; .NET CLR 1.1.4322; .NET CLR 3.0.04506.30; GreenBrowser)",
          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; .NET CLR 1.1.4322; InfoPath.2; .NET CLR 2.0.50727; .NET CLR 3.0.04506.648; .NET CLR 3.5.21022; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; GreenBrowser)",
          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1) ; .NET CLR 1.0.3705; .NET CLR 1.1.4322; Media Center PC 4.0; .NET CLR 2.0.50727; InfoPath.1; GreenBrowser)",
          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 2.0.50727; GreenBrowser)",
          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; GreenBrowser)",
          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; .NET CLR 1.1.4322; GreenBrowser)",
          "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.04506.648; .NET CLR 3.5.21022; .NET CLR 1.1.4322; GreenBrowser)",
          "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.62 Safari/537.36"};

  private HttpClient http;

  private String email;
  private String password;
  private String sid;

  /**
   * 创建一个QQ邮箱联系人API
   * 
   * @param email QQ邮箱地址
   * @param password QQ邮箱密码
   */
  public Contact(String email, String password) {
    SSLContext sslContext = SSLContexts.createDefault();
    try {
      sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
        public boolean isTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
          return true;
        }
      }).build();
    } catch (Exception e) {
      e.printStackTrace();
    }
    http =
        HttpClientBuilder.create().setSslcontext(sslContext).setMaxConnPerRoute(50)
            .setMaxConnTotal(200).setUserAgent(AGENTS[RandomUtils.nextInt(AGENTS.length)]).build();

    this.email = email;
    this.password = password;
  }

  private List<Group> get(Group group) throws SocialException {
    HttpGet request =
        new HttpGet("http://mail.qq.com/cgi-bin/laddr_list?sid=" + sid
            + "&operate=view&t=contact&view=" + group.getType()
            + (group.getId() != null ? ("&groupid=" + group.getId()) : "&loc=frame_html,,,23"));
    request.addHeader(new BasicHeader("Referer",
        "http://mail.qq.com/cgi-bin/laddr_list?operate=view&t=contact&view=normal&loc=frame_html,,,23&sid="
            + sid));
    request.addHeader(new BasicHeader("Accept-Language", "zh-cn,zh"));
    request
        .addHeader(new BasicHeader("Referer", "http://mail.qq.com/cgi-bin/frame_html?sid=" + sid));
    request.addHeader(new BasicHeader("Accept-Language", "zh-cn,zh"));
    try {
      HttpResponse response = http.execute(request);
      StatusLine statusLine = response.getStatusLine();
      if (statusLine == null || statusLine.getStatusCode() != HttpStatus.SC_OK
          || response.getEntity() == null) {
        throw new SocialException(String.valueOf(statusLine));
      }
      String result = IOUtils.toString(response.getEntity().getContent(), "GB18030");
      request.releaseConnection();
      List<Group> groups = null;
      Document doc = Jsoup.parse(result);
      Elements scripts = doc.select("script");
      for (Element el : scripts) {
        for (DataNode node : el.dataNodes()) {
          String script = node.getWholeData().trim();
          if (script.startsWith("var goListData")) {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
            List<User> users = new ArrayList<User>();
            Bindings bindings = engine.createBindings();
            bindings.put("users", users);
            script =
                script
                    + "(function(){for(var i in goListData.oList){var o=goListData.oList[i];var u=new com.belerweb.social.qq.mail.bean.User();u.setId(o.sId);u.setType(o.sItemType);u.setLevel(o.sLevel);u.setName(o.oName.length?o.oName[0].sVal:'');u.setFamilyName((o.oFamilyName&&o.oFamilyName.length)?o.oFamilyName[0].sVal:'');u.setGivenName((o.oGivenName&&o.oGivenName.length)?o.oGivenName[0].sVal:'');u.setCustom((o.oCustom&&o.oCustom.length)?o.oCustom[0].sVal:'');u.setNickName((o.oQQNickName&&o.oQQNickName.length)?o.oQQNickName[0].sVal:'');u.setRelate((o.oRelate&&o.oRelate.length)?o.oRelate[0].sVal:'');u.setUrl((o.oUrl&&o.oUrl.length)?o.oUrl[0].sVal:'');u.setDate((o.oDate&&o.oDate.length)?o.oDate[0].sVal:'');u.setBirthday((o.oBirthday&&o.oBirthday.length)?o.oBirthday[0].sVal:'');u.setIm((o.oIM&&o.oIM.length)?o.oIM[0].sVal:'');u.setNote((o.oNote&&o.oNote.length)?o.oNote[0].sVal:'');var es=new java.util.ArrayList();for(var j in o.oEmail){var obj=o.oEmail[j];var e=new com.belerweb.social.qq.mail.bean.Email();e.setEmail(obj.sVal);e.setLabel(obj.sLabel?obj.sLabel:'');e.setType(obj.sType?obj.sType:'');es.add(e)}u.setEmails(es);var ts=new java.util.ArrayList();for(var j in o.oTel){var obj=o.oTel[j];var t=new com.belerweb.social.qq.mail.bean.Tel();t.setNum(obj.sVal);t.setLabel(obj.sLabel?obj.sLabel:'');t.setType(obj.sType?obj.sType:'');ts.add(t)}u.setTels(ts);if(o.oOrg&&o.oOrg.length){var org=new com.belerweb.social.qq.mail.bean.Org();org.setOrg1(o.oOrg[0].sOrg1);org.setOrg2(o.oOrg[0].sOrg2);org.setTitle(o.oOrg[0].sTitle);u.setOrg(org)}if(o.oAdr&&o.oAdr.length){var adr=new com.belerweb.social.qq.mail.bean.Address();adr.setLabel(o.oAdr[0].sLabel);adr.setType(o.oAdr[0].sType);adr.setCountry(o.oAdr[0].sCountry);adr.setProvince(o.oAdr[0].sProvince);adr.setCity(o.oAdr[0].sCity);adr.setStreet(o.oAdr[0].sStreet);adr.setPostcode(o.oAdr[0].sPostcode);u.setAddress(adr)}users.add(u)}})();";
            if (group.getId() == null) {
              groups = new ArrayList<Group>();
              bindings.put("groups", groups);
              script =
                  script
                      + "(function(){for(var k in goGroupData){for(var i in goGroupData[k].oList){var obj=goGroupData[k].oList[i];var g=new com.belerweb.social.qq.mail.bean.Group();g.setId(obj.sId);g.setType(obj.sSubType);g.setName(obj.sName);groups.add(g);}}})();";
            }
            engine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
            engine.eval(script);
            group.setUsers(users);
          }
        }
      }
      return groups;
    } catch (ClientProtocolException e) {
      throw new SocialException(e);
    } catch (IOException e) {
      throw new SocialException(e);
    } catch (ScriptException e) {
      throw new SocialException(e);
    }
  }

  /**
   * 按分组获取所有QQ邮箱中的联系人，包括QQ联系人
   */
  public List<Group> get() throws SocialException {
    List<Group> result = new ArrayList<Group>();
    login();
    Group group = new Group();
    group.setType("normal");
    group.setName("全部");
    group.setOwner(email);
    List<Group> groups = get(group);
    result.add(group);
    for (Group group2 : groups) {
      get(group2);
      group2.setOwner(email);
      result.add(group2);
    }
    return result;
  }

  /**
   * QQ邮箱登录，如果登录成功则返回sid，登录失败抛出异常
   */
  public String login() throws SocialException {
    ValidationCode validationCode = check();
    if (validationCode.need()) {
      throw new SocialException("需要输入验证码才能登录");
    }

    try {
      String code = DigestUtils.md5Hex(password).toUpperCase();
      byte[] byte1 = Hex.decodeHex(code.toCharArray());
      byte[] byte2 = Hex.decodeHex(validationCode.getUid().toCharArray());
      byte[] bytes = new byte[byte1.length + byte2.length];
      System.arraycopy(byte1, 0, bytes, 0, byte1.length);
      System.arraycopy(byte2, 0, bytes, byte1.length, byte2.length);
      code = DigestUtils.md5Hex(bytes).toUpperCase();
      code = DigestUtils.md5Hex(code + validationCode.getCode().toUpperCase()).toUpperCase();

      List<NameValuePair> params = new ArrayList<NameValuePair>();
      params.add(new BasicNameValuePair("aid", "522005705"));
      params.add(new BasicNameValuePair("ptlang", "2052"));
      params.add(new BasicNameValuePair("js_type", "2"));
      params.add(new BasicNameValuePair("js_ver", "10009"));
      params.add(new BasicNameValuePair("fp", "loginerroralert"));
      params.add(new BasicNameValuePair("wording", "快速登录"));
      params.add(new BasicNameValuePair("mibao_css", "m_ptmail"));
      params.add(new BasicNameValuePair("u1", URLEncoder.encode(
          "https://mail.qq.com/cgi-bin/login?vt=passport&vm=wpt&ft=ptlogin&lang=cn&ss=&validcnt=&clientaddr="
              + email, "UTF-8")));
      params.add(new BasicNameValuePair("css",
          "https://mail.qq.com/zh_CN/htmledition/style/fast_login181b91.css"));
      params.add(new BasicNameValuePair("daid", "4"));
      params.add(new BasicNameValuePair("dummy", ""));
      params.add(new BasicNameValuePair("from_ui", "1"));
      params.add(new BasicNameValuePair("g", "1"));
      params.add(new BasicNameValuePair("h", "1"));
      params.add(new BasicNameValuePair("ptredirect", "1"));
      params.add(new BasicNameValuePair("t", "1"));
      params.add(new BasicNameValuePair("action", "4-20-" + RandomStringUtils.randomNumeric(5)));
      params.add(new BasicNameValuePair("p", code));
      params.add(new BasicNameValuePair("u", email));
      params.add(new BasicNameValuePair("u_domain", email.substring(email.indexOf("@"))));
      params.add(new BasicNameValuePair("uin", email.substring(0, email.indexOf("@"))));
      params.add(new BasicNameValuePair("verifycode", validationCode.getCode()));
      HttpGet request =
          new HttpGet("https://ssl.ptlogin2.qq.com/login?" + StringUtils.join(params, "&"));
      request
          .addHeader(new BasicHeader("Referer", "https://mail.qq.com/cgi-bin/loginpage?lang=cn"));
      request.addHeader(new BasicHeader("Accept-Language", "zh-cn,zh"));
      HttpResponse response = http.execute(request);
      StatusLine statusLine = response.getStatusLine();
      if (statusLine == null || statusLine.getStatusCode() != HttpStatus.SC_OK
          || response.getEntity() == null) {
        throw new SocialException(String.valueOf(statusLine));
      }
      String result = IOUtils.toString(response.getEntity().getContent());
      request.releaseConnection();
      System.out.println(result);
      String[] str = result.substring(7, result.length() - 1).split(",");
      if (!"0".equals(str[0].trim().substring(1, str[0].length() - 1))) {
        throw new SocialException(str[4]);
      }

      request = new HttpGet(str[2].trim().substring(1, str[2].length() - 1));
      response = http.execute(request);
      statusLine = response.getStatusLine();
      if (statusLine == null || statusLine.getStatusCode() != HttpStatus.SC_OK
          || response.getEntity() == null) {
        throw new SocialException(String.valueOf(statusLine));
      }
      result = IOUtils.toString(response.getEntity().getContent(), "GB18030");
      request.releaseConnection();
      System.out.println(result);
      Matcher matcher = Pattern.compile("sid=([0-9a-zA-Z-_]+)\"").matcher(result);
      if (!matcher.find()) {
        throw new SocialException("没有获取到sid");
      }
      this.sid = matcher.group(1);
      return this.sid;
    } catch (DecoderException e) {
      throw new SocialException(e);
    } catch (ClientProtocolException e) {
      throw new SocialException(e);
    } catch (IOException e) {
      throw new SocialException(e);
    }
  }

  /**
   * 检查QQ邮箱登录是否需要验证码
   */
  public ValidationCode check() throws SocialException {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("appid", "522005705"));
    params.add(new BasicNameValuePair("ptlang", "2052"));
    params.add(new BasicNameValuePair("js_type", "2"));
    params.add(new BasicNameValuePair("js_ver", "10009"));
    params.add(new BasicNameValuePair("r", String.valueOf(Math.random())));
    params.add(new BasicNameValuePair("uin", email));
    HttpGet request =
        new HttpGet("https://ssl.ptlogin2.qq.com/check?" + StringUtils.join(params, "&"));
    request.addHeader(new BasicHeader("Referer", "https://mail.qq.com/cgi-bin/loginpage?lang=cn"));
    request.addHeader(new BasicHeader("Accept-Language", "zh-cn,zh"));
    try {
      HttpResponse response = http.execute(request);
      StatusLine statusLine = response.getStatusLine();
      if (statusLine == null || statusLine.getStatusCode() != HttpStatus.SC_OK
          || response.getEntity() == null) {
        throw new SocialException(String.valueOf(statusLine));
      }
      String result = IOUtils.toString(response.getEntity().getContent());
      request.releaseConnection();
      System.out.println(result);
      return new ValidationCode(result);
    } catch (ClientProtocolException e) {
      throw new SocialException(e);
    } catch (IOException e) {
      throw new SocialException(e);
    }
  }
}
