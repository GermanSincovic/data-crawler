package app.ria.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class District {

  @JsonProperty("city_id")
  private Integer cityId;

  @JsonProperty("area_id")
  private Integer areaId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("type")
  private Integer type;

  @JsonProperty("value")
  private Integer value;
}
