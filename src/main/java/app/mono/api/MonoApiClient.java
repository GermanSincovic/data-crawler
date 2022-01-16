package app.mono.api;

import app.common.api.Request;
import app.mono.model.BankCurrency;

public class MonoApiClient {

  private static final String BASE_URL = "https://api.monobank.ua";

  private final Request request;

  public MonoApiClient() {
    this.request = new Request();
    request.setHeader("X-Token", System.getProperty("mono.api.token"));
  }

  public BankCurrency[] getBankCurrency() {
    return request.to(BASE_URL + "/bank/currency").get().read(BankCurrency[].class);
  }
}
