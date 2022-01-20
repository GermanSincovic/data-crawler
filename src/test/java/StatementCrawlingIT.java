import app.common.db.model.DBStatement;
import app.mono.CurrencyCodeISO4217;
import app.mono.api.MonoApiClient;
import app.mono.model.BankStatement;
import lombok.extern.log4j.Log4j;
import org.joda.time.DateTime;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

@Log4j
public class StatementCrawlingIT extends Crawling {

  @Test
  public static void main() {

    BigDecimal correction = new BigDecimal(100);

    MonoApiClient monoApiClient = new MonoApiClient();
    BankStatement[] data =
        monoApiClient.getBankStatement(
            DateTime.now().minusDays(30).getMillis(), DateTime.now().getMillis());

    Arrays.stream(data)
        .forEach(
            bankStatement -> {
              DBStatement dbStatement = new DBStatement();
              dbStatement.setId(bankStatement.getId());
              dbStatement.setTime(bankStatement.getTime());
              dbStatement.setDescription(bankStatement.getDescription());
              dbStatement.setMcc(bankStatement.getMcc());
              dbStatement.setOriginalMcc(bankStatement.getOriginalMcc());
              dbStatement.setHold(bankStatement.getHold());
              dbStatement.setAmount(
                  bankStatement.getAmount().divide(correction, 2, RoundingMode.CEILING));
              dbStatement.setOperationAmount(bankStatement.getOperationAmount());
              dbStatement.setCommissionRate(bankStatement.getCommissionRate());
              dbStatement.setCashbackAmount(bankStatement.getCashbackAmount());
              dbStatement.setBalance(bankStatement.getBalance());
              dbStatement.setComment(bankStatement.getComment());
              dbStatement.setReceiptId(bankStatement.getReceiptId());
              dbStatement.setCounterEdrpou(bankStatement.getCounterEdrpou());
              dbStatement.setCounterIban(bankStatement.getCounterIban());
              dbStatement.setCurrencyCode(
                  CurrencyCodeISO4217.getNameByCode(bankStatement.getCurrencyCode()));
              DBStatement.dao().insertIgnoreDuplicates(dbStatement);
            });
  }
}
