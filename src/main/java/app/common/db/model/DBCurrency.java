package app.common.db.model;

import app.common.db.DBConnector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jdbi.v3.core.mapper.reflect.ColumnName;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.joda.time.DateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DBCurrency {

  @ColumnName("datetime")
  private DateTime datetime;

  @ColumnName("USD_buy")
  private Double usdBuy;

  @ColumnName("USD_sell")
  private Double usdSell;

  @ColumnName("EUR_buy")
  private Double eurBuy;

  @ColumnName("EUR_sell")
  private Double eurSell;

  public static DBCurrencyDAO dao() {
    return DBConnector.getInstance().with(DBCurrency.DBCurrencyDAO.class);
  }

  @RegisterBeanMapper(DBCurrency.class)
  public interface DBCurrencyDAO {

    @SqlUpdate(
        "INSERT INTO currency "
            + "(datetime, USD_buy, USD_sell, EUR_buy, EUR_sell) "
            + "VALUES (:datetime, :usdBuy, :usdSell, :eurBuy, :eurSell)")
    void insert(@BindBean DBCurrency currency);
  }
}
