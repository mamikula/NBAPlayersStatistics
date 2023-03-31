package pl.agh.edu.restapihw.domain;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.agh.edu.restapihw.domain.model.player.Player;
import pl.agh.edu.restapihw.domain.model.player.PlayersResponse;
import pl.agh.edu.restapihw.domain.model.stats.PlayerStats;
import pl.agh.edu.restapihw.domain.model.stats.PlayerStatsResponse;
import pl.agh.edu.restapihw.errors.exceptions.EmptyResponseException;
import pl.agh.edu.restapihw.errors.exceptions.PlayerNotFoundException;
import pl.agh.edu.restapihw.errors.exceptions.StatsNotFoundException;
import pl.agh.edu.restapihw.errors.exceptions.WrongSeasonDateException;

@Service
@AllArgsConstructor
public class NBAService {

    private final RestTemplate restTemplate;

    public Player getPlayerFromApi(String firstName, String lastName) {
        String apiUrl = "https://www.balldontlie.io/api/v1/players";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("search", lastName)
                .queryParam("per_page", 100);
        ResponseEntity<PlayersResponse> response = restTemplate.getForEntity(builder.toUriString(), PlayersResponse.class);

        if(response.getBody() == null) {
            throw new EmptyResponseException();
        }
        if(response.getBody().getPlayers().size() == 0){
            throw new PlayerNotFoundException();
        }
        return response.getBody().getPlayerByName(firstName, lastName);
    }

    public PlayerStats getPlayerStatsFromApi(Integer id, Integer year) {
        String apiUrl = "https://www.balldontlie.io/api/v1/season_averages?season=" + year + "&player_ids[]=" + id;
        ResponseEntity<PlayerStatsResponse> response = restTemplate.getForEntity(apiUrl, PlayerStatsResponse.class);
        if(response.getBody() == null) {
            throw new EmptyResponseException();
        }
        if(year < 1979 || year > 2023)  {
            throw new WrongSeasonDateException();
        }
        if(response.getBody().getPlayerStats().size() == 0){
            throw new StatsNotFoundException();
        }
        return response.getBody().getPlayerStats().get(0);

    }

}
