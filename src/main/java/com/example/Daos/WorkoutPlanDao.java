package com.example.Daos;

import com.example.Entities.Trainer;
import com.example.Entities.User;
import com.example.Entities.WorkoutPlan;
import com.example.Repos.TrainerRepo;
import com.example.Repos.UserRepo;
import com.example.Repos.WorkoutPlanRepo;
import com.example.Services.WorkoutPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutPlanDao implements WorkoutPlanService {
    @Autowired
    private WorkoutPlanRepo workoutPlanRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TrainerRepo trainerRepo;

    @Override
    public WorkoutPlan createWorkoutPlan(WorkoutPlan workoutPlan, Long trainerId) {
        Trainer existingTrainer = trainerRepo.findById(trainerId).get();
        workoutPlan.setTrainer(existingTrainer);
        return workoutPlanRepo.save(workoutPlan);
    }

    @Override
    public WorkoutPlan getWorkoutPlanById(Long workoutPlanId) {
        return workoutPlanRepo.findById(workoutPlanId).get();
    }

    @Override
    public List<WorkoutPlan> getAllWorkoutPlans() {
        return workoutPlanRepo.findAll();
    }

    @Override
    public WorkoutPlan updateWorkoutPlan(Long workoutPlanId, WorkoutPlan workoutPlanDetails) {
        WorkoutPlan existingWorkoutPlan = workoutPlanRepo.findById(workoutPlanId).get();
        existingWorkoutPlan.setWorkoutPlanName(workoutPlanDetails.getWorkoutPlanName());
        existingWorkoutPlan.setWorkoutPlanName(workoutPlanDetails.getWorkoutPlanName());
        existingWorkoutPlan.setWorkoutPlanGoal(workoutPlanDetails.getWorkoutPlanGoal());
        existingWorkoutPlan.setWorkoutDifficulty(workoutPlanDetails.getWorkoutDifficulty());
        return workoutPlanRepo.save(existingWorkoutPlan);
    }

    @Override
    public void deleteWorkoutPlan(Long workoutPlanId) {
        workoutPlanRepo.deleteById(workoutPlanId);
    }

    @Override
    public List<WorkoutPlan> getWorkoutPlansByUserId(Long id) {
        return workoutPlanRepo.findByUserId(id);
    }

    @Override
    public List<WorkoutPlan> getWorkoutPlansByTrainerId(Long trainerId) {
        return workoutPlanRepo.findByTrainerId(trainerId);
    }

    @Override
    public List<WorkoutPlan> getWorkoutPlansByGoal(String goal) {
        return workoutPlanRepo.findByWorkoutPlanGoal(goal);
    }

    @Override
    public List<WorkoutPlan> getWorkoutPlansByDifficulty(String difficulty) {
        return workoutPlanRepo.findByWorkoutDifficulty(difficulty);
    }
}
