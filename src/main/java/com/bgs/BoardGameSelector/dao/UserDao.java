package com.bgs.BoardGameSelector.dao;


import com.bgs.BoardGameSelector.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
