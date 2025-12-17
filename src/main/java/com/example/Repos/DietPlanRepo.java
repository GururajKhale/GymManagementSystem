package com.example.Repos;

import com.example.Entities.DietPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DietPlanRepo extends JpaRepository<DietPlan, Long> {
    List<DietPlan> findByTrainer(Long trainerId);

}
