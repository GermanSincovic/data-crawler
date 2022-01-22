import app.ria.api.RiaApiClient;
import app.ria.model.City;
import app.ria.model.District;
import app.ria.model.SearchResult;
import app.ria.model.State;
import lombok.extern.log4j.Log4j;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Log4j
public class RealtyCrawlingIT {

  /** Область */
  private static final String STATE = "Винницкая";

  /** Город */
  private static final String CITY = "Винница";

  @Test
  public void some1() throws NotFound {
    RiaApiClient riaApiClient = new RiaApiClient();

    State[] states = riaApiClient.getStates();

    State state =
        Arrays.stream(states)
            .filter(s -> s.getName().equals(STATE))
            .findFirst()
            .orElseThrow(NotFound::new);

    City[] cities = riaApiClient.getCities(state.getStateId());

    City city =
        Arrays.stream(cities)
            .filter(c -> c.getName().equals(CITY))
            .findFirst()
            .orElseThrow(NotFound::new);

    District[][] districts = riaApiClient.getDistricts(city.getCityId());
    List<Integer> distIds =
        Arrays.stream(districts)
            .filter(
                dist -> dist[0].getName().equals("Район") || dist[0].getName().equals("Пригород"))
            .flatMap(Arrays::stream)
            .map(District::getValue)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

    List<Long> realtyIds = new ArrayList<>();
    for (Integer distId : distIds){
      int page = 0;
      while (true) {
        //        SearchResult res = riaApiClient.search(state.getStateId(), city.getCityId(),
        // distId, page);
        //        realtyIds.addAll(res.getItems());
        //        if(res.getItems().size() < 100) break;
        System.out.print("state=" + state.getStateId());
        System.out.print(" city=" + city.getCityId());
        System.out.print(" distId=" + distId);
        System.out.println(" page=" + page);
        if(page >= 10) break;
        page += 1;
      }
    }

    System.out.println(realtyIds.size());

  }
}
