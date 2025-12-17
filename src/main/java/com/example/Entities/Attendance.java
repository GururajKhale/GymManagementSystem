package com.example.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;
    private LocalDate attendanceDate;
    private LocalTime checkInTime;
    private String attendanceStatus;
    private boolean workoutCompleted;
    private double caloriesBurned;
    private String remarks;

    //Each Attendance belongs to one User
    @ManyToOne
    private User user;
}
