package com.belerweb.social.mail.api;

import org.junit.Test;

import com.belerweb.social.mail.api.POP3;

public class POP3Test {

  @Test
  public void testDownload() {
    String username = System.getProperty("pop3.username");
    String password = System.getProperty("pop3.password");
    String host = System.getProperty("pop3.host");
    POP3 pop3 = new POP3(username, password, host, 995, true);
    pop3.download(System.getProperty("java.io.tmpdir"));
  }

}
