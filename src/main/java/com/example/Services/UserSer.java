package com.example.Services;

import com.example.Entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserSer {
    User saveUsers(User user);

    List<User> getAllUsers();
}
