package com.example.Controllers;

import com.example.Daos.CustomUserDeatilsService;
import com.example.Daos.JwtService;
import com.example.Entities.User;
import com.example.Request.LoginRequest;
import com.example.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private CustomUserDeatilsService customUserDeatilsService;


    @PostMapping("/registerUser")
    public ResponseEntity<User> saveU(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUsers(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginU(@RequestBody LoginRequest loginRequest) throws Exception {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(), loginRequest.getPassword()
        ));

        if(authenticate.isAuthenticated()){
            String jwt = jwtService.generateJwtToken(customUserDeatilsService.loadUserByUsername(loginRequest.getEmail()));
            return new ResponseEntity<>(jwt, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Unauthorized user",HttpStatus.UNAUTHORIZED);
        }
    }
}
