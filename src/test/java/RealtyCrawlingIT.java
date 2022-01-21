import app.ria.api.RiaApiClient;
import app.ria.model.State;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.Test;

@Log4j
public class RealtyCrawlingIT {

  /**  Область   */
  private static final String STATE = "Винницкая";

  /**  Город   */
  private static final String CITY = "Винница";

  @Test
  public void some1(){
    RiaApiClient riaApiClient = new RiaApiClient();
    State[] states = riaApiClient.getStates();
    log.info(states[1]);
  }

}
