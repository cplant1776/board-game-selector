package com.bgs.BoardGameSelector.controllers;

import com.bgs.BoardGameSelector.dao.GameDao;
import com.bgs.BoardGameSelector.dao.UserDao;
import com.bgs.BoardGameSelector.model.Game;
import com.bgs.BoardGameSelector.model.GameSearch;
import com.bgs.BoardGameSelector.model.User;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private GameDao gameDao;

    @Autowired
    private UserDao userDao;

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

    @GetMapping("/account")
    public String accountRedirect(Model model) {
        // Get username of logged-in user
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();

        } else {
            username = principal.toString();
        }

        User user = userDao.findByUsername(username);
        long userId = user.getId();

        return "redirect:" + "/account/" + userId;
    }

    @GetMapping("/account/{userId}")
    public String userPage(@PathVariable(name = "userId", required = true) long id, Model model) {
        // Add user to model
        User user = userDao.findById(id).get();
        model.addAttribute("user", user);
        // Add user's games to model
        List<Game> games = gameDao.findByAuthorUsername(user.getUsername());
        model.addAttribute("games", games);

        // Check to make sure user is authorized
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();

        } else {
            username = principal.toString();
        }

        User attemptedUser = userDao.findByUsername(username);
        if (attemptedUser.getId() != user.getId())
            model.addAttribute("incorrectUser", true);
        else
            model.addAttribute("incorrectUser", false);

        return "account";
    }

}
