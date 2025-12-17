package com.example.Services;

import com.example.Entities.MembershipPlan;

import java.util.List;

public interface MembershipPlanService {
    // Create
    MembershipPlan createMembershipPlan(MembershipPlan membershipPlan);

    // Read
    MembershipPlan getMembershipPlanById(Long membershipPlanId);
    List<MembershipPlan> getAllMembershipPlans();

    // Update
    MembershipPlan updateMembershipPlan(Long membershipPlanId, MembershipPlan membershipPlan);

    // Delete
    void deleteMembershipPlan(Long membershipPlanId);



}
