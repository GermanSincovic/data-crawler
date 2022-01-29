package app.ria.api;

import app.common.api.GetParams;
import app.common.api.Request;
import app.ria.model.RealtyInfo;
import app.ria.model.SearchResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.util.Objects.nonNull;

public class RiaApiClient {

  private static final String BASE_URL = "https://dom.ria.com";

  @Getter
  @AllArgsConstructor
  public enum QueryTemplates {
    BUY_APARTMENT_TEMPLATE(1, 2, 1),
    RENT_APARTMENT_TEMPLATE(1, 2, 3),
    BUY_HOUSE_TEMPLATE(4, 5, 1),
    BUY_PLOT_TEMPLATE(24, 0, 1);

    private Integer category;
    private Integer realtyType;
    private Integer operation;
  }

  private final Request request;
  private final GetParams getParams = new GetParams();

  public RiaApiClient() {
    this.request = new Request();
    this.getParams.set("with_newbuilds", "0");
    this.getParams.set("price_cur", "1");
    this.getParams.set("wo_dupl", "1");
    this.getParams.set("limit", "1000");
  }

  public SearchResult search(
      Integer stateId, Integer cityId, QueryTemplates template, Integer page) {
    String url = String.format("%s/node/searchEngine/v2", BASE_URL);
    getParams.set("state_id", stateId);
    getParams.set("city_id", cityId);
    getParams.set("category", template.getCategory());
    getParams.set("realty_type", template.getRealtyType());
    getParams.set("operation", template.getOperation());
    if (nonNull(page)) getParams.set("page", page);
    request.setGetParams(getParams);
    return request.to(url).get().read(SearchResult.class);
  }

  public RealtyInfo getInfoById(String id){
    String url = String.format("%s/v1/api/realty/final/%s", BASE_URL, id);
    request.setGetParams(getParams);
    return request.to(url).get().read(RealtyInfo.class);
  }
}
