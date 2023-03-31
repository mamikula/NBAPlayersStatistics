package pl.agh.edu.restapihw.domain.model.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.agh.edu.restapihw.domain.model.team.Team;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Player {

    @JsonProperty("id")
    protected int id;

    @JsonProperty("first_name")
    protected String firstName;

    @JsonProperty("last_name")
    protected String lastName;

    @JsonProperty("position")
    protected String position;

    @JsonProperty("height_feet")
    protected int heightFeet;

    @JsonProperty("height_inches")
    protected int heightInches;

    @JsonProperty("weight_pounds")
    protected int weightPounds;

    @JsonProperty("team")
    protected Team team;

}
