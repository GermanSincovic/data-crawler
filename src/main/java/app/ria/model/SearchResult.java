package app.ria.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult {

  @JsonProperty("items")
  private List<Long> items;

  @JsonProperty("count")
  private Integer count;
}
