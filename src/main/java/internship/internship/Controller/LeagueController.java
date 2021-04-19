package internship.internship.Controller;

import internship.internship.models.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/leagues")
public class LeagueController {
    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("{country_id}")
    public List<League> getLeagues(@PathVariable("country_id") int country_id){
        List<League> leagues = restTemplate.getForObject("https://apiv2.apifootball.com/?action=get_leagues&country_id="+country_id+"&APIkey="+apiKey,List.class);
        return leagues;
    }
}
