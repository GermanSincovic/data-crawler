package app.ria.api;

import app.common.api.GetParams;
import app.common.api.Request;
import app.ria.model.City;
import app.ria.model.District;
import app.ria.model.SearchResult;
import app.ria.model.State;

import static java.util.Objects.nonNull;

public class RiaApiClient {

  private static final String BASE_URL = "https://developers.ria.com";

  private final Request request;
  private final GetParams getParams = new GetParams();

  public RiaApiClient() {
    this.request = new Request();
    this.getParams.set("api_key", "yPBcd6ZsegCrHztkwqKmvCLTavB388M9bZ3S8b6T");
    this.getParams.set("lang_id", 2);
  }

  public State[] getStates() {
    String url = String.format("%s/dom/states", BASE_URL);
    request.setGetParams(getParams);
    return request.to(url).get().read(State[].class);
  }

  public City[] getCities(Integer stateId) {
    String url = String.format("%s/dom/cities/%s", BASE_URL, stateId);
    request.setGetParams(getParams);
    return request.to(url).get().read(City[].class);
  }

  public District[][] getDistricts(Integer cityId) {
    String url = String.format("%s/dom/cities_districts/%s", BASE_URL, cityId);
    request.setGetParams(getParams);
    return request.to(url).get().read(District[][].class);
  }

  public SearchResult search(Integer stateId, Integer cityId, Integer districtId, Integer page){
    String url = String.format("%s/dom/search/", BASE_URL);
    getParams.set("state_id", stateId);
    getParams.set("city_id", cityId);
    getParams.set("d_id", cityId);
    if(nonNull(page)) getParams.set("page", page);
    request.setGetParams(getParams);
    return request.to(url).get().read(SearchResult.class);
  }
}
