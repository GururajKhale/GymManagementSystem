package com.example.Daos;

import com.example.Entities.Role;
import com.example.Entities.User;
import com.example.Repos.UserRepo;
import com.example.Services.UserSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDao implements UserSer {
    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public User saveUsers(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
