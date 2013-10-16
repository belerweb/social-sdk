package com.belerweb.social.weibo.bean;

/**
 * 微博的可见性及指定可见分组信息
 */
public class Visible {

  /**
   * 0：普通微博，1：私密微博，3：指定分组微博，4：密友微博
   */
  private Integer type;

  /**
   * 分组的组号
   */
  private Integer listId;

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Integer getListId() {
    return listId;
  }

  public void setListId(Integer listId) {
    this.listId = listId;
  }

}
