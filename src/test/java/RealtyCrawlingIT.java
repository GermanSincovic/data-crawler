import app.common.db.model.DBRealty;
import app.common.db.model.DBRealtyHistory;
import app.common.db.model.DBRealtyInfo;
import app.ria.api.RiaApiClient;
import app.ria.model.RealtyInfo;
import app.ria.model.SearchResult;
import lombok.extern.log4j.Log4j;
import org.joda.time.DateTime;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

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

  @Test
  public void itemData() {
    RiaApiClient riaApiClient = new RiaApiClient();
    List<DBRealty> realtyList = DBRealty.dao().selectAll();

    realtyList.parallelStream().forEach(realty -> {
      RealtyInfo realtyInfo = riaApiClient.getInfoById(String.valueOf(realty.getId()));

      DBRealtyHistory dbRealtyHistory = new DBRealtyHistory();
      dbRealtyHistory.setRealtyId(realty.getId());
      dbRealtyHistory.setCurrencyType("USD");
      dbRealtyHistory.setPrice(Integer.valueOf(realtyInfo.getRealty().getPriceObject().getPriceUSD().replace(" ", "")));
      dbRealtyHistory.setTime(DateTime.now().getMillis());
      DBRealtyHistory.dao().insertIgnoreDuplicates(dbRealtyHistory);

      DBRealtyInfo dbRealtyInfo = new DBRealtyInfo();
      dbRealtyInfo.setRealtyId(realty.getId());
      dbRealtyInfo.setLink(realtyInfo.getRealty().getUrl());
      DBRealtyInfo.dao().insertIgnoreDuplicates(dbRealtyInfo);
    });

  }
}
