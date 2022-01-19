package app.mono.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BankError {

  @JsonProperty("errorDescription")
  private String errorDescription;
}
