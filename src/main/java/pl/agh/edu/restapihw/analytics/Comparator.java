package pl.agh.edu.restapihw.analytics;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.agh.edu.restapihw.domain.NBAService;
import pl.agh.edu.restapihw.domain.model.player.Player;
import pl.agh.edu.restapihw.domain.model.stats.PlayerStats;


@AllArgsConstructor
@Component
public class Comparator {


    private NBAService nbaService;

    private String compareStats(Double stat1, Double stat2) { //stat1 <- season1, stat2 , <- season2
        double v = Math.round(((stat1 - stat2) * 100.0)) / 100.0;
        if (stat1 > stat2) return "has better " + stat1 + " ( +" + v + " ) ";
        else if (stat1 < stat2) return "has worse " + stat1 + " (" + v + " ) ";
        else return "has the same " + stat1;
    }

    public String comparePlayerSeasons(String firstName, String lastName, Integer season1, Integer season2) {
        Player player = nbaService.getPlayerFromApi(firstName, lastName);
        Integer id = player.getId();
        PlayerStats playerStatsSeason1 = nbaService.getPlayerStatsFromApi(id, season1);
        PlayerStats playerStatsSeason2 = nbaService.getPlayerStatsFromApi(id, season2);

        return player.getFirstName() + " " + player.getLastName() + " in season " + season1 + "\n" +
                compareStats(playerStatsSeason1.getPts(), playerStatsSeason2.getPts()) + "points \n" +
                compareStats(playerStatsSeason1.getReb(), playerStatsSeason2.getReb()) + "rebounds \n" +
                compareStats(playerStatsSeason1.getBlk(), playerStatsSeason2.getBlk()) + "blocks \n" +
                compareStats(playerStatsSeason1.getStl(), playerStatsSeason2.getStl()) + "steals \n" +
                compareStats(playerStatsSeason1.getTurnover(), playerStatsSeason2.getTurnover()) + "turnovers \n" +
                compareStats(playerStatsSeason1.getFg3Pct(), playerStatsSeason2.getFg3Pct()) + "field goal 3-point percentage \n" +
                compareStats(playerStatsSeason1.getFgPct(), playerStatsSeason2.getFgPct()) + "field goal percentage \n" +
                "than in season " + season2;

    }

}
