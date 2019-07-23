package com.bgs.BoardGameSelector.model;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class GameSpecification implements Specification<Game> {

    private GameSearch criteria;

    public GameSpecification(GameSearch gs) {
        criteria = gs;
    }

    @Override
    public Predicate toPredicate(Root<Game> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate p = cb.conjunction();

        /* Filter on . . . */

        // Rank
        p.getExpressions().add(cb.between(root.get("rank"), criteria.minRank, criteria.maxRank));

        // Number of Players
        p.getExpressions().add(cb.between(root.get("min_player"), criteria.minNumOfPlayers, criteria.maxNumOfPlayers));
        p.getExpressions().add(cb.between(root.get("max_player"), criteria.minNumOfPlayers, criteria.maxNumOfPlayers));

        // Year Published Published
        p.getExpressions().add(cb.between(root.get("year"), criteria.minYearPublished, criteria.maxYearPublished));

        // Average Play Time
        p.getExpressions().add(cb.between(root.get("avg_play_time"), criteria.minAvgPlayTime, criteria.maxAvgPlayTime));

        // Minimum Play Time
        p.getExpressions().add(cb.between(root.get("min_play_time"), criteria.minMinPlayTime, criteria.maxMinPlayTime));

        // Maximum Play Time
        p.getExpressions().add(cb.between(root.get("max_play_time"), criteria.minMaxPlayTime, criteria.maxMaxPlayTime));

        // Number of Votes
        p.getExpressions().add(cb.between(root.get("num_votes"), criteria.minVotes, criteria.maxVotes));

        // Recommended Age
        p.getExpressions().add(cb.between(root.get("age"), criteria.minAge, criteria.maxAge));

        // Number of Fans
        p.getExpressions().add(cb.between(root.get("fans"), criteria.minFans, criteria.maxFans));

        // TODO: Mechanics

        // TODO: Category

        return p;
    }

}