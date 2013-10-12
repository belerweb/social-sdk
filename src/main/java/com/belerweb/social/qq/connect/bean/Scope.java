package com.belerweb.social.qq.connect.bean;

/**
 * 请求用户授权时向用户显示的可进行授权的列表。
 */
public enum Scope {

  /**
   * do_like
   */
  DO_LIKE("do_like"),

  /**
   * 获取登录用户的昵称、头像、性别
   */
  GET_USER_INFO("get_user_info"),

  /**
   * 获取登录用户的昵称、头像、性别
   */
  GET_SIMPLE_USERINFO("get_simple_userinfo"),

  /**
   * 获取QQ会员的基本信息
   */
  GET_VIP_INFO("get_vip_info"),

  /**
   * 获取QQ会员的高级信息
   */
  GET_VIP_RICH_INFO("get_vip_rich_info"),

  /**
   * 发表日志到QQ空间
   */
  ADD_ONE_BLOG("add_one_blog"),

  /**
   * 获取用户QQ空间相册列表
   */
  LIST_ALBUM("list_album"),

  /**
   * 上传一张照片到QQ空间相册
   */
  UPLOAD_PIC("upload_pic"),

  /**
   * 在用户的空间相册里，创建一个新的个人相册
   */
  ADD_ALBUM("add_album"),

  /**
   * 获取用户QQ空间相册中的照片列表
   */
  LIST_PHOTO("list_photo"),

  /**
   * 获取登录用户在腾讯微博详细资料
   */
  GET_INFO("get_info"),

  /**
   * 发表一条微博
   */
  ADD_T("add_t"),

  /**
   * 删除一条微博
   */
  DEL_T("del_t"),

  /**
   * 发表一条带图片的微博
   */
  ADD_PIC_T("add_pic_t"),

  /**
   * 获取单条微博的转发或点评列表
   */
  GET_REPOST_LIST("get_repost_list"),

  /**
   * 获取他人微博资料
   */
  GET_OTHER_INFO("get_other_info"),

  /**
   * 我的微博粉丝列表
   */
  GET_FANSLIST("get_fanslist"),

  /**
   * 我的微博偶像列表
   */
  GET_IDOLLIST("get_idollist"),

  /**
   * 收听某个微博用户
   */
  ADD_IDOL("add_idol"),

  /**
   * 取消收听某个微博用户
   */
  DEL_IDOL("del_idol"),

  /**
   * 在这个网站上将展现您财付通登记的收货地址
   */
  GET_TENPAY_ADDR("get_tenpay_addr");

  private String scope;

  private Scope(String scope) {
    this.scope = scope;
  }

  public String value() {
    return scope;
  }

  @Override
  public String toString() {
    return scope;
  }

  public static final Scope[] ALL = new Scope[] {Scope.DO_LIKE, Scope.GET_USER_INFO,
      Scope.GET_SIMPLE_USERINFO, Scope.GET_VIP_INFO, Scope.GET_VIP_RICH_INFO, Scope.ADD_ONE_BLOG,
      Scope.LIST_ALBUM, Scope.UPLOAD_PIC, Scope.ADD_ALBUM, Scope.LIST_PHOTO, Scope.GET_INFO,
      Scope.ADD_T, Scope.DEL_T, Scope.ADD_PIC_T, Scope.GET_REPOST_LIST, Scope.GET_OTHER_INFO,
      Scope.GET_FANSLIST, Scope.GET_IDOLLIST, Scope.ADD_IDOL, Scope.DEL_IDOL,
      Scope.GET_TENPAY_ADDR,};
}
