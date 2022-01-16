package app.mono;

import lombok.Getter;

public enum CurrencyCodeISO4217Enum {
  USD(840),
  EUR(978),
  UAH(980);

  @Getter
  private final Integer code;

  CurrencyCodeISO4217Enum(Integer num) {
    this.code = num;
  }
}
