package pl.agh.edu.restapihw.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.edu.restapihw.domain.NBAService;
import pl.agh.edu.restapihw.domain.model.player.Player;
import pl.agh.edu.restapihw.domain.model.stats.PlayerStats;



@RestController
@RequestMapping(path = "/nba")
public class NBAController {
    private final NBAService nbaService;


    public NBAController(NBAService nbaService) {
        this.nbaService = nbaService;
    }

    @GetMapping("/players")
    public Player getPlayer(
        @RequestParam(name = "first", defaultValue = "") String firstName,
        @RequestParam(name = "last", defaultValue = "") String lastName
    ){
        return this.nbaService.getPlayerFromApi(firstName,lastName);
    }

    @GetMapping("/season_averages")
    public PlayerStats getPlayerStats(
        @RequestParam(name = "player_ids[]", defaultValue = "") Integer id,
        @RequestParam(name = "season", defaultValue = "") Integer year
            ){
        return this.nbaService.getPlayerStatsFromApi(id, year);
    }

}
