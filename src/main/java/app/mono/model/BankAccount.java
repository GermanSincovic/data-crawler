package app.mono.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BankAccount {

  @JsonProperty("id")
  private String id;

  @JsonProperty("balance")
  private String balance;

  @JsonProperty("creditLimit")
  private String creditLimit;

  @JsonProperty("type")
  private String type;

  @JsonProperty("currencyCode")
  private String currencyCode;

  @JsonProperty("cashbackType")
  private String cashbackType;

}
