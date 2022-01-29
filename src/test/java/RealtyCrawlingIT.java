import app.common.db.model.DBRealty;
import app.ria.api.RiaApiClient;
import app.ria.model.SearchResult;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Log4j
public class RealtyCrawlingIT {

  /** Область */
  private static final Integer VIN_STATE = 1;

  /** Город */
  private static final Integer VIN_CITY = 1;

  @DataProvider
  public Object[][] categories() {
    return new Object[][] {
      {RiaApiClient.QueryTemplates.BUY_APARTMENT_TEMPLATE},
      {RiaApiClient.QueryTemplates.BUY_HOUSE_TEMPLATE},
      {RiaApiClient.QueryTemplates.BUY_PLOT_TEMPLATE},
      {RiaApiClient.QueryTemplates.RENT_APARTMENT_TEMPLATE}
    };
  }

  @Test(dataProvider = "categories")
  public void main(RiaApiClient.QueryTemplates category) {
    RiaApiClient riaApiClient = new RiaApiClient();

    int page = 0;
    while (true) {
      SearchResult res = riaApiClient.search(VIN_STATE, VIN_CITY, category, page++);
      res.getItems()
          .forEach(
              item -> {
                DBRealty realty = new DBRealty();
                realty.setId(item);
                realty.setState(VIN_STATE);
                realty.setCity(VIN_CITY);
                realty.setCategory(category.getCategory());
                realty.setRealtyType(category.getRealtyType());
                realty.setOperation(category.getOperation());
                DBRealty.dao().insertIgnoreDuplicates(realty);
              });
      if (res.getItems().size() < 1000) break;
    }
  }
}
