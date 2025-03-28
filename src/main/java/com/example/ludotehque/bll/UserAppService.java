package com.example.ludotehque.bll;

import com.example.ludotehque.bo.UserApp;
import com.example.ludotehque.dal.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAppService {
    @Autowired
    private UserAppRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserApp createUser(String username, String password, String roles) {
        UserApp user = new UserApp();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); // Encoder le mot de passe
        user.setRoles(roles);
        return userRepository.save(user);
    }
}
