package app.common.api;

import app.utils.JsonUtil;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.log4j.Log4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

import static java.util.Objects.nonNull;

@Log4j
public class Response {

  private final HttpResponse httpResponse;

  @Getter private final int statusCode;

  @Getter private final HttpEntity body;

  public Response(@NonNull HttpResponse response) {
    this.httpResponse = response;
    this.statusCode = this.httpResponse.getStatusLine().getStatusCode();
    this.body = this.httpResponse.getEntity();
  }

  public <T> T read(Class<T> clazz) {
    String rawBody = null;
    if (nonNull(getBody())) {
      try {
        rawBody = EntityUtils.toString(getBody(), "UTF-8");
        log.info(rawBody);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    try {
      return JsonUtil.toObject(rawBody, clazz);
    } catch (Exception e) {
      log.info(rawBody);
    }
    return null;
  }
}
