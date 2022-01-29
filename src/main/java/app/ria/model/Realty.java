package app.ria.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Realty {

  @JsonProperty("beautiful_url")
  private String url;

  @JsonProperty("priceObj")
  private PriceObject priceObject;
}
