package com.bgs.BoardGameSelector.dao;

import com.bgs.BoardGameSelector.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface GameSearchDao extends JpaRepository<Game, Long>, JpaSpecificationExecutor<Game> {
}
