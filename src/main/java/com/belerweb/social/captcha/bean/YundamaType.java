package com.belerweb.social.captcha.bean;


public enum YundamaType {
  /**
   * 不定长英文数字 2.5题分一个字符（按文本长度收费）
   */
  ALPHANUMERIC(1000),
  /**
   * 1位英文数字 7题分
   */
  ALPHANUMERIC1(1001),
  /**
   * 2位英文数字 8题分
   */
  ALPHANUMERIC2(1002),
  /**
   * 3位英文数字 9题分
   */
  ALPHANUMERIC3(1003),
  /**
   * 4位英文数字 10题分
   */
  ALPHANUMERIC4(1004),
  /**
   * 5位英文数字 12题分
   */
  ALPHANUMERIC5(1005),
  /**
   * 6位英文数字 15题分
   */
  ALPHANUMERIC6(1006),
  /**
   * 7位英文数字 17题分
   */
  ALPHANUMERIC7(1007),
  /**
   * 8位英文数字 20题分
   */
  ALPHANUMERIC8(1008),
  /**
   * 9位英文数字 22题分
   */
  ALPHANUMERIC9(1009),
  /**
   * 10位英文数字 25题分
   */
  ALPHANUMERIC10(1010),
  /**
   * 11位英文数字 27题分
   */
  ALPHANUMERIC11(1011),
  /**
   * 12位英文数字 30题分
   */
  ALPHANUMERIC12(1012),
  /**
   * 13位英文数字 32题分
   */
  ALPHANUMERIC13(1013),
  /**
   * 14位英文数字 35题分
   */
  ALPHANUMERIC14(1014),
  /**
   * 15位英文数字 37题分
   */
  ALPHANUMERIC15(1015),
  /**
   * 16位英文数字 40题分
   */
  ALPHANUMERIC16(1016),
  /**
   * 17位英文数字 42题分
   */
  ALPHANUMERIC17(1017),
  /**
   * 18位英文数字 45题分
   */
  ALPHANUMERIC18(1018),
  /**
   * 19位英文数字 47题分
   */
  ALPHANUMERIC19(1019),
  /**
   * 20位英文数字 50题分
   */
  ALPHANUMERIC20(1020),
  /**
   * 2位纯汉字 20题分
   */
  CHINESE2(2002),
  /**
   * 4位纯汉字 40题分
   */
  CHINESE4(2004),
  /**
   * 4位纯英文 10题分
   */
  ALPHABETIC4(3004),
  /**
   * 5位纯英文 12题分
   */
  ALPHABETIC5(3005),
  /**
   * 6位纯英文 15题分
   */
  ALPHABETIC6(3006),
  /**
   * 4位纯数字 10题分
   */
  NUMERIC4(4004),
  /**
   * 5位纯数字 12题分
   */
  NUMERIC5(4005);

  Integer type;

  YundamaType(Integer type) {
    this.type = type;
  }

  public Integer getType() {
    return type;
  }

}
