package com.example.Repos;

import com.example.Entities.MembershipPlan;
import com.example.Entities.User;
import com.example.Entities.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
      Optional<User> findByEmail(String email);

      List<MembershipPlan> findByMembershipPlan(long membershipPlanId);


}
