package com.bgs.BoardGameSelector.controllers;

import com.bgs.BoardGameSelector.model.Game;
import com.bgs.BoardGameSelector.dao.GameDao;
import com.bgs.BoardGameSelector.model.GameSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GameController {

    @Autowired
    private GameDao gameDao;

    @PostMapping("/success")
    public String addGame( @RequestParam(name="name", required=false, defaultValue="0") String name,
                           @RequestParam(name="designer", required=false, defaultValue="0") String designer,
                           @RequestParam(name="publisher", required=false, defaultValue="0") String publisher,
                           @RequestParam(name="year", required=false, defaultValue="0") int year,
                           @RequestParam(name="min-players", required=false, defaultValue="0") int minPlayers,
                           @RequestParam(name="max-players", required=false, defaultValue="0") int maxPlayers,
                           @RequestParam(name="age", required=false, defaultValue="0") int age,
                           @RequestParam(name="avg-play-time", required=false, defaultValue="0") int avgPlayTime,
                           @RequestParam(name="min-play-time", required=false, defaultValue="0") int minPlayTime,
                           @RequestParam(name="max-play-time", required=false, defaultValue="0") int maxPlayTime,
                           @RequestParam(name="desc", required=false, defaultValue="0") String desc,
                           @RequestParam(name="img-url", required=false, defaultValue="0") String imgURL,
                           @RequestParam(name="thumb-url", required=false, defaultValue="0") String thumbURL,
                           @RequestParam(name="bgg-url", required=false, defaultValue="0") String bggURL,
                             Model model) {

        // Instantiate new game
        Game game = new Game();
        game.setName(name);
        game.setDesigner(designer);
        game.setPublisher(publisher);
        game.setYear(year);
        game.setMin_player(minPlayers);
        game.setMax_player(maxPlayers);
        game.setAge(age);
        game.setAvg_play_time(avgPlayTime);
        game.setMin_play_time(minPlayTime);
        game.setMax_player(maxPlayTime);
        game.setDescription(desc);
        game.setImg_url(imgURL);
        game.setThumb_url(thumbURL);
        game.setBgg_url(bggURL);

        gameDao.save(game);
        System.out.println("Added game successfully!");

        return "success";
    }

}