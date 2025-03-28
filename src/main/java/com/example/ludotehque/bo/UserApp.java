package com.example.ludotehque.bo;

import aj.org.objectweb.asm.TypeReference;
import com.example.ludotehque.dal.UserAppRepository;
import com.example.ludotehque.security.MyUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name= "USERAPP")
public class UserApp implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noUser;
    @Column @NonNull
    private String username;
    @Column @NonNull
    private String password;
    @Column(columnDefinition = "NVARCHAR(MAX)")
    @NonNull
    private String roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles.split(",")) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
            System.out.println("authorities:" + authorities);
        }

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
