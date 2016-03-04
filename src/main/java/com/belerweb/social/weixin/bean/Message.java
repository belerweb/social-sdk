package com.belerweb.social.weixin.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

/**
 * 普通消息
 */
public class Message extends JsonBean {

  public Message() {}

  public Message(MsgType msgType) {
    this.msgType = msgType;
  }

  private Message(JSONObject jsonObject) {
    super(jsonObject);
  }

  private Long msgId;// 消息id
  private String fromUser;// 发送方帐号（一个OpenID）
  private String toUser;// 开发者微信号
  private Date createTime;// 消息创建时间
  private MsgType msgType;// 消息类型
  private String content;// 文本消息内容
  private String mediaId;// 消息媒体id，可以调用多媒体文件下载接口拉取数据。
  private String picUrl;// 图片链接
  private VoiceType voiceType;// 语音格式
  private String recognition;// 语音识别结果
  private String thumbMediaId;// 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
  private Double lon;// 地理位置经度
  private Double lat;// 地理位置纬度
  private Integer scale;// 地图缩放大小
  private String label;// 地理位置信息
  private String title;// 消息标题
  private String description;// 消息描述
  private String url;// 消息链接
  private String musicUrl;// 音乐链接
  private String hqMusicUrl;// 高质量音乐链接，WIFI环境优先使用该链接播放音乐
  private EventType eventType;// 事件类型
  private String eventKey;// 事件KEY值
  private String ticket;// 二维码的ticket，可用来换取二维码图片
  private Double precision;// 地理位置精度
  private List<Article> articles;// 多条图文消息信息，默认第一个item为大图

  /**
   * 模板消息特有的属性
   */
  private String templateId;// 模板消息的id
  private String topColor;// 模板消息头部的颜色 eg:#FF0000
  private List<Variable> variables;// 模板消息的变量


  /**
   * 消息id
   */
  public Long getMsgId() {
    return msgId;
  }

  public void setMsgId(Long msgId) {
    this.msgId = msgId;
  }

  /**
   * 发送方帐号
   */
  public String getFromUser() {
    return fromUser;
  }

  public void setFromUser(String fromUser) {
    this.fromUser = fromUser;
  }

  /**
   * 接受方帐号
   */
  public String getToUser() {
    return toUser;
  }

  public void setToUser(String toUser) {
    this.toUser = toUser;
  }

  /**
   * 消息创建时间
   */
  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  /**
   * 消息类型
   */
  public MsgType getMsgType() {
    return msgType;
  }

  public void setMsgType(MsgType msgType) {
    this.msgType = msgType;
  }

  /**
   * 文本消息内容
   */
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  /**
   * 图片／语音／视频特有：消息媒体id，可以调用多媒体文件下载接口拉取数据。
   */
  public String getMediaId() {
    return mediaId;
  }

  public void setMediaId(String mediaId) {
    this.mediaId = mediaId;
  }

  /**
   * 图片消息特有：图片链接
   */
  public String getPicUrl() {
    return picUrl;
  }

  public void setPicUrl(String picUrl) {
    this.picUrl = picUrl;
  }

  /**
   * 语音消息特有：语音格式
   */
  public VoiceType getVoiceType() {
    return voiceType;
  }

  public void setVoiceType(VoiceType voiceType) {
    this.voiceType = voiceType;
  }


  /**
   * 语音消息特有： 语音识别结果，UTF8编码，只有在开启语音识别后才有此结果
   */
  public String getRecognition() {
    return recognition;
  }

  public void setRecognition(String recognition) {
    this.recognition = recognition;
  }

  /**
   * 视频消息/音乐消息特有：视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
   */
  public String getThumbMediaId() {
    return thumbMediaId;
  }

  public void setThumbMediaId(String thumbMediaId) {
    this.thumbMediaId = thumbMediaId;
  }

  /**
   * 位置消息特有：地理位置经度
   */
  public Double getLon() {
    return lon;
  }

  public void setLon(Double lon) {
    this.lon = lon;
  }

  /**
   * 位置消息特有：地理位置纬度
   */
  public Double getLat() {
    return lat;
  }

  public void setLat(Double lat) {
    this.lat = lat;
  }

  /**
   * 位置消息特有： 地图缩放大小
   */
  public Integer getScale() {
    return scale;
  }

  public void setScale(Integer scale) {
    this.scale = scale;
  }

  /**
   * 位置消息特有： 地理位置信息
   */
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  /**
   * 链接消息/音乐消息特有：消息标题
   */
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * 链接消息/音乐消息特有：消息描述
   */
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * 链接消息特有：消息链接
   */
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * 音乐链接
   */
  public String getMusicUrl() {
    return musicUrl;
  }

  public void setMusicUrl(String musicUrl) {
    this.musicUrl = musicUrl;
  }

