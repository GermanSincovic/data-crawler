package app.ria.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

  @JsonProperty("cityID")
  private Integer cityId;

  @JsonProperty("stateID")
  private Integer stateId;

  @JsonProperty("name")
  private String name;
}
