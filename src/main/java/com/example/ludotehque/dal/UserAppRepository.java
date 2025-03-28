package com.example.ludotehque.dal;

import com.example.ludotehque.bo.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAppRepository extends JpaRepository<UserApp, Integer> {
    UserApp findByUsername(String username);
}
