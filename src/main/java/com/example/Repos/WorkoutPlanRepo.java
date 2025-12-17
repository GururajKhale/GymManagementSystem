package com.example.Repos;

import com.example.Entities.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutPlanRepo extends JpaRepository<WorkoutPlan, Long> {

    List<WorkoutPlan> findByUserId(Long User);

    List<WorkoutPlan> findByTrainerId(Long TrainerId);

    List<WorkoutPlan> findByWorkoutPlanGoal(String goal);

    List<WorkoutPlan> findByWorkoutDifficulty(String difficulty);



}
