package pl.agh.edu.restapihw.domain.model.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.agh.edu.restapihw.domain.model.MetaData;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlayersResponse {

    @JsonProperty("data")
    private List<Player> players;

    @JsonProperty("meta")
    private MetaData metaData;


    public Player getPlayerByName(String firstName, String lastName) {
        for (Player player : players) {
            if (player.firstName.equals(firstName) && player.lastName.equals(lastName)) {
                return player;
            }
        }
        return null;
    }
}