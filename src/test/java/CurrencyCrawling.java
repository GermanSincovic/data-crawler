import app.common.db.model.DBCurrency;
import app.mono.CurrencyCodeISO4217Enum;
import app.mono.api.MonoApiClient;
import app.mono.model.BankCurrency;
import app.utils.JsonUtil;
import org.joda.time.DateTime;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CurrencyCrawling {

  @Test
  public static void main(){
    MonoApiClient monoApiClient = new MonoApiClient();
    BankCurrency[] bankCurrencies = monoApiClient.getBankCurrency();
//    String data = "[\n" +
//            "    {\n" +
//            "      \"currencyCodeA\": 840,\n" +
//            "            \"currencyCodeB\": 980,\n" +
//            "            \"date\": 1552392228,\n" +
//            "            \"rateSell\": 27,\n" +
//            "            \"rateBuy\": 27.2,\n" +
//            "            \"rateCross\": 27.1\n" +
//            "    },\n" +
//            "    {\n" +
//            "      \"currencyCodeA\": 978,\n" +
//            "            \"currencyCodeB\": 980,\n" +
//            "            \"date\": 1552392228,\n" +
//            "            \"rateSell\": 28,\n" +
//            "            \"rateBuy\": 28.2,\n" +
//            "            \"rateCross\": 28.1\n" +
//            "    }\n" +
//            "]";
//    BankCurrency[] bankCurrencies = JsonUtil.toObject(data, BankCurrency[].class);

    BankCurrency bankCurrencyUSD = getByCodes(CurrencyCodeISO4217Enum.USD, CurrencyCodeISO4217Enum.UAH, bankCurrencies);
    BankCurrency bankCurrencyEUR = getByCodes(CurrencyCodeISO4217Enum.EUR, CurrencyCodeISO4217Enum.UAH, bankCurrencies);

    DBCurrency dbCurrency = new DBCurrency();
    dbCurrency.setDatetime(DateTime.now());
    dbCurrency.setUsdBuy(bankCurrencyUSD.getRateBuy());
    dbCurrency.setUsdSell(bankCurrencyUSD.getRateSell());
    dbCurrency.setEurBuy(bankCurrencyEUR.getRateBuy());
    dbCurrency.setEurSell(bankCurrencyEUR.getRateSell());
    DBCurrency.dao().insert(dbCurrency);
  }

  public static BankCurrency getByCodes(CurrencyCodeISO4217Enum curA, CurrencyCodeISO4217Enum curB, BankCurrency[] source){
    return Arrays.stream(source)
            .filter(c -> c.getCurrencyCodeB().equals(curB.getCode()))
            .filter(c -> c.getCurrencyCodeA().equals(curA.getCode()))
            .findFirst().orElseThrow(NullPointerException::new);
  }
}
