import app.common.db.model.DBCurrency;
import app.mono.CurrencyCodeISO4217;
import app.mono.api.MonoApiClient;
import app.mono.model.BankCurrency;
import lombok.extern.log4j.Log4j;
import org.joda.time.DateTime;
import org.testng.annotations.Test;

import java.util.Arrays;

@Log4j
public class CurrencyCrawling extends Crawling {

  @Test
  public static void main() {
    MonoApiClient monoApiClient = new MonoApiClient();
    BankCurrency[] bankCurrencies = monoApiClient.getBankCurrency();

    BankCurrency bankCurrencyUSD =
        getByCodes(
            CurrencyCodeISO4217.getCodeByName("USD"),
            CurrencyCodeISO4217.getCodeByName("UAH"),
            bankCurrencies);
    BankCurrency bankCurrencyEUR =
        getByCodes(
            CurrencyCodeISO4217.getCodeByName("EUR"),
            CurrencyCodeISO4217.getCodeByName("UAH"),
            bankCurrencies);

    DBCurrency dbCurrency = new DBCurrency();
    dbCurrency.setCreated(DateTime.now().getMillis());
    dbCurrency.setUsdBuy(bankCurrencyUSD.getRateBuy());
    dbCurrency.setUsdSell(bankCurrencyUSD.getRateSell());
    dbCurrency.setEurBuy(bankCurrencyEUR.getRateBuy());
    dbCurrency.setEurSell(bankCurrencyEUR.getRateSell());
    DBCurrency.dao().insert(dbCurrency);
  }

  public static BankCurrency getByCodes(Integer curA, Integer curB, BankCurrency[] source) {
    return Arrays.stream(source)
        .filter(c -> c.getCurrencyCodeB().equals(curB))
        .filter(c -> c.getCurrencyCodeA().equals(curA))
        .findFirst()
        .orElseThrow(NullPointerException::new);
  }
}
