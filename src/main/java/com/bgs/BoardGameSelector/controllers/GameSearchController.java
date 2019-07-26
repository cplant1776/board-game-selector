package com.bgs.BoardGameSelector.controllers;

import com.bgs.BoardGameSelector.dao.GameSearchDao;
import com.bgs.BoardGameSelector.model.Game;
import com.bgs.BoardGameSelector.model.GameSearch;
import com.bgs.BoardGameSelector.model.GameSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GameSearchController {
    @Autowired
    private GameSearchDao gameSearchDao;

    @GetMapping("/query")
    public String runSearch( @RequestParam(name="rank-min", required=false, defaultValue="0") int minRank,
                            @RequestParam(name="rank-max", required = false, defaultValue = "10000") int maxRank,
                            @RequestParam(name="num-of-players-min", required = false, defaultValue = "1") int minNumOfPlayers,
                            @RequestParam(name="num-of-players-max", required = false, defaultValue = "500") int maxNumOfPlayers,
                            @RequestParam(name="year-min", required = false, defaultValue = "-2000") int minYearPublished,
                            @RequestParam(name="year-max", required = false, defaultValue = "2019") int maxYearPublished,
                            @RequestParam(name="avg-play-time-min", required = false, defaultValue = "0") int minAvgPlayTime,
                            @RequestParam(name="avg-play-time-max", required = false, defaultValue = "99999") int maxAvgPlayTime,
                            @RequestParam(name="min-play-time-min", required = false, defaultValue = "0") int minMinPlayTime,
                            @RequestParam(name="min-play-time-max", required = false, defaultValue = "99999") int maxMinPlayTime,
                            @RequestParam(name="max-play-time-min", required = false, defaultValue = "0") int minMaxPlayTime,
                            @RequestParam(name="max-play-time-max", required = false, defaultValue = "99999") int maxMaxPlayTime,
                            @RequestParam(name="votes-min", required = false, defaultValue = "0") int minVotes,
                            @RequestParam(name="votes-max", required = false, defaultValue = "999999") int maxVotes,
                            @RequestParam(name="age-min", required = false, defaultValue = "0") int minAge,
                            @RequestParam(name="age-max", required = false, defaultValue = "999") int maxAge,
                            @RequestParam(name="fans-min", required = false, defaultValue = "0") int minFans,
                            @RequestParam(name="fans-max", required = false, defaultValue = "999999") int maxFans,
                            @RequestParam(name="mechanic", required = false, defaultValue = "") String mechanic,
                            @RequestParam(name="category", required = false, defaultValue = "") String category,
                             Model model) {

        // Instantiate search criteria
        GameSearch gameSearch = new GameSearch(minRank, maxRank, minNumOfPlayers, maxNumOfPlayers,
        minYearPublished, maxYearPublished, minAvgPlayTime, maxAvgPlayTime, minMinPlayTime,
        maxMinPlayTime,  minMaxPlayTime,  maxMaxPlayTime,  minVotes,  maxVotes,
         minAge, maxAge, minFans, maxFans, mechanic, category);

        // Generate list of Games from query result
        GameSpecification spec = new GameSpecification(gameSearch);
        List<Game> result = gameSearchDao.findAll(spec);

        // Agge results to search result page
        model.addAttribute("games", result);

        // Debug purposes
        System.out.println(result.size());
        for (Game game : result) {
            System.out.println(game.getName());
            System.out.println(game.getRank());
        }

        return "result";
    }
}
