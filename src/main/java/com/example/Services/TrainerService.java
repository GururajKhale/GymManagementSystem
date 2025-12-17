package com.example.Services;

import com.example.Entities.DietPlan;
import com.example.Entities.Trainer;
import com.example.Entities.WorkoutPlan;

import java.util.List;

public interface TrainerService {

    Trainer createTrainer(Trainer trainer);

    Trainer getTrainerById(Long trainerId);

    List<Trainer> getAllTrainers();

    Trainer updateTrainer(Long trainerId, Trainer trainer);

    void deleteTrainer(Long trainerId);

    // Trainer – User mapping
    Trainer getTrainerWithUsers(Long trainerId);

    // Trainer – WorkoutPlan
    WorkoutPlan createWorkoutPlanForTrainer(Long trainerId, WorkoutPlan workoutPlan);
    List<WorkoutPlan> getWorkoutPlansByTrainer(Long trainerId);

    // Trainer – DietPlan
    DietPlan createDietPlanForTrainer(Long trainerId, DietPlan dietPlan);
    List<DietPlan> getDietPlansByTrainer(Long trainerId);
}
