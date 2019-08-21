package com.bgs.BoardGameSelector.dao;

import com.bgs.BoardGameSelector.model.GameMechanic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GameMechanicDao extends CrudRepository<GameMechanic, Integer> {
}
