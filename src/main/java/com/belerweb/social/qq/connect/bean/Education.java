package com.belerweb.social.qq.connect.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

public class Education extends JsonBean {

  public Education() {}

  private Education(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String id;// 教育信息记录ID。
  private Integer year;// 入学年。
  private String schoolId;// 学校ID。学校ID与学校具体信息的对应关系请参见教育信息数据库。
  private String departmentId;// 院系ID。院系ID与院系具体信息的对应关系请参见教育信息数据库。
  private Integer level;// 学历级别。

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getSchoolId() {
    return schoolId;
  }

  public void setSchoolId(String schoolId) {
    this.schoolId = schoolId;
  }

  public String getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(String departmentId) {
    this.departmentId = departmentId;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public static Education parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    Education obj = new Education(jsonObject);
    obj.id = Result.toString(jsonObject.get("id"));
    obj.schoolId = Result.toString(jsonObject.opt("company_name"));
    obj.departmentId = Result.toString(jsonObject.opt("department_name"));
    obj.year = Result.parseInteger(jsonObject.opt("begin_year"));
    obj.level = Result.parseInteger(jsonObject.opt("end_year"));
    return obj;
  }
}
