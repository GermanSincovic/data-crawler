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

  @ColumnName("originalMcc")
  private String originalMcc;

  @ColumnName("hold")
  private Boolean hold;

  @ColumnName("amount")
  private BigDecimal amount;

  @ColumnName("operationAmount")
  private BigDecimal operationAmount;

  @ColumnName("currencyCode")
  private Integer currencyCode;

  @ColumnName("commissionRate")
  private BigDecimal commissionRate;

  @ColumnName("cashbackAmount")
  private BigDecimal cashbackAmount;

  @ColumnName("balance")
  private BigDecimal balance;

  @ColumnName("comment")
  private String comment;

  @ColumnName("receiptId")
  private String receiptId;

  @ColumnName("counterEdrpou")
  private String counterEdrpou;

  @ColumnName("counterIban")
  private String counterIban;

  public static DBStatement.DBStatementDAO dao() {
    return DBConnector.getInstance().with(DBStatement.DBStatementDAO.class);
  }

  @RegisterBeanMapper(DBStatement.class)
  public interface DBStatementDAO {

//    TODO: Statement inserting with duplicate ignoring

//    @SqlUpdate(
//            "INSERT INTO currency "
//                    + "(created, USD_buy, USD_sell, EUR_buy, EUR_sell) "
//                    + "VALUES (:created, :usdBuy, :usdSell, :eurBuy, :eurSell)")
//    void insert(@BindBean DBStatement statement);
  }
}
