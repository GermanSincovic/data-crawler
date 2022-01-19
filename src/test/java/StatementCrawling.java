import app.mono.api.MonoApiClient;
import app.mono.model.BankStatement;
import app.utils.JsonUtil;
import lombok.extern.log4j.Log4j;
import org.joda.time.DateTime;
import org.testng.annotations.Test;

@Log4j
public class StatementCrawling extends Crawling {

  @Test
  public static void main() {
    MonoApiClient monoApiClient = new MonoApiClient();
    BankStatement[] data =
        monoApiClient.getBankStatement(
            DateTime.now().minusDays(30).getMillis(), DateTime.now().getMillis());
    System.out.println(JsonUtil.toStr(data));
  }
}
