package com.bgs.BoardGameSelector.controllers;

import com.bgs.BoardGameSelector.dao.CommentDao;
import com.bgs.BoardGameSelector.dao.GameDao;
import com.bgs.BoardGameSelector.dao.UserDao;
import com.bgs.BoardGameSelector.model.*;
import com.bgs.BoardGameSelector.services.CommentDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    private GameDao gameDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CommentDao commentDao;

    @GetMapping("/search")
    public String search(Model model) { return "search"; }

    @GetMapping("/")
    public String home(Model model) { return "index"; }

    @GetMapping("/index")
    public String index(Model model) { return "index"; }

    @GetMapping("/game/{gameId}")
    public String gamePage(@PathVariable(name = "gameId") int id, Model model)
    {
        // Fetch game from DB
        Game game = gameDao.findByGameId(id);
        // Fetch comments on this game along with their creator's username
        ArrayList<Object[]> commentedUsers = userDao.joinUsersWithComment(id);
        ArrayList<CommentDisplayService> comments = new ArrayList<>();
        // Create comment display objects from joined list
        if (commentedUsers.isEmpty())
            comments = null;
        else {
            for (Object[] cd : commentedUsers) {
                CommentDisplayService newComment = new CommentDisplayService(
                        (Integer) cd[0], (Integer) cd[1], (String) cd[2], (Integer) cd[3], (String) cd[4], (String) cd[5]);
                comments.add(newComment);
            }
        }

        // Add objects to model
        model.addAttribute("game", game);
        model.addAttribute("comments", comments);
        model.addAttribute("username", getLoggedInUsername());
        model.addAttribute("avatar", getLoggedInAvatar());

        return "game";
    }

    @GetMapping("/add")
    public String addGame(Model model) { return "add"; }

    @GetMapping("/edit/{gameId}")
    public String editPage(@PathVariable(name = "gameId") int id, Model model)
    {
        // Fetch game from DB
        Game game = gameDao.findByGameId(id);

        // Add objects to model
        model.addAttribute("game", game);
        model.addAttribute("username", getLoggedInUsername());

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
        // Get logged-in userId
        User user = userDao.findByUsername(getLoggedInUsername());
        if (user!= null)
        {
            long userId = user.getId();
            return "redirect:" + "/account/" + userId;
        }
        else
            return "redirect:" + "/login";

    }

    @GetMapping("/account/{userId}")
    public String userPage(@PathVariable(name = "userId", required = true) long id, Model model) {
        // Add user to model
        User user = userDao.findById(id).get();
        model.addAttribute("user", user);
        // Add user's games to model
        List<Game> games = gameDao.findByAuthorUsername(user.getUsername());
        model.addAttribute("games", games);

        // Check if logged-in user is authorized for this page
        User attemptedUser = userDao.findByUsername(getLoggedInUsername());
        if (attemptedUser.getId() != user.getId())
            model.addAttribute("incorrectUser", true);
        else
            model.addAttribute("incorrectUser", false);

        return "account";
    }

    private String getLoggedInUsername() {
        // Get username of logged-in user
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();

        } else {
            username = principal.toString();
        }

        return username;
    }

    private String getLoggedInAvatar() {
        String username = getLoggedInUsername();
        if (username.equals("anonymousUser"))
            return "";
        User user = userDao.findByUsername(username);
        return user.getAvatar();
    }

}
