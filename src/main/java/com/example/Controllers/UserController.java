package com.example.Controllers;

import com.example.Entities.*;
import com.example.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping("/saveUsers")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUsers(user),HttpStatus.CREATED);
    }

    @GetMapping("/getUserById/{uId}")
    public ResponseEntity<User> getUBI(@PathVariable("uId") Long userId){
        return new ResponseEntity<>(userService.getUserById(userId),HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getALLU(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @PutMapping("/updateUser/{uId}")
    public ResponseEntity<User> updateU(@PathVariable("uId") Long userId, @RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(userId,user), HttpStatus.OK);
    }


    @DeleteMapping("/deleteUser/{uId}")
    public ResponseEntity<?> deleteU(@PathVariable("uId") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
    }


    @PostMapping("/markUserAttendance/{uId}")
    public ResponseEntity<Attendance> markUA(@PathVariable("uId") Long userId, @RequestBody Attendance attendance){
        return new ResponseEntity<>(userService.markAttendance(userId, attendance), HttpStatus.CREATED);
    }

    @GetMapping("/getUserAttendance/{uId}")
    public ResponseEntity<List<Attendance>> getUA(@PathVariable("uId") Long userId){
        return new ResponseEntity<>(userService.getUserAttendance(userId), HttpStatus.OK);
    }

    @PostMapping("/assignTrainerToUser/{uId}/{tId}")
    public ResponseEntity<User> assignTU(@PathVariable("uId") Long userId, @PathVariable("tId") Long trainerId){
        return new ResponseEntity<>(userService.assignTrainerToUser(userId, trainerId), HttpStatus.CREATED);
    }

    @GetMapping("/getTrainersOfUser/{uId}")
    public ResponseEntity<Set<Trainer>> getTU(@PathVariable("uId") Long userId){
        return new ResponseEntity<>(userService.getTrainersOfUser(userId), HttpStatus.OK);
    }

    @PostMapping("/assignMembershipPlan/{uId}/{mId}")
    public ResponseEntity<User> assignM(@PathVariable("uId") Long userId, @PathVariable("mId") Long membershipPlanId){
        return new ResponseEntity<>(userService.assignMembershipPlan(userId, membershipPlanId), HttpStatus.CREATED);
    }

    @PostMapping("/addWorkoutPlanToUser/{uId}")
    public ResponseEntity<WorkoutPlan> addWTU(@PathVariable("uId") Long userId, @RequestBody WorkoutPlan workoutPlan){
        return new ResponseEntity<>(userService.addWorkoutPlanToUser(userId, workoutPlan), HttpStatus.CREATED);
    }

    @GetMapping("/getWorkoutPlansOfUser/{uId}")
    public ResponseEntity<List<WorkoutPlan>> getWOU(@PathVariable("uId") Long userId){
        return new ResponseEntity<>(userService.getWorkoutPlansOfUser(userId), HttpStatus.OK);
    }

    @PostMapping("/addDietPlanToUser/{uId}")
    public ResponseEntity<DietPlan> addDTU(@PathVariable("uId") Long userId, @RequestBody DietPlan dietPlan){
        return new ResponseEntity<>(userService.addDietPlanToUser(userId, dietPlan), HttpStatus.CREATED);
    }

    @GetMapping("/getDietPlansOfUser/{uId}")
    public ResponseEntity<List<DietPlan>> getDOU(@PathVariable("uId") Long userId){
        return new ResponseEntity<>(userService.getDietPlansOfUser(userId), HttpStatus.OK);
    }

    @GetMapping("/getUsersByMembershipPlan/{mId}")
    public ResponseEntity<List<?>> getUBM(@PathVariable("mId") Long membershipPlanId){
        return new ResponseEntity<>(userService.getUsersByMembershipPlan(membershipPlanId), HttpStatus.OK);
    }



























}
