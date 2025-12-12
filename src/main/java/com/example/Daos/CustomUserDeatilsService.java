package com.example.Daos;

import com.example.Entities.User;
import com.example.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDeatilsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User with email not found"+email));
        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }


    private String getRoles(User user) {
        if (user.getRole() == null){
            return "USER";
        }
        return user.getRole().name();
    }
}
