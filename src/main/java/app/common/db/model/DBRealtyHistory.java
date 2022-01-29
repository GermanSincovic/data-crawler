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

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DBRealtyHistory {

  @ColumnName("id")
  private Long id;

  @ColumnName("realty_id")
  private Long realtyId;

  @ColumnName("time")
  private Long time;

  @ColumnName("price")
  private Integer price;

  @ColumnName("currency_type")
  private String currencyType;

  public static DBRealtyHistory.DBRealtyHistoryDAO dao() {
    return DBConnector.getInstance().with(DBRealtyHistory.DBRealtyHistoryDAO.class);
  }

  @RegisterBeanMapper(DBRealtyHistory.class)
  public interface DBRealtyHistoryDAO {

    @SqlUpdate(
        "INSERT INTO realty_history (realty_id, time, price, currency_type)"
            + " VALUES(:realtyId, :time, :price, :currencyType)")
    void insertIgnoreDuplicates(@BindBean DBRealtyHistory history);
  }
}
