package com.bgs.BoardGameSelector.dao;

import com.bgs.BoardGameSelector.model.Game;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("mySQL")
public class MySQLGameDao implements GameDao {

    public int populateDatabaseFromCSV() {
        // TODO: Create table from game csv initially
        return 1;
    }

    @Override
    public int insertNewGame(UUID gameId, Game game) {
        // Add a new game to the database
        return 1;
    }

    @Override
    public Game selectGameById(UUID gameId) {
        // Return Game with passed id in DB
        return null;
    }

    @Override
    public int updateGameById(UUID gameId, Game game) {
        // Modify existing game in DB
        return 1;
    }

    @Override
    public int deleteGameById(UUID gameId) {
        // Remove Game with passed id from DB
        return 1;
    }
}
