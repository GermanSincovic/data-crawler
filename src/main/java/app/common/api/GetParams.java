package app.common.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetParams {

  private final Map<String, Object> urlGetParams = new HashMap<>();

  public GetParams set(String key, Object value) {
    this.urlGetParams.put(key, value);
    return this;
  }

  public String build() {
    List<String> stringPairs = new ArrayList<>();
    this.urlGetParams.keySet().forEach(key -> stringPairs.add(String.format("%s=%s", key, urlGetParams.get(key))));
    if (!stringPairs.isEmpty()) {
      return "?" + String.join("&", stringPairs);
    } else {
      return "";
    }
  }
}
