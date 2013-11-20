package com.belerweb.social.qq.connect.bean;

import java.util.Date;

/**
 * 财付通收货地址
 */
public class TenpayAddress {

  private Integer index;// 收货信息的索引编号
  private Integer regionId;// 收货信息的地区编号
  private String street;// 收货信息的收货地址
  private String zipcode;// 收货信息的邮编
  private String mobile;// 收货信息的收货人移动电话
  private String tel;// 收货信息的收货人固定电话
  private String name;// 收货信息的收货人姓名
  private Date created;// 收货信息的创建时间
  private Date modified;// 收货信息上一次被修改的时间
  private Date lastUsed;// 收货信息上一次被使用的时间
  private Integer usedCount;// 收货信息被使用过的次数
  private Integer total;// 该用户财付通收货地址的个数

  public Integer getIndex() {
    return index;
  }

  public void setIndex(Integer index) {
    this.index = index;
  }

  public Integer getRegionId() {
    return regionId;
  }

  public void setRegionId(Integer regionId) {
    this.regionId = regionId;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getModified() {
    return modified;
  }

  public void setModified(Date modified) {
    this.modified = modified;
  }

  public Date getLastUsed() {
    return lastUsed;
  }

  public void setLastUsed(Date lastUsed) {
    this.lastUsed = lastUsed;
  }

  public Integer getUsedCount() {
    return usedCount;
  }

  public void setUsedCount(Integer usedCount) {
    this.usedCount = usedCount;
  }

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

}
