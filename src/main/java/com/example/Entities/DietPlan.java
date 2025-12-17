package com.example.Entities;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class DietPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dietPlanId;
    private String dietPlanType;
    private int caloriesIntakePerDay;
    private int proteinIntakePerHour;
    private int mealFrequency;


    //One user can have multiple diet plans
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    //One trainer can create many diet plans
    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;






}
