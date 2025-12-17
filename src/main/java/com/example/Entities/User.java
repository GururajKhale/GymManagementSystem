package com.example.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private String password;
    private double height;
    private double weight;
    private int age;
    private String gender;

    @Enumerated(EnumType.STRING)
    private Role role;


    //One User can have many Attendance records
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Attendance> attendances = new ArrayList<>();



    //One User can have multiple Trainers
    @ManyToMany
            @JoinTable(
                    name = "user_trainer",
                    joinColumns = @JoinColumn(name = "user_id"),
                    inverseJoinColumns = @JoinColumn(name = "trainer_id")
            )
    Set<Trainer> trainers = new HashSet<>();


    //Many users can subscribe to the same MembershipPlan
    @ManyToOne
    @JoinColumn(name = "membership_plan_id")
    private MembershipPlan membershipPlan;


    //Each workout plan belongs to one user
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<WorkoutPlan> workoutPlans = new ArrayList<>();


    //Each diet plan belongs to one user
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<DietPlan> dietPlans = new ArrayList<>();

}
