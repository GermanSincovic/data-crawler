package app.mono.api;

import app.Config;
import app.common.api.Request;
import app.mono.model.BankCurrency;

public class MonoApiClient {

  private static final String BASE_URL = Config.getProperty("mono.api.url");
  private final Request request;

  public MonoApiClient() {
    this.request = new Request();
    request.setHeader("X-Token", Config.getProperty("mono.api.token"));
  }

  public BankCurrency[] getBankCurrency() {
    return request.to(BASE_URL + "/bank/currency").get().read(BankCurrency[].class);
  }
}
