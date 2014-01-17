package com.belerweb.social.qq.mail.bean;

import java.util.List;

public class User {

  private String id;
  private String level;
  private String type;
  private String name;
  private String nickName;
  private String familyName;
  private String givenName;
  private String relate;
  private String url;
  private String date;
  private String birthday;
  private String im;
  private String custom;
  private String note;
  private Address address;
  private Org org;
  private List<Email> emails;
  private List<Tel> tels;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public String getRelate() {
    return relate;
  }

  public void setRelate(String relate) {
    this.relate = relate;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getIm() {
    return im;
  }

  public void setIm(String im) {
    this.im = im;
  }

  public String getCustom() {
    return custom;
  }

  public void setCustom(String custom) {
    this.custom = custom;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Org getOrg() {
    return org;
  }

  public void setOrg(Org org) {
    this.org = org;
  }

  public List<Email> getEmails() {
    return emails;
  }

  public void setEmails(List<Email> emails) {
    this.emails = emails;
  }

  public List<Tel> getTels() {
    return tels;
  }

  public void setTels(List<Tel> tels) {
    this.tels = tels;
  }

}
