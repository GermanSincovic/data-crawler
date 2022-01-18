import app.common.db.DBConnector;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Slf4j
public class StatementCrawling {

  @BeforeTest
  public static void before() {
    try {
      DBConnector.getInstance();
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }

  @Test
  public static void main() {

  }
}
