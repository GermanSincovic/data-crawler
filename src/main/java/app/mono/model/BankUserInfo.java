package app.mono.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class BankUserInfo {

  @JsonProperty("id")
  private String id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("webHookUrl")
  private String webHookUrl;

  @JsonProperty("accounts")
  private List<BankAccount> accounts;

}
