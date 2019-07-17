package com.bgs.BoardGameSelector.service;

import com.bgs.BoardGameSelector.dao.GameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final GameDao gameDao;

    @Autowired
    public GameService(@Qualifier("mySQL") GameDao gameDao) {
        this.gameDao = gameDao;
    }
}
