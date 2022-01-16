package app.mono.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BankCurrency {

  @JsonProperty("currencyCodeA")
  private Integer currencyCodeA;

  @JsonProperty("currencyCodeB")
  private Integer currencyCodeB;

  @JsonProperty("date")
  private Long date;

  @JsonProperty("rateSell")
  private Double rateSell;

  @JsonProperty("rateBuy")
  private Double rateBuy;

  @JsonProperty("rateCross")
  private Double rateCross;
}
