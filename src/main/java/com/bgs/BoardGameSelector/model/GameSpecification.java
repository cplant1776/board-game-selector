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
        Predicate p = null;

        if (criteria.minRank != -1) {
            p = cb.between(root.get("rank"), criteria.minRank, criteria.maxRank);
        }

        return p;
    }

}