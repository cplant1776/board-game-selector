package com.bgs.BoardGameSelector.controllers;

import com.bgs.BoardGameSelector.model.Game;
import com.bgs.BoardGameSelector.dao.GameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GameController {

    @RequestMapping("/get-by-rank")
    @ResponseBody
    public String getByRank(Integer rank) {
        String gameId = "";
        try {
            List<Game> games = gameDao.findByRank(rank);
            for(Game game: games)
                System.out.println(game.getId());
//            gameId = String.valueOf(game.getId());

        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + gameId;
    }


    @Autowired
    private GameDao gameDao;

}