package com.bgs.BoardGameSelector.controllers;

import com.bgs.BoardGameSelector.dao.GameSearchDao;
import com.bgs.BoardGameSelector.model.Game;
import com.bgs.BoardGameSelector.services.GameSearchService;
import com.bgs.BoardGameSelector.services.GameSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GameSearchController {
    @Autowired
    private GameSearchDao gameSearchDao;

    @GetMapping("/query")
    public String runSearch( @RequestParam(name="rankMin", required=false, defaultValue="0") int minRank,
                            @RequestParam(name="rankMax", required = false, defaultValue = "10000") int maxRank,
                            @RequestParam(name="playersMin", required = false, defaultValue = "1") int minNumOfPlayers,
                            @RequestParam(name="playersMax", required = false, defaultValue = "500") int maxNumOfPlayers,
                            @RequestParam(name="yearMin", required = false, defaultValue = "-2000") int minYearPublished,
                            @RequestParam(name="yearMax", required = false, defaultValue = "2019") int maxYearPublished,
                            @RequestParam(name="avgPlayTimeMin", required = false, defaultValue = "0") int minAvgPlayTime,
                            @RequestParam(name="avgPlayTimeMax", required = false, defaultValue = "99999") int maxAvgPlayTime,
                            @RequestParam(name="minPlayTimeMin", required = false, defaultValue = "0") int minMinPlayTime,
                            @RequestParam(name="minPlayTimeMax", required = false, defaultValue = "99999") int maxMinPlayTime,
                            @RequestParam(name="maxPlayTimeMin", required = false, defaultValue = "0") int minMaxPlayTime,
                            @RequestParam(name="maxPlayTimeMax", required = false, defaultValue = "99999") int maxMaxPlayTime,
                            @RequestParam(name="votesMin", required = false, defaultValue = "0") int minVotes,
                            @RequestParam(name="votesMax", required = false, defaultValue = "999999") int maxVotes,
                            @RequestParam(name="ageMin", required = false, defaultValue = "0") int minAge,
                            @RequestParam(name="ageMax", required = false, defaultValue = "999") int maxAge,
                            @RequestParam(name="fansMin", required = false, defaultValue = "0") int minFans,
                            @RequestParam(name="fansMax", required = false, defaultValue = "999999") int maxFans,
                            @RequestParam(name="mechanic", required = false, defaultValue = "") String mechanic,
                            @RequestParam(name="category", required = false, defaultValue = "") String category,
                             Model model) {

        // Instantiate search criteria
        GameSearchService gameSearchService = new GameSearchService(minRank, maxRank, minNumOfPlayers, maxNumOfPlayers,
        minYearPublished, maxYearPublished, minAvgPlayTime, maxAvgPlayTime, minMinPlayTime,
        maxMinPlayTime,  minMaxPlayTime,  maxMaxPlayTime,  minVotes,  maxVotes,
         minAge, maxAge, minFans, maxFans, mechanic, category);

        // Generate list of Games from query result
        GameSpecificationService spec = new GameSpecificationService(gameSearchService);
        List<Game> result = gameSearchDao.findAll(spec);

        // Agge results to search result page
        model.addAttribute("games", result);

        // Debug purposes
        System.out.println(result.size());
        for (Game game : result) {
            System.out.println(game.getName());
            System.out.println(game.getGameRank());
        }

        return "result";
    }
}
