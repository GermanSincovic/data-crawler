package app.mono;

import lombok.Getter;

public enum CurrencyCodeISO4217Enum {
  USD(840),
  UAH(980);

  @Getter
  private final Integer num;

  CurrencyCodeISO4217Enum(Integer num) {
    this.num = num;
  }
}
