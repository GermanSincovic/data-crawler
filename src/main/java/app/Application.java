package app;

import app.mono.model.BankCurrency;
import app.utils.JsonUtil;
import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.Map;

@Log
public class Application {

  public static void main(String[] args) {

    Config.init();
    //    Currency[] currencies = new MonoApiClient().getBankCurrency();
    String rawBody =
        "[\n"
            + "  {\n"
            + "    \"currencyCodeA\": 840,\n"
            + "    \"currencyCodeB\": 980,\n"
            + "    \"date\": 1552392228,\n"
            + "    \"rateSell\": 27,\n"
            + "    \"rateBuy\": 27.2,\n"
            + "    \"rateCross\": 27.1\n"
            + "  }\n"
            + "]";
    Map<String, String> map = System.getenv();
    map.keySet().forEach(key -> System.out.printf("%s = %s %n", key, map.get(key)));
    BankCurrency[] currencies = JsonUtil.toObject(rawBody, BankCurrency[].class);
    for (BankCurrency currency : currencies) {
      log.info(currency.toString());
    }
  }
}
