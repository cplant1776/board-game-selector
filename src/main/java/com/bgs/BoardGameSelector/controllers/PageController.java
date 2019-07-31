package com.bgs.BoardGameSelector.controllers;

import com.bgs.BoardGameSelector.dao.GameDao;
import com.bgs.BoardGameSelector.model.Game;
import com.bgs.BoardGameSelector.model.GameSearch;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
        // Fetch game from DB
        Game game = gameDao.findByGameId(id);
        model.addAttribute("game", game);

        // Get username of logged-in user
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();

        } else {
            username = principal.toString();
        }
        model.addAttribute("username", username);

        return "game";
    }

    @GetMapping("/add")
    public String addGame(Model model) { return "add"; }

    @GetMapping("/edit/{gameId}")
    public String editPage(@PathVariable(name = "gameId") int id, Model model)
    {
        // Fetch game from DN
        Game game = gameDao.findByGameId(id);
        model.addAttribute("game", game);

        // Get username of logged-in user
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();

        } else {
            username = principal.toString();
        }
        model.addAttribute("username", username);
        return "edit";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(name = "error", required = false) String error, Model model) {
        if (error != null)
            model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/logout-success")
    public String logoutPage(Model model) {return "success"; }

    @GetMapping("/new-user")
    public String newUserPage(Model model) {
        return "new-user";
    }

}
