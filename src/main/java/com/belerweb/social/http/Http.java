package com.belerweb.social.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;

public final class Http {

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


  public static final HttpClient CLIENT = newClient();

  private static final ThreadLocal<Charset> defaultCharset = new ThreadLocal<Charset>();

  private static Charset getDefaultCharset() {
    return defaultCharset.get();
  }

  /**
   * Sets the default charset for reading the response, which is used while the server side does not
   * provided the encoding or charset. If {@code null} is set, the {@link Charset#defaultCharset()}
   * will be used to read the response. Note, this is a {@link ThreadLocal} variable.
   * 
   * @param charset the charset.
   * @see #responseToString(HttpResponse)
   */
  public static void setDefaultCharset(Charset charset) {
    defaultCharset.set(charset);
  }

  public static String get(String uri, List<NameValuePair> params) throws HttpException {
    String url = uri;
    if (params != null) {
      String param = StringUtils.join(params, "&");
      if (url.contains("?")) {
        url = url + "&" + param;
      } else {
        url = url + "?" + param;
      }
    }

    return get(url);
  }

  public static String get(String uri, Header... headers) throws HttpException {
    HttpGet request = new HttpGet(uri);
    if (headers != null) {
      for (Header header : headers) {
        request.addHeader(header);
      }
    }
    return execute(request);
  }

  public static String post(String uri, HttpEntity postBody, Header... headers)
      throws HttpException {
    HttpPost request = new HttpPost(uri);
    if (postBody != null) {
      request.setEntity(postBody);
    }

    if (headers != null) {
      for (Header header : headers) {
        request.addHeader(header);
      }
    }
    return execute(request);
  }

  public static String post(String uri, List<NameValuePair> params, String charset,
      Header... headers) throws HttpException {
    HttpPost request = new HttpPost(uri);
    if (params != null) {
      List<NameValuePair> parameters = new ArrayList<NameValuePair>();
      parameters.addAll(params);
      try {
        HttpEntity entity = new UrlEncodedFormEntity(parameters, charset);
        request.setEntity(entity);
      } catch (UnsupportedEncodingException e) {
        throw new HttpException(e);
      }
    }

    if (headers != null) {
      for (Header header : headers) {
        request.addHeader(header);
      }
    }
    return execute(request);
  }

  public static String post(String uri) throws HttpException {
    return post(uri, (HttpEntity) null);
  }

  private static String execute(HttpRequestBase request) throws HttpException {
    try {
      HttpResponse response = CLIENT.execute(request);
      // StatusLine status = response.getStatusLine();
      return responseToString(response);
      // if (status.getStatusCode() != HttpStatus.SC_OK) {
      // throw new HttpException(status.getStatusCode() + ":" + status.getReasonPhrase() + "\r\n"
      // + result);
      // }
    } catch (ClientProtocolException e) {
      throw new HttpException(e);
    } catch (IOException e) {
      throw new HttpException(e);
    } finally {
      request.releaseConnection();
    }
  }

  public static boolean isRequestSuccess(HttpResponse response) throws HttpException {
    return response.getStatusLine() != null
        && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK;
  }

  public static String responseToString(HttpResponse response) throws HttpException {
    HttpEntity entity = response.getEntity();
    String result = null;
    if (entity != null) {
      Charset charset = null;
      Header encoding = entity.getContentEncoding();
      if (encoding == null) {
        ContentType contentType = ContentType.get(entity);
        if (contentType != null) {
          charset = contentType.getCharset();
        }
      } else {
        charset = Charset.forName(encoding.getValue());
      }
      if (charset == null) {
        charset = getDefaultCharset();
      }
      try {
        result = IOUtils.toString(entity.getContent(), charset);
      } catch (Exception e) {
        throw new HttpException(e);
      }
      return result;
    } else {
      throw new HttpException("No response entity.");
    }
  }

  public static String randomAgent() {
    return AGENTS[RandomUtils.nextInt(AGENTS.length)];
  }

  public static HttpClient newClient() {
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
    return HttpClientBuilder
        .create()
        .setSslcontext(sslContext)
        .setMaxConnPerRoute(50)
        .setMaxConnTotal(200)
        .setUserAgent(Http.randomAgent())
        .setDefaultRequestConfig(
            RequestConfig.custom().setConnectTimeout(30000).setSocketTimeout(30000)
                .setConnectionRequestTimeout(30000).build()).build();
  }

}
