package app.mono.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class BankStatement {

  @JsonProperty("id")
  private String id;

  @JsonProperty("time")
  private Long time;

  @JsonProperty("description")
  private String description;

  @JsonProperty("mcc")
  private String mcc;

  @JsonProperty("hold")
  private String hold;

  @JsonProperty("amount")
  private BigDecimal amount;

  @JsonProperty("operationAmount")
  private BigDecimal operationAmount;

  @JsonProperty("currencyCode")
  private Integer currencyCode;

  @JsonProperty("commissionRate")
  private BigDecimal commissionRate;

  @JsonProperty("cashbackAmount")
  private BigDecimal cashbackAmount;

  @JsonProperty("balance")
  private BigDecimal balance;

  @JsonProperty("comment")
  private String comment;

  @JsonProperty("receiptId")
  private String receiptId;

  @JsonProperty("counterEdrpou")
  private String counterEdrpou;

  @JsonProperty("counterIban")
  private String counterIban;
}
