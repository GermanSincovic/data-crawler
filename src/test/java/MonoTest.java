import app.common.db.DBConnector;
import app.mono.api.MonoApiClient;
import app.mono.model.BankCurrency;
import org.testng.annotations.Test;

public class MonoTest {

  @Test
  public static void currency(){
//    BankCurrency[] currencies = new MonoApiClient().getBankCurrency();
//    String rawBody =
//            "[\n"
//                    + "  {\n"
//                    + "    \"currencyCodeA\": 840,\n"
//                    + "    \"currencyCodeB\": 980,\n"
//                    + "    \"date\": 1552392228,\n"
//                    + "    \"rateSell\": 27,\n"
//                    + "    \"rateBuy\": 27.2,\n"
//                    + "    \"rateCross\": 27.1\n"
//                    + "  }\n"
//                    + "]";

    System.out.println(System.getProperty("mono.api.token"));
    System.out.println(System.getProperty("db.url"));
    System.out.println(System.getProperty("db.user"));
    System.out.println(System.getProperty("db.password"));
    System.out.println(DBConnector.getInstance());
  }

}