  /**
   * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
   */
  public String getHqMusicUrl() {
    return hqMusicUrl;
  }

  public void setHqMusicUrl(String hqMusicUrl) {
    this.hqMusicUrl = hqMusicUrl;
  }

  /**
   * 事件特有：事件类型
   */
  public EventType getEventType() {
    return eventType;
  }

  public void setEventType(EventType eventType) {
    this.eventType = eventType;
  }

  /**
   * 事件KEY值，QR扫描／自定义菜单时特有
   */
  public String getEventKey() {
    return eventKey;
  }

  public void setEventKey(String eventKey) {
    this.eventKey = eventKey;
  }

  /**
   * 扫描二维码，用户已关注时的事件推送特有
   * <p/>
   * 二维码的ticket，可用来换取二维码图片
   */
  public String getTicket() {
    return ticket;
  }

  public void setTicket(String ticket) {
    this.ticket = ticket;
  }

  /**
   * 上报地理位置事件特有： 地理位置精度
   */
  public Double getPrecision() {
    return precision;
  }

  public void setPrecision(Double precision) {
    this.precision = precision;
  }

  /**
   * 多条图文消息信息，默认第一个item为大图
   */
  public List<Article> getArticles() {
    return articles;
  }

  public void setArticles(List<Article> articles) {
    this.articles = articles;
  }

