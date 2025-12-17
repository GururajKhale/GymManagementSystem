package com.example.Repos;

import com.example.Entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer, Long> {
    Optional<Trainer> findByTrainerName(String name);

}
