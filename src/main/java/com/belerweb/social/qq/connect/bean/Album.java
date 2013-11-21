package com.belerweb.social.qq.connect.bean;

import java.util.Date;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

public class Album extends JsonBean {

  public Album() {}

  private Album(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String albumId;
  private String classId;
  private Date createTime;
  private String name;
  private String description;
  private String cover;
  private Integer picNum;

  public String getAlbumId() {
    return albumId;
  }

  public void setAlbumId(String albumId) {
    this.albumId = albumId;
  }

  public String getClassId() {
    return classId;
  }

  public void setClassId(String classId) {
    this.classId = classId;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCover() {
    return cover;
  }

  public void setCover(String cover) {
    this.cover = cover;
  }

  public Integer getPicNum() {
    return picNum;
  }

  public void setPicNum(Integer picNum) {
    this.picNum = picNum;
  }

  public static Album parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    Album obj = new Album(jsonObject);
    obj.albumId = Result.toString(jsonObject.get("albumid"));
    obj.classId = Result.toString(jsonObject.opt("classid"));
    obj.createTime = Result.parseTimeSeconds(jsonObject.opt("createtime"));
    obj.name = Result.toString(jsonObject.opt("name"));
    obj.description = Result.toString(jsonObject.opt("desc"));
    obj.cover = Result.toString(jsonObject.opt("coverurl"));
    obj.picNum = Result.parseInteger(jsonObject.opt("picnum"));
    return obj;
  }

}
