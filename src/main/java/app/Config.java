package app;

import java.io.IOException;
import java.util.Properties;

public class Config {

  private static final Properties props = new Properties();

  private Config() {
  }

  public static String getProperty(String property) {
    return props.getProperty(property);
  }

  public static String getEnvVar(String key){
    return System.getenv(key);
  }

  public static void init() {
    try {
      props.load(Application.class.getClassLoader().getResourceAsStream("conf.properties"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
