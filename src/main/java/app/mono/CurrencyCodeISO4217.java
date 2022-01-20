package app.mono;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CurrencyCodeISO4217 {

  static {
    Map<Integer, String> temp = new HashMap<>();
    temp.put(840, "USD");
    temp.put(978, "EUR");
    temp.put(980, "UAH");
    mapping = Collections.unmodifiableMap(temp);
  }

  private static final Map<Integer, String> mapping;

  private CurrencyCodeISO4217() {}

  public static String getNameByCode(Integer code) {
    return mapping.get(code);
  }

  public static Integer getCodeByName(String name) {
    return mapping.entrySet().stream()
            .filter(pair -> pair.getValue().equals(name))
            .findFirst().orElseThrow(IllegalArgumentException::new)
            .getKey();
  }
}
