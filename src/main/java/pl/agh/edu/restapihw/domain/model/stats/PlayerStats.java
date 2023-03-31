package pl.agh.edu.restapihw.domain.model.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PlayerStats {

    @JsonProperty("games_played")
    protected int gamesPlayed;

    @JsonProperty("player_id")
    protected Integer playerId;

    @JsonProperty("season")
    protected int season;

    @JsonProperty("min")
    protected String min;

    @JsonProperty("fgm")
    protected double fgm;

    @JsonProperty("fga")
    protected double fga;

    @JsonProperty("fg3m")
    protected double fg3m;

    @JsonProperty("fg3a")
    protected double fg3a;

    @JsonProperty("ftm")
    protected double ftm;

    @JsonProperty("fta")
    protected double fta;

    @JsonProperty("oreb")
    protected double oreb;

    @JsonProperty("dreb")
    protected double dreb;

    @JsonProperty("reb")
    protected double reb;

    @JsonProperty("ast")
    protected double ast;

    @JsonProperty("stl")
    protected double stl;

    @JsonProperty("blk")
    protected double blk;

    @JsonProperty("turnover")
    protected double turnover;

    @JsonProperty("pf")
    protected double pf;

    @JsonProperty("pts")
    protected double pts;

    @JsonProperty("fg_pct")
    protected double fgPct;

    @JsonProperty("fg3_pct")
    protected double fg3Pct;

    @JsonProperty("ft_pct")
    protected double ftPct;
}
