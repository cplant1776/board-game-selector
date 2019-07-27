package com.bgs.BoardGameSelector.dao;

        import com.bgs.BoardGameSelector.model.Game;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.List;

@Transactional
public interface GameDao extends CrudRepository<Game, Long> {

        public List<Game> findByGameRank(int rank);
        public Game findByGameId(int game_id);
}
