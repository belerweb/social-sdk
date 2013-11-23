package com.belerweb.social.qq.connect.bean;

import org.json.JSONObject;

import com.belerweb.social.bean.JsonBean;
import com.belerweb.social.bean.Result;

public class Company extends JsonBean {

  public Company() {}

  private Company(JSONObject jsonObject) {
    super(jsonObject);
  }

  private String id;// 公司id。
  private String companyName;// 公司名称。
  private String departmentName;// 部门名称。
  private Integer beginYear;// 开始年。
  private Integer endYear;// 结束年。

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public Integer getBeginYear() {
    return beginYear;
  }

  public void setBeginYear(Integer beginYear) {
    this.beginYear = beginYear;
  }

  public Integer getEndYear() {
    return endYear;
  }

  public void setEndYear(Integer endYear) {
    this.endYear = endYear;
  }

  public static Company parse(JSONObject jsonObject) {
    if (jsonObject == null) {
      return null;
    }
    Company obj = new Company(jsonObject);
    obj.id = Result.toString(jsonObject.get("id"));
    obj.companyName = Result.toString(jsonObject.opt("company_name"));
    obj.departmentName = Result.toString(jsonObject.opt("department_name"));
    obj.beginYear = Result.parseInteger(jsonObject.opt("begin_year"));
    obj.endYear = Result.parseInteger(jsonObject.opt("end_year"));
    return obj;
  }
}
