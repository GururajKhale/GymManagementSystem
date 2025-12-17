package com.example.Repos;

import com.example.Entities.MembershipPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipPlanRepo extends JpaRepository<MembershipPlan, Long> {
}
