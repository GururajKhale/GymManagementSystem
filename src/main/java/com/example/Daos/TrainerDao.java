package com.example.Daos;

import com.example.Entities.DietPlan;
import com.example.Entities.Trainer;
import com.example.Entities.WorkoutPlan;
import com.example.Repos.DietPlanRepo;
import com.example.Repos.TrainerRepo;
import com.example.Repos.WorkoutPlanRepo;
import com.example.Services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerDao implements TrainerService {
    @Autowired
    private TrainerRepo trainerRepo;

    @Autowired
    private WorkoutPlanRepo workoutPlanRepo;

    @Autowired
    private DietPlanRepo dietPlanRepo;


    @Override
    public Trainer createTrainer(Trainer trainer) {
        return trainerRepo.save(trainer);
    }

    @Override
    public Trainer getTrainerById(Long trainerId) {
        return trainerRepo.findById(trainerId).get();
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRepo.findAll();
    }

    @Override
    public Trainer updateTrainer(Long trainerId, Trainer trainer) {

        Trainer existingTrainer = trainerRepo.findById(trainerId).get();
        existingTrainer.setTrainerName(trainer.getTrainerName());
        existingTrainer.setTrainerGender(trainer.getTrainerGender());
        existingTrainer.setTrainerSpeciality(trainer.getTrainerSpeciality());
        existingTrainer.setTrainerExperience(trainer.getTrainerExperience());
        existingTrainer.setTrainerCertification(trainer.getTrainerCertification());
        existingTrainer.setTrainerRatings(trainer.getTrainerRatings());
        return trainerRepo.save(existingTrainer);
    }

    @Override
    public void deleteTrainer(Long trainerId) {
        trainerRepo.deleteById(trainerId);
    }

    @Override
    public Trainer getTrainerWithUsers(Long trainerId) {


        return null;
    }

    @Override
    public WorkoutPlan createWorkoutPlanForTrainer(Long trainerId, WorkoutPlan workoutPlan) {
        Trainer existingTrainer = trainerRepo.findById(trainerId).get();
        workoutPlan.setTrainer(existingTrainer);
        return workoutPlanRepo.save(workoutPlan);
    }

    @Override
    public List<WorkoutPlan> getWorkoutPlansByTrainer(Long trainerId) {
        Trainer existingTrainer = trainerRepo.findById(trainerId).get();
       return existingTrainer.getWorkoutPlans();

    }

    @Override
    public DietPlan createDietPlanForTrainer(Long trainerId, DietPlan dietPlan) {
        Trainer existingTrainer = trainerRepo.findById(trainerId).get();
        dietPlan.setTrainer(existingTrainer);
        return dietPlanRepo.save(dietPlan);
    }

    @Override
    public List<DietPlan> getDietPlansByTrainer(Long trainerId) {
        Trainer existingTrainer = trainerRepo.findById(trainerId).get();
        return dietPlanRepo.findByTrainer(trainerId);
    }
}
