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
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;

public final class Http {

  public static final HttpClient CLIENT;

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
        result = IOUtils.toString(entity.getContent(), charset);
        return result;
      } else {
        throw new HttpException("No response entity.");
      }
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

  static {
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
    CLIENT =
        HttpClientBuilder.create().setSslcontext(sslContext).setMaxConnPerRoute(50)
            .setMaxConnTotal(200).build();
  }

}
