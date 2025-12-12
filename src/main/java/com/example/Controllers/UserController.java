package com.example.Controllers;

import com.example.Entities.User;
import com.example.Services.UserSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserSer userSer;

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getALLU(){
        List<User> users = userSer.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


}
