package com.belerweb.social.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

public final class Http {

  private static final HttpClient CLIENT;

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

  public static String get(String uri) throws HttpException {
    return execute(new HttpGet(uri));
  }

  public static String post(String uri, List<NameValuePair> params) throws HttpException {
    HttpPost request = new HttpPost(uri);
    if (params != null) {
      List<NameValuePair> parameters = new ArrayList<NameValuePair>();
      parameters.addAll(parameters);
      try {
        HttpEntity entity = new UrlEncodedFormEntity(parameters);
        request.setEntity(entity);
      } catch (UnsupportedEncodingException e) {
        throw new HttpException(e);
      }
    }

    return execute(request);
  }

  public static String post(String uri) throws HttpException {
    return post(uri, null);
  }

  private static String execute(HttpUriRequest request) throws HttpException {
    try {
      HttpResponse response = CLIENT.execute(request);
      StatusLine status = response.getStatusLine();
      HttpEntity entity = response.getEntity();
      String result = null;
      if (entity != null) {
        result = IOUtils.toString(entity.getContent());
      }
      if (status.getStatusCode() != HttpStatus.SC_OK) {
        throw new HttpException(status.getStatusCode() + ":" + status.getReasonPhrase() + "\r\n"
            + result);
      }
      return result;
    } catch (ClientProtocolException e) {
      throw new HttpException(e);
    } catch (IOException e) {
      throw new HttpException(e);
    }
  }

  static {
    CLIENT = HttpClientBuilder.create().build();
  }

}
