package com.example.ludotehque.security;

import com.example.ludotehque.bo.UserApp;
import com.example.ludotehque.dal.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserAppRepository userAppRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        UserApp user = userAppRepository.findByUsername(username);
        // Check username
        if(user==null) {
            throw  new UsernameNotFoundException("Utilisateur non trouvé : " + username);
        }

        System.out.println(Collections.singletonList(user.getRoles()));

        User.UserBuilder userBuilder = User.withUsername(user.getUsername());
        userBuilder.password(user.getPassword());
        userBuilder.authorities(user.getAuthorities());
        userDetails = userBuilder.build();

        /*
        System.out.println(userDetails.getAuthorities());
        for(GrantedAuthority authority : userDetails.getAuthorities()) {
            System.out.println(authority.getAuthority());
        }
        */

        return userDetails;
    }
}
