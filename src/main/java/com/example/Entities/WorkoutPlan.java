package com.example.Entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class WorkoutPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workoutPlanId;
    private String workoutPlanName;
    private String workoutPlanGoal;
    private String workoutDifficulty;

    //One user can have multiple workout plans
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    //One trainer can create many workout plans
    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

}