  /**
   * 模板消息id
   */
  public String getTemplateId() {
    return templateId;
  }

  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }

  /**
   * 模板消息头部颜色
   */
  public String getTopColor() {
    return topColor;
  }

  public void setTopColor(String topColor) {
    this.topColor = topColor;
  }

  /**
   * 模板消息变量
   * 
   * @return
   */
  public List<Variable> getVariables() {
    if (variables == null) {
      variables = new ArrayList<Variable>();
    }
    return variables;
  }

  public void setVariables(List<Variable> variables) {
    this.variables = variables;
  }

  public Message addVariable(Variable variable) {
    getVariables().add(variable);
    return this;
  }

  /**
   * 将Message转换成XML格式，用于发送被动响应消息
   */
  public String toXML() {
    JSONObject obj = new JSONObject();
    obj.put("MsgType", msgType.toString());
    obj.put("ToUserName", toUser);
    obj.put("FromUserName", fromUser);
    obj.put("CreateTime", (Long) (createTime.getTime() / 1000));
    if (msgType == MsgType.TEXT) {
      obj.put("Content", content);
    }
    if (msgType == MsgType.IMAGE) {
      JSONObject image = new JSONObject();
      image.put("MediaId", mediaId);
      obj.put("Image", image);
    }
    if (msgType == MsgType.VOICE) {
      JSONObject voice = new JSONObject();
      voice.put("MediaId", mediaId);
      obj.put("Voice", voice);
    }
    if (msgType == MsgType.VIDEO) {
      JSONObject video = new JSONObject();
      video.put("MediaId", mediaId);
      video.put("ThumbMediaId", thumbMediaId);
      obj.put("Video", video);
    }
    if (msgType == MsgType.MUSIC) {
      JSONObject music = new JSONObject();
      music.put("Title", title);
      music.put("Description", description);
      music.put("MusicURL", musicUrl);
      music.put("HQMusicUrl", hqMusicUrl);
      music.put("ThumbMediaId", thumbMediaId);
      obj.put("Music", music);
    }
    if (msgType == MsgType.NEWS) {
      obj.put("ArticleCount", articles.size());
      JSONArray array = new JSONArray();
      for (Article article : articles) {
        JSONObject itemWrapper = new JSONObject();
        JSONObject item = new JSONObject();
        item.put("Title", article.getTitle());
        item.put("Description", article.getDescription());
        item.put("PicUrl", article.getPicUrl());
        item.put("Url", article.getUrl());
        itemWrapper.put("item", item);
        array.put(itemWrapper);
      }
      obj.put("Articles", array);
    }
    return XML.toString(obj, "xml").replaceAll("</Articles><Articles>", "");
  }

  /**
   * 将Message转换成JSON格式，用于发送客服消息
   */
  public String toJSON() {
    JSONObject obj = new JSONObject();
    obj.put("msgtype", msgType.toString());
    obj.put("touser", toUser);
    if (msgType == MsgType.TEXT) {
      JSONObject text = new JSONObject();
      text.put("content", content);
      obj.put("text", text);
    }
    if (msgType == MsgType.IMAGE) {
      JSONObject image = new JSONObject();
      image.put("media_id", mediaId);
      obj.put("image", image);
    }
    if (msgType == MsgType.VOICE) {
      JSONObject voice = new JSONObject();
      voice.put("media_id", mediaId);
      obj.put("voice", voice);
    }
    if (msgType == MsgType.VIDEO) {
      JSONObject video = new JSONObject();
      video.put("media_id", mediaId);
      video.put("thumb_media_id", thumbMediaId);
      obj.put("video", video);
    }
    if (msgType == MsgType.MUSIC) {
      JSONObject music = new JSONObject();
      music.put("title", title);
      music.put("description", description);
      music.put("musicurl", musicUrl);
      music.put("hqmusicurl", hqMusicUrl);
      music.put("thumb_media_id", thumbMediaId);
      obj.put("music", music);
    }
    if (msgType == MsgType.NEWS) {
      JSONObject news = new JSONObject();
      JSONArray array = new JSONArray();
      for (Article article : articles) {
        JSONObject item = new JSONObject();
        item.put("title", article.getTitle());
        item.put("description", article.getDescription());
        item.put("picurl", article.getPicUrl());
        item.put("url", article.getUrl());
        array.put(item);
      }
      news.put("articles", array);
      obj.put("news", news);
    }
    if (msgType == MsgType.TEMPLATE) {
      obj.put("template_id", templateId);
      if (StringUtils.isNotBlank(topColor)) {
        obj.put("topcolor", topColor);
      }
      if (StringUtils.isNotBlank(url)) {
        obj.put("url", url);
      }
      JSONObject data = new JSONObject();
      for (Variable var : variables) {
        JSONObject varJson = new JSONObject();
        varJson.put("value", var.getValue());
        if (StringUtils.isNotBlank(var.getColor())) {
          varJson.put("color", var.getColor());
        }
        data.put(var.getName(), varJson);
      }
      obj.put("data", data);
    }
    return obj.toString();
  }

  public static Message parse(String xml) {
    return parse(XML.toJSONObject(xml).getJSONObject("xml"));
  }

  public static Message parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    Message obj = new Message(jsonObject);
    obj.msgId = Result.parseLong(jsonObject.opt("MsgId"));
    MsgType type = MsgType.parse(jsonObject.get("MsgType"));
    obj.msgType = type;
    obj.createTime = new Date(Result.parseLong(jsonObject.get("CreateTime")) * 1000);
    obj.fromUser = Result.toString(jsonObject.get("FromUserName"));
    obj.toUser = Result.toString(jsonObject.get("ToUserName"));
    if (type == MsgType.TEXT) {
      obj.content = Result.toString(jsonObject.opt("Content"));
    }
    if (type == MsgType.IMAGE) {
      obj.mediaId = Result.toString(jsonObject.opt("MediaId"));
      obj.picUrl = Result.toString(jsonObject.opt("PicUrl"));
    }
    if (type == MsgType.VOICE) {
      obj.mediaId = Result.toString(jsonObject.opt("MediaId"));
      obj.voiceType = VoiceType.parse(jsonObject.opt("Format"));
      obj.recognition = Result.toString(jsonObject.opt("Recognition"));
    }
    if (type == MsgType.VIDEO) {
      obj.mediaId = Result.toString(jsonObject.opt("MediaId"));
      obj.thumbMediaId = Result.toString(jsonObject.opt("ThumbMediaId"));
    }
    if (type == MsgType.LOCATION) {
      obj.lon = Result.parseDouble(jsonObject.opt("Location_Y"));
      obj.lat = Result.parseDouble(jsonObject.opt("Location_X"));
      obj.scale = Result.parseInteger(jsonObject.opt("Scale"));
      obj.label = Result.toString(jsonObject.opt("Label"));
    }
    if (type == MsgType.LINK) {
      obj.title = Result.toString(jsonObject.opt("Title"));
      obj.description = Result.toString(jsonObject.opt("Description"));
      obj.url = Result.toString(jsonObject.opt("Url"));
    }
    if (type == MsgType.EVENT) {
      EventType eventType = EventType.parse(jsonObject.get("Event"));
      obj.eventType = eventType;
      if (eventType == EventType.SUBSCRIBE) {
        // Do nothing when direct follow
        // When scan QR to follow
        obj.eventKey = Result.toString(jsonObject.opt("EventKey"));
        obj.ticket = Result.toString(jsonObject.opt("Ticket"));
      }
      if (eventType == EventType.UNSUBSCRIBE) {
        // Do nothing
      }
      if (eventType == EventType.SCAN) {
        obj.eventKey = Result.toString(jsonObject.opt("EventKey"));
        obj.ticket = Result.toString(jsonObject.opt("Ticket"));
      }
      if (eventType == EventType.LOCATION) {
        obj.lon = Result.parseDouble(jsonObject.opt("Longitude"));
        obj.lat = Result.parseDouble(jsonObject.opt("Latitude"));
      }
      if (eventType == EventType.CLICK) {
        obj.eventKey = Result.toString(jsonObject.opt("EventKey"));
      }
      if (eventType == EventType.VIEW) {
        obj.eventKey = Result.toString(jsonObject.opt("EventKey"));
        obj.url = obj.eventKey;
      }
    }
    return obj;
  }

}
