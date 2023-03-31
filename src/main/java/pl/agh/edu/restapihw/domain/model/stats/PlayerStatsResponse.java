package pl.agh.edu.restapihw.domain.model.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.agh.edu.restapihw.domain.model.MetaData;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PlayerStatsResponse {

    @JsonProperty("data")
    private List<PlayerStats> playerStats;


    public PlayerStats getPlayerStats(Integer id){
        return playerStats.stream()
                .filter(stats -> Objects.equals(stats.playerId, id))
                .findFirst()
                .orElse(null);
    }
}
