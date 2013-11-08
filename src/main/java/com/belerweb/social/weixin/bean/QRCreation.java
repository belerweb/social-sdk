package com.belerweb.social.weixin.bean;

import org.json.JSONObject;

public class QRCreation {

  private QRType type;// 二维码类型，QR_SCENE为临时,QR_LIMIT_SCENE为永久
  private Integer expireSeconds = 1800;// 该二维码有效时间，以秒为单位。 最大不超过1800。
  private Integer sceneId;// 场景值ID，临时二维码时为32位整型，永久二维码时最大值为1000

  public QRType getType() {
    return type;
  }

  public void setType(QRType type) {
    this.type = type;
  }

  public Integer getExpireSeconds() {
    return expireSeconds;
  }

  public void setExpireSeconds(Integer expireSeconds) {
    this.expireSeconds = expireSeconds;
  }

  public Integer getSceneId() {
    return sceneId;
  }

  public void setSceneId(Integer sceneId) {
    this.sceneId = sceneId;
  }

  @Override
  public String toString() {
    JSONObject obj = new JSONObject();
    if (type == QRType.QR_SCENE) {
      obj.put("expire_seconds", expireSeconds);
    }

    obj.put("action_name", type.value());
    JSONObject actionInfo = new JSONObject();
    JSONObject scene = new JSONObject();
    scene.put("scene_id", sceneId);
    actionInfo.put("scene", scene);
    obj.put("action_info", actionInfo);
    return obj.toString();
  }

}
