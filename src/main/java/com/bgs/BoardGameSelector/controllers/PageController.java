package com.bgs.BoardGameSelector.controllers;

import com.bgs.BoardGameSelector.dao.GameDao;
import com.bgs.BoardGameSelector.model.Game;
import com.bgs.BoardGameSelector.model.GameSearch;
import com.bgs.BoardGameSelector.model.Greeting;
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
    public String search(Model model) {
        String message;
        message = "this is a message";
        model.addAttribute("message", message);
        return "search";
    }

    @PostMapping("/search")
    public String searchSubmit(Model model) {
        return "tester";
    }

    @GetMapping("/game/{gameId}")
    public String gamePage(@PathVariable(name = "gameId") int id, Model model)
    {
        Game game = gameDao.findByGameId(id);
        model.addAttribute("game", game);
        return "game";
    }

    @GetMapping("/tester")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "tester";
    }

    @GetMapping("/add")
    public String addGame(Model model) {
        return "add";
    }

}
