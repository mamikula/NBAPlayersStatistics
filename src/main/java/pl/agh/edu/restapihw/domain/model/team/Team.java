package pl.agh.edu.restapihw.domain.model.team;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @JsonProperty("id")
    private int teamId;

    @JsonProperty("abbreviation")
    private String teamAbbreviation;

    @JsonProperty("city")
    private String teamCity;

    @JsonProperty("conference")
    private String teamConference;

    @JsonProperty("division")
    private String teamDivision;

    @JsonProperty("full_name")
    private String teamFullName;

    @JsonProperty("name")
    private String teamName;

}
