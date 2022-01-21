package app.common.api;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Log4j
public class Request {

  private final HttpClient httpClient;
  private final List<Header> headerList;

  private String url;
  private GetParams getParams;
  private StringEntity body;

  public Request() {
    httpClient = HttpClients.createDefault();
    headerList = new ArrayList<>();
  }

  public Request to(String url) {
    this.url = url + getParams.build();
    return this;
  }

  public void setGetParams(GetParams getParams){
    this.getParams = getParams;
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
    HttpGet request = new HttpGet(this.url);
    return execute(request);
  }

  public Response post() {
    HttpPost request = new HttpPost(this.url);
    if (nonNull(body)) {
      request.setEntity(body);
    }
    return execute(request);
  }

  public Response put() {
    HttpPut request = new HttpPut(this.url);
    if (nonNull(body)) {
      request.setEntity(body);
    }
    return execute(request);
  }

  public Response delete() {
    HttpDelete request = new HttpDelete(this.url);
    return execute(request);
  }

  @SneakyThrows
  private Response execute(HttpRequestBase request) {
    log.info(request.getMethod() + " " + url);
    if (!headerList.isEmpty()) {
      request.setHeaders(headerList.toArray(new Header[0]));
    }
    Response response = null;
    try {
      response = new Response(httpClient.execute(request));
    } catch (IOException e) {
      log.warn(e.getMessage());
    }
    return response;
  }
}
