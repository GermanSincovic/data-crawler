package app.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

  private JsonUtil() {}

  public static String toString(Object obj) {
    ObjectMapper mapper = new ObjectMapper();
    String result = null;
    try {
      result = mapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return result;
  }

  public static <T> T toObject(String string, Class<T> clazz) {
    ObjectMapper mapper = new ObjectMapper();
    T result = null;
    try {
      result = mapper.readValue(string, clazz);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return result;
  }
}
