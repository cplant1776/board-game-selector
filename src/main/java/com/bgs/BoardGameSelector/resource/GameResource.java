package com.bgs.BoardGameSelector.resource;

import com.bgs.BoardGameSelector.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("search")
public class GameResource {

    private final GameService gameService;

    @Autowired
    public GameResource(GameService gameService) {
        this.gameService = gameService;
    }

}
