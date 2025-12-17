package com.example.Services;

import com.example.Entities.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface UserService {

    // ========== USER CRUD ==========
    User saveUsers(User user);
    User getUserById(Long userId);
    List<User> getAllUsers();
    User updateUser(Long userId, User user);
    void deleteUser(Long userId);

    // ========== ATTENDANCE ==========
    Attendance markAttendance(Long userId, Attendance attendance);
    List<Attendance> getUserAttendance(Long userId);

    // ========== TRAINER ASSIGNMENT ==========
    User assignTrainerToUser(Long userId, Long trainerId);
    Set<Trainer> getTrainersOfUser(Long userId);

    // ========== MEMBERSHIP ==========
    User assignMembershipPlan(Long userId, Long membershipPlanId);

    // ========== WORKOUT PLAN ==========
    WorkoutPlan addWorkoutPlanToUser(Long userId, WorkoutPlan workoutPlan);
    List<WorkoutPlan> getWorkoutPlansOfUser(Long userId);

    // ========== DIET PLAN ==========
    DietPlan addDietPlanToUser(Long userId, DietPlan dietPlan);
    List<DietPlan> getDietPlansOfUser(Long userId);

    // Extra (Business logic)
    List<?> getUsersByMembershipPlan(Long membershipPlanId);
}
