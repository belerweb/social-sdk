package com.belerweb.social.weixin.api;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.belerweb.social.TestConfig;
import com.belerweb.social.bean.Result;
import com.belerweb.social.weixin.bean.Media;
import com.belerweb.social.weixin.bean.MediaType;

public class MediaTest extends TestConfig {
  final static Logger logger = LoggerFactory.getLogger(MediaTest.class);

  @Test
  public void testUpload() throws Exception {
    File file = new File(System.getProperty("weixin.file"));
    Media media = new Media();
    media.setName(file.getName());
    media.setContentType(MediaType.VOICE_AMR.contentType());
    media.setContent(FileUtils.readFileToByteArray(file));
    Result<com.belerweb.social.weixin.bean.Media> result =
        weixin.getMedia().upload(MediaType.VOICE_AMR, media);
    Assert.assertTrue(result.success());
    logger.info(result.getResult().getId());
  }

  @Test
  public void testGet() throws Exception {
    String mediaId = System.getProperty("weixin.mediaid");
    Result<Media> result = weixin.getMedia().get(mediaId);
    Assert.assertTrue(result.success());
    logger.info(result.getResult().getContentType());
    logger.info(result.getResult().getName());
  }

}
