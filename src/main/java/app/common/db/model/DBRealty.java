package app.common.db.model;

import app.common.db.DBConnector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jdbi.v3.core.mapper.reflect.ColumnName;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

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

    @SqlQuery("SELECT * FROM realty")
    List<DBRealty> selectAll();

    @SqlUpdate(
        "INSERT IGNORE INTO realty (id, state, city, category, realty_type, operation)"
            + " VALUES(:id, :state, :city, :category, :realtyType, :operation)")
    void insertIgnoreDuplicates(@BindBean DBRealty realty);
  }
}
