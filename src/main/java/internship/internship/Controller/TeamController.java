package internship.internship.Controller;

import internship.internship.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("teams")
public class TeamController {
    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("{league_id}")
    public List<Team> getTeams(@PathVariable("league_id") int league_id){
        List<Team> teams = restTemplate.getForObject("https://apiv2.apifootball.com/?action=get_teams&league_id="+league_id+"&APIkey="+apiKey,List.class);
        return teams;
    }
}
