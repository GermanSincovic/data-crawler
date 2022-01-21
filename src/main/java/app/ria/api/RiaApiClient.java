package app.ria.api;

import app.common.api.GetParams;
import app.common.api.Request;
import app.ria.model.State;

public class RiaApiClient {

  private static final String BASE_URL = "https://developers.ria.com";

  private final Request request;
  private final GetParams getParams = new GetParams();

  public RiaApiClient() {
    this.request = new Request();
    this.getParams.set("api_key", "yPBcd6ZsegCrHztkwqKmvCLTavB388M9bZ3S8b6T");
    this.getParams.set("lang_id", 2);
  }

  public State[] getStates(){
    String url = String.format("%s/dom/states", BASE_URL);
    request.setGetParams(getParams);
    return request.to(url).get().read(State[].class);
  }
}
