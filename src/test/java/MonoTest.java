import app.mono.model.BankCurrency;
import app.utils.JsonUtil;
import org.testng.annotations.Test;

public class MonoTest {

  @Test
  public static void currency(){
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
    BankCurrency[] currencies = JsonUtil.toObject(rawBody, BankCurrency[].class);
    for (BankCurrency currency : currencies) {
      System.out.println(currency.toString());
    }

    System.out.println(System.getProperty("mono.api.token"));
  }

}
