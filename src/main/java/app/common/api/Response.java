package app.common.api;

import app.utils.JsonUtil;
import lombok.Getter;
import lombok.NonNull;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static java.util.Objects.nonNull;

public class Response {

  private final HttpResponse response;

  @Getter private final int statusCode;

  @Getter private final HttpEntity body;

  public Response(@NonNull HttpResponse response) {
    this.response = response;
    this.statusCode = this.response.getStatusLine().getStatusCode();
    this.body = this.response.getEntity();
  }

  public <T> T read(Class<T> clazz) {
    String rawBody = null;
    if (nonNull(getBody())) {
      try {
        rawBody = EntityUtils.toString(getBody(), "UTF-8");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return JsonUtil.toObject(rawBody, clazz);
  }
}
