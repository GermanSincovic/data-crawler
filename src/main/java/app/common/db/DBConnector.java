package app.common.db;

import com.mysql.cj.jdbc.Driver;
import lombok.extern.log4j.Log4j;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.SqlLogger;
import org.jdbi.v3.core.statement.StatementContext;
import org.jdbi.v3.jodatime2.JodaTimePlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.temporal.ChronoUnit;

import static java.lang.System.getProperty;

@Log4j
public class DBConnector {

  private static final String DATABASE_URL = getProperty("db.url");
  private static final String DATABASE_USER = getProperty("db.user");
  private static final String DATABASE_PASS = getProperty("db.password");

  private static DBConnector instance;

  private Jdbi jdbi;

  private DBConnector() {
    try {
      Driver driver = new Driver();
      DriverManager.registerDriver(driver);
      Connection connection =
          DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASS);
      jdbi = Jdbi.create(connection);
      jdbi.installPlugin(new SqlObjectPlugin());
      jdbi.installPlugin(new JodaTimePlugin());
      jdbi.setSqlLogger(
          new SqlLogger() {
            @Override
            public void logAfterExecution(StatementContext context) {
              log.info(
                  String.format(
                      "%n%s%nQUERY STATEMENT: [%s]%nQUERY PARAMS: [%s]%nEXECUTION TIME: [%sms]%n%s",
                      "================================================",
                      context.getParsedSql().getSql(),
                      context.getBinding().toString(),
                      context.getElapsedTime(ChronoUnit.MILLIS),
                      "================================================"));
            }
          });
    } catch (SQLException e) {
      log.error(e.getMessage());
    }
  }

  public static DBConnector getInstance() {
    if (instance == null) {
      instance = new DBConnector();
    }
    return instance;
  }

  public <T> T with(Class<T> clazz) {
    return jdbi.onDemand(clazz);
  }

  public void execute(String q) {
    jdbi.withHandle(h -> h.execute(q));
  }
}
