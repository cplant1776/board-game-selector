package com.bgs.BoardGameSelector.controllers;

import com.bgs.BoardGameSelector.dao.GameSearchDao;
import com.bgs.BoardGameSelector.model.Game;
import com.bgs.BoardGameSelector.model.GameSearch;
import com.bgs.BoardGameSelector.model.GameSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GameSearchController {
    @Autowired
    private GameSearchDao gameSearchDao;

    @RequestMapping("/q/get-by-rank")
    @ResponseBody
    public String getByRank(Integer rank) {
        GameSearch gameSearch = new GameSearch();
        GameSpecification spec = new GameSpecification(gameSearch);
        List<Game> result = gameSearchDao.findAll(spec);

        System.out.println(result.size());
        for(int i=0; i < result.size(); i++)
        {
            System.out.println(result.get(i).getName());
            System.out.println(result.get(i).getRank());
        }

        return "1";
    }
}
