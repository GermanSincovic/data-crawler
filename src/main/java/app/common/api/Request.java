package app.common.api;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Log
public class Request {

  private final HttpClient httpClient;
  private final List<Header> headerList;

  private String URL;
  private StringEntity body;

  public Request() {
    httpClient = HttpClients.createDefault();
    headerList = new ArrayList<>();
  }

  public Request to(String URL) {
    this.URL = URL;
    log.info(this.URL);
    return this;
  }

  public Request setHeader(Header header) {
    this.headerList.add(header);
    return this;
  }

  public Request setHeader(String key, String value) {
    Header header = new BasicHeader(key, value);
    this.headerList.add(header);
    log.info(header.toString());
    return this;
  }

  public Request setBody(String row) {
    this.body = new StringEntity(row, StandardCharsets.UTF_8);
    log.info(row);
    return this;
  }

  public Response get() {
    HttpGet request = new HttpGet(this.URL);
    return execute(request);
  }

  public Response post() {
    HttpPost request = new HttpPost(this.URL);
    if (nonNull(body)) {
      request.setEntity(body);
    }
    return execute(request);
  }

  public Response put() {
    HttpPut request = new HttpPut(this.URL);
    if (nonNull(body)) {
      request.setEntity(body);
    }
    return execute(request);
  }

  public Response delete() {
    HttpDelete request = new HttpDelete(this.URL);
    return execute(request);
  }

  private Response execute(HttpRequestBase request) {
    log.info(request.getMethod());
    if (!headerList.isEmpty()) {
      request.setHeaders(headerList.toArray(new Header[0]));
    }
    Response response = null;
    try {
      response = new Response(httpClient.execute(request));
    } catch (IOException e) {
      log.warning(e.getMessage());
    }
    return response;
  }
}
