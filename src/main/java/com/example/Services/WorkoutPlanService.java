package com.example.Services;

import com.example.Entities.Trainer;
import com.example.Entities.WorkoutPlan;

import java.util.List;

public interface WorkoutPlanService {
    // 1. Basic CRUD Operations
    WorkoutPlan createWorkoutPlan(WorkoutPlan workoutPlan, Long trainerId);

    WorkoutPlan getWorkoutPlanById(Long workoutPlanId);

    List<WorkoutPlan> getAllWorkoutPlans();

    WorkoutPlan updateWorkoutPlan(Long workoutPlanId, WorkoutPlan workoutPlanDetails);

    void deleteWorkoutPlan(Long workoutPlanId);

    // 2. Business Logic / Custom Queries
    List<WorkoutPlan> getWorkoutPlansByUserId(Long userId);

    List<WorkoutPlan> getWorkoutPlansByTrainerId(Long trainerId);

    List<WorkoutPlan> getWorkoutPlansByGoal(String goal);

    List<WorkoutPlan> getWorkoutPlansByDifficulty(String difficulty);
}
