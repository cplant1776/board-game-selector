package com.bgs.BoardGameSelector.dao;

import com.bgs.BoardGameSelector.model.Game;

import java.util.UUID;

public interface GameDao {
    // Create
    int insertNewGame(UUID gameId, Game game);

    // Read
    Game selectGameById(UUID gameId);
    // Update
    int updateGameById(UUID gameId, Game game);
    // Destroy
    int deleteGameById(UUID gameId);
}
