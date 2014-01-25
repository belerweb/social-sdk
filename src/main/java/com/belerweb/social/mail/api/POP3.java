package com.belerweb.social.mail.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.net.SocketException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.net.pop3.POP3Client;
import org.apache.commons.net.pop3.POP3MessageInfo;
import org.apache.commons.net.pop3.POP3SClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.belerweb.social.exception.SocialException;

/**
 * POP3 邮件工具
 */
public class POP3 {

  private static final Logger LOGGER = LoggerFactory.getLogger(POP3.class);

  private String username;
  private String password;
  private String host;
  private int port;

  private POP3Client client;

  public POP3(String username, String password, String host) {
    this(username, password, host, org.apache.commons.net.pop3.POP3.DEFAULT_PORT, false);
  }

  public POP3(String username, String password, String host, int port, boolean ssl) {
    this.username = username;
    this.password = password;
    this.host = host;
    this.port = port;
    if (ssl) {
      this.client = new POP3SClient("SSL", true);
    } else {
      this.client = new POP3Client();
    }
    this.client.setDefaultTimeout(300000);
  }

  private boolean login() throws SocketException, IOException {
    client.connect(host, port);
    return client.login(username, password);
  }

  /**
   * 检查用户信息是否正确
   */
  public boolean test() throws SocialException {
    try {
      return login();
    } catch (SocketException e) {
      e.printStackTrace();
      throw new SocialException(e);
    } catch (IOException e) {
      e.printStackTrace();
      throw new SocialException(e);
    } finally {
      try {
        this.client.disconnect();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * 下载所有电子邮件到指定目录
   */
  public void download(File dir) throws SocialException {
    if (!dir.isDirectory() || !dir.canWrite()) {
      throw new SocialException("The specified directory is unavailable.");
    }

    try {
      if (login()) {
        POP3MessageInfo[] messages = client.listUniqueIdentifiers();
        if (messages == null) {
          LOGGER.debug("Could not retrieve message list.");
          throw new SocialException("Could not retrieve message list.");

        } else {
          for (POP3MessageInfo message : messages) {
            File eml = new File(dir, username + "@" + host + "/" + message.identifier + ".eml");
            try {
              Reader reader = client.retrieveMessage(message.number);
              if (reader == null) {
                LOGGER.debug("Could not retrieve message.");
                continue;
              }
              if (eml.exists()
                  && ((message.size > 0 && eml.length() == message.size) || eml.length() > 1000)) {
                LOGGER.debug("Message {} exist, skip download.", message.identifier);
                continue;
              }
              eml.getParentFile().mkdirs();
              LOGGER.debug("Downloading {} ...", message.identifier);
              IOUtils.copy(reader, new FileOutputStream(eml));;
              LOGGER.debug("Downloaded {} ...", message.identifier);
            } catch (Exception e) {
              try {
                FileUtils.forceDelete(eml);
              } catch (Exception exception) {
                e.printStackTrace();
              }
            }
          }
        }
      }
    } catch (SocketException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        client.disconnect();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

  /**
   * 下载所有电子邮件到指定目录
   */
  public void download(String dir) {
    download(new File(dir));
  }

}
