package internship.internship.Controller;

import internship.internship.models.Standing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("standings")
public class StandingsController {
    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{league_id}/{team_id}")
    public List<Standing> getStandings(@PathVariable("league_id") int league_id){
        List<Standing> standings = restTemplate.getForObject("https://apiv2.apifootball.com/?action=get_standings&league_id="+league_id+"&APIkey="+apiKey,List.class);
        return standings;
    }
}
