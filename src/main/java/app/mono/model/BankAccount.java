package app.mono.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
public class BankAccount {

  @JsonProperty("id")
  private String id;

  @JsonProperty("sendId")
  private String sendId;

  @JsonProperty("currencyCode")
  private Integer currencyCode;

  @JsonProperty("cashbackType")
  private String cashbackType;

  @JsonProperty("balance")
  private BigDecimal balance;

  @JsonProperty("creditLimit")
  private BigDecimal creditLimit;

  @JsonProperty("maskedPan")
  private List<String> maskedPan;

  @JsonProperty("type")
  private String type;

  @JsonProperty("iban")
  private String iban;

}
