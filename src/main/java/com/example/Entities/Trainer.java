package com.example.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerId;
    private String trainerName;
    private String trainerGender;
    private String trainerSpeciality;
    private String trainerExperience;
    private String trainerCertification;
    private int trainerRatings;
    private LocalDate trainerJoiningDate;

    //One Trainer can train multiple Users
    @ManyToMany(mappedBy = "trainers")
    private Set<User> users =  new HashSet<>();


    //Each workout plan is created by one trainer
    @OneToMany(mappedBy = "trainer")
    private List<WorkoutPlan> workoutPlans =  new ArrayList<>();


    //Each diet plan is assigned by one trainer
    @OneToMany(mappedBy = "trainer")
    private List<DietPlan> dietPlans =  new ArrayList<>();


}
