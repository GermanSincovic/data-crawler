package app.ria.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class State {

  @JsonProperty("stateID")
  private Integer stateId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("region_name")
  private String regionName;
}
