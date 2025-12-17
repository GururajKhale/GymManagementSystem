package com.example.Controllers;

import com.example.Entities.WorkoutPlan;
import com.example.Services.WorkoutPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/WorkoutPlan")

public class WorkoutPlanController {

    @Autowired
    WorkoutPlanService workoutPlanService;

    @PostMapping("/saveWorkoutPlan")
    public ResponseEntity<WorkoutPlan> swp(@RequestBody WorkoutPlan workoutPlan, @RequestBody Long trainerId){

        return new ResponseEntity<> (workoutPlanService.createWorkoutPlan(workoutPlan, trainerId),HttpStatus.CREATED) ;
    }





}
