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
public class DBRealty {

  @ColumnName("id")
  private Long id;

  @ColumnName("state")
  private Integer state;

  @ColumnName("city")
  private Integer city;

  @ColumnName("category")
  private Integer category;

  @ColumnName("realty_type")
  private Integer realtyType;

  @ColumnName("operation")
  private Integer operation;

  public static DBRealty.DBRealtyDAO dao() {
    return DBConnector.getInstance().with(DBRealty.DBRealtyDAO.class);
  }

  @RegisterBeanMapper(DBRealty.class)
  public interface DBRealtyDAO {

    @SqlUpdate(
        "INSERT IGNORE INTO statements (id, time, description, mcc, original_mcc, hold, amount, operation_amount, currency_code, commission_rate, cashback_amount, balance, comment, receipt_id, counter_edrpou, counter_iban) "
            + " VALUES(:id, :time, :description, :mcc, :originalMcc, :hold, :amount, :operationAmount, :currencyCode, :commissionRate, :cashbackAmount, :balance, :comment, :receiptId, :counterEdrpou, :counterIban)")
    void insertIgnoreDuplicates(@BindBean DBRealty realty);
  }
}
