package com.belerweb.social.weixin.bean;

/**
 * 模板消息中的变量
 * 
 * @date Aug 28, 2014
 */
public class Variable {

  private String name;// 变量名称
  private String value;// 变量值
  private String color;// 变量颜色值 eg:#FF0000

  public Variable() {}

  public Variable(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public Variable(String name, String value, String color) {
    this.name = name;
    this.value = value;
    this.color = color;
  }

  /**
   * 变量名称
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * 变量值
   */
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  /**
   * 变量颜色值 eg:#FF0000
   */
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

}
