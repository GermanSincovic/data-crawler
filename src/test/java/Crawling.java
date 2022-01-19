import app.common.db.DBConnector;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.BeforeTest;

@Log4j
public class Crawling {

  @BeforeTest
  public static void before() {
    try {
      DBConnector.getInstance();
    } catch (Exception e) {
      log.error(e.getMessage());
    }
  }
}
