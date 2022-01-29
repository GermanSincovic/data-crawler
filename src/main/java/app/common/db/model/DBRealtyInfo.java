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
public class DBRealtyInfo {

  @ColumnName("realty_id")
  private Long realtyId;

  @ColumnName("link")
  private String link;

  public static DBRealtyInfo.DBRealtyInfoDAO dao() {
    return DBConnector.getInstance().with(DBRealtyInfo.DBRealtyInfoDAO.class);
  }

  @RegisterBeanMapper(DBRealtyInfo.class)
  public interface DBRealtyInfoDAO {

    @SqlUpdate("INSERT IGNORE INTO realty (realty_id, link) VALUES(:realtyId, :link)")
    void insertIgnoreDuplicates(@BindBean DBRealtyInfo info);
  }
}
