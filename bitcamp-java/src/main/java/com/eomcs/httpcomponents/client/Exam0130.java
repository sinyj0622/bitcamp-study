package com.eomcs.httpcomponents.client;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

// Apache httpcomponents 사용법 : httpClient5 - GET 요청하기 III
public class Exam0130 {
  public static void main(String[] args) throws Exception {
    try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
      HttpGet httpGet = new HttpGet("https://www.daum.net");
      try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
        System.out.println(response.getCode() + " " + response.getReasonPhrase());
        HttpEntity entity1 = response.getEntity();
        System.out.println(EntityUtils.toString(entity1));
        EntityUtils.consume(entity1);
      }

    }

  }
}
