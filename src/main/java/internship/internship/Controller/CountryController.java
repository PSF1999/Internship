package internship.internship.Controller;

import internship.internship.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

@RequestMapping("/countries")
    public List<Country> getCountries(){
        List<Country> countries = restTemplate.getForObject("https://apiv2.apifootball.com/?action=get_countries&APIkey="+apiKey,List.class);
        return countries;
    }
}
