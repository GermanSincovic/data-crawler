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

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DBStatement {

  @ColumnName("id")
  private String id;

  @ColumnName("time")
  private Long time;

  @ColumnName("description")
  private String description;

  @ColumnName("mcc")
  private String mcc;

  @ColumnName("original_mcc")
  private String originalMcc;

  @ColumnName("hold")
  private Boolean hold;

  @ColumnName("amount")
  private BigDecimal amount;

  @ColumnName("operation_amount")
  private BigDecimal operationAmount;

  @ColumnName("currency_code")
  private String currencyCode;

  @ColumnName("commission_rate")
  private BigDecimal commissionRate;

  @ColumnName("cashback_amount")
  private BigDecimal cashbackAmount;

  @ColumnName("balance")
  private BigDecimal balance;

  @ColumnName("comment")
  private String comment;

  @ColumnName("receipt_id")
  private String receiptId;

  @ColumnName("counter_edrpou")
  private String counterEdrpou;

  @ColumnName("counter_iban")
  private String counterIban;

  public static DBStatement.DBStatementDAO dao() {
    return DBConnector.getInstance().with(DBStatement.DBStatementDAO.class);
  }

  @RegisterBeanMapper(DBStatement.class)
  public interface DBStatementDAO {

    @SqlUpdate(
        "INSERT IGNORE INTO statements (id, time, description, mcc, original_mcc, hold, amount, operation_amount, currency_code, commission_rate, cashback_amount, balance, comment, receipt_id, counter_edrpou, counter_iban) "
            + " VALUES(:id, :time, :description, :mcc, :originalMcc, :hold, :amount, :operationAmount, :currencyCode, :commissionRate, :cashbackAmount, :balance, :comment, :receiptId, :counterEdrpou, :counterIban)")
    void insertIgnoreDuplicates(@BindBean DBStatement statement);
  }
}
