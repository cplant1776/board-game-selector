package com.bgs.BoardGameSelector.controllers;

import com.bgs.BoardGameSelector.model.Game;
import com.bgs.BoardGameSelector.model.GameSearch;
import com.bgs.BoardGameSelector.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    @GetMapping("/search")
    public String search(Model model) {
        model.addAttribute("gameSearch", new GameSearch());
        return "search";
    }

    @PostMapping("/search")
    public String searchSubmit(@ModelAttribute GameSearch gameSearch) {
        return "tester";
    }

    @GetMapping("/tester")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "tester";
    }

    @PostMapping("/tester")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {
        return "resulttoo";
    }


}
