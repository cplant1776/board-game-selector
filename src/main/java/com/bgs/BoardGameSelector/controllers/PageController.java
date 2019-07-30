package com.bgs.BoardGameSelector.controllers;

import com.bgs.BoardGameSelector.dao.GameDao;
import com.bgs.BoardGameSelector.model.Game;
import com.bgs.BoardGameSelector.model.GameSearch;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @Autowired
    private GameDao gameDao;

    @GetMapping("/search")
    public String search(Model model) { return "search"; }


//    @GetMapping("/game/{gameId}")
    @GetMapping("/game/{gameId}")
    public String gamePage(@PathVariable(name = "gameId") int id, Model model)
    {
        Game game = gameDao.findByGameId(id);
        model.addAttribute("game", game);
        return "game";
    }

    @GetMapping("/add")
    public String addGame(Model model) { return "add"; }

    @GetMapping("/edit/{gameId}")
    public String editPage(@PathVariable(name = "gameId") int id, Model model)
    {
        Game game = gameDao.findByGameId(id);
        model.addAttribute("game", game);
        return "edit";
    }

//    @GetMapping("/login")
//    public String loginPage(Model model) { return "login"; }

    @GetMapping("/logout-success")
    public String logoutPage(Model model) {return "success"; }

}
