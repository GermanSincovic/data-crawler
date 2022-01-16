import app.common.db.model.DBCurrency;
import app.mono.CurrencyCodeISO4217Enum;
import app.mono.api.MonoApiClient;
import app.mono.model.BankCurrency;
import org.joda.time.DateTime;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CurrencyCrawling {

  @Test
  public static void main(){
    MonoApiClient monoApiClient = new MonoApiClient();
    BankCurrency[] bankCurrencies = monoApiClient.getBankCurrency();
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
