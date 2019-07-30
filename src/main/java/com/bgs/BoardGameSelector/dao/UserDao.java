package com.bgs.BoardGameSelector.dao;


import com.bgs.BoardGameSelector.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
