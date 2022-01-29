package app.mono.api;

import app.common.api.GetParams;
import app.common.api.Request;
import app.mono.model.BankCurrency;
import app.mono.model.BankStatement;
import app.mono.model.BankUserInfo;

public class MonoApiClient {

  private static final String BASE_URL = "https://api.monobank.ua";

  private final Request request;

  public MonoApiClient() {
    this.request = new Request();
    request.setHeader("X-Token", System.getProperty("mono.api.token"));
    request.setGetParams(new GetParams());
  }

  public BankUserInfo getUserInfo() {
    String url = String.format("%s/personal/client-info", BASE_URL);
    return request.to(url).get().read(BankUserInfo.class);
  }

  public BankCurrency[] getBankCurrency() {
    String url = String.format("%s/bank/currency", BASE_URL);
    return request.to(url).get().read(BankCurrency[].class);
  }

  public BankStatement[] getBankStatement(Integer account, Long from, Long to) {
    String url = String.format("%s/personal/statement/%s/%s/%s", BASE_URL, account, from, to);
    return request.to(url).get().read(BankStatement[].class);
  }

  public BankStatement[] getBankStatement(Long from, Long to) {
    return getBankStatement(0, from, to);
  }
}
