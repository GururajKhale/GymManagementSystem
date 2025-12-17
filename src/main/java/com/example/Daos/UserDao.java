package com.example.Daos;

import com.example.Entities.*;
import com.example.Repos.AttendanceRepo;
import com.example.Repos.TrainerRepo;
import com.example.Repos.UserRepo;
import com.example.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserDao implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    AttendanceRepo attendanceRepo;

    @Autowired
    TrainerRepo trainerRepo;

    @Autowired
    PasswordEncoder passwordEncoder;




    @Override
    public User saveUsers(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        return userRepo.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepo.findById(userId).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }


    @Override
    public User updateUser(Long userId, User user) {
        User existingUser = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setUserName(user.getUserName());
        existingUser.setEmail(user.getEmail());
        existingUser.setHeight(user.getHeight());
        existingUser.setWeight(user.getWeight());
        existingUser.setAge(user.getAge());
        existingUser.setGender(user.getGender());
        return userRepo.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
         userRepo.deleteById(userId);
    }

    @Override
    public Attendance markAttendance(Long userId, Attendance attendance) {
        User existingUser = userRepo.findById(userId).get();
        attendance.setUser(existingUser);
        return attendanceRepo.save(attendance);
    }

    @Override
    public List<Attendance> getUserAttendance(Long userId) {
        return attendanceRepo.findByUserId(userId);
    }

    @Override
    public User assignTrainerToUser(Long userId, Long trainerId) {
        User existingUser = userRepo.findById(userId).get();
        Trainer existingTrainer = trainerRepo.findById(trainerId).get();

        existingUser.getTrainers().add(existingTrainer);
        return userRepo.save(existingUser);
    }

    @Override
    public Set<Trainer> getTrainersOfUser(Long userId) {

        return null;
    }

    @Override
    public User assignMembershipPlan(Long userId, Long membershipPlanId) {
        return null;
    }

    @Override
    public WorkoutPlan addWorkoutPlanToUser(Long userId, WorkoutPlan workoutPlan) {
        return null;
    }

    @Override
    public List<WorkoutPlan> getWorkoutPlansOfUser(Long userId) {
        return List.of();
    }

    @Override
    public DietPlan addDietPlanToUser(Long userId, DietPlan dietPlan) {
        return null;
    }

    @Override
    public List<DietPlan> getDietPlansOfUser(Long userId) {
        return List.of();
    }

    @Override
    public List<?> getUsersByMembershipPlan(Long membershipPlanId) {
        return userRepo.findByMembershipPlan(membershipPlanId);
    }
}
