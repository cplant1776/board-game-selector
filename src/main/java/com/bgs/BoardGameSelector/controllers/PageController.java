package com.bgs.BoardGameSelector.controllers;

import com.bgs.BoardGameSelector.model.Game;
import com.bgs.BoardGameSelector.model.GameSearch;
import com.bgs.BoardGameSelector.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @GetMapping("/search")
    public String search(Model model) {
        return "search";
    }

    @PostMapping("/search")
    public String searchSubmit(Model model) {
        return "tester";
    }

    @GetMapping("/tester")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "tester";
    }

    @GetMapping("/resulttoo")
    public String greetingSubmit(@RequestParam(name="one", required=false, defaultValue="1") String one,
                                 @RequestParam(name="two", required=false, defaultValue="2") String two,
                                 @RequestParam(name="three", required=false, defaultValue="3") String three) {
        return "resulttoo";
    }


}
