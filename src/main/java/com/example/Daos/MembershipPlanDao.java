package com.example.Daos;

import com.example.Entities.MembershipPlan;
import com.example.Repos.MembershipPlanRepo;
import com.example.Services.MembershipPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipPlanDao implements MembershipPlanService {
    @Autowired
    private MembershipPlanRepo membershipPlanRepo;


    @Override
    public MembershipPlan createMembershipPlan(MembershipPlan membershipPlan) {
        return  membershipPlanRepo.save(membershipPlan);
    }

    @Override
    public MembershipPlan getMembershipPlanById(Long membershipPlanId) {
        return membershipPlanRepo.findById(membershipPlanId).get();
    }

    @Override
    public List<MembershipPlan> getAllMembershipPlans() {
        return membershipPlanRepo.findAll();
    }

    @Override
    public MembershipPlan updateMembershipPlan(Long membershipPlanId, MembershipPlan membershipPlan) {
        MembershipPlan existingMembershipPlan = membershipPlanRepo.findById(membershipPlanId).get();
        existingMembershipPlan.setMembershipPlanName(membershipPlan.getMembershipPlanName());
        existingMembershipPlan.setMembershipPlanCost(membershipPlan.getMembershipPlanCost());
        existingMembershipPlan.setMembershipPlanDuration(membershipPlan.getMembershipPlanDuration());
        return membershipPlanRepo.save(existingMembershipPlan);
    }

    @Override
    public void deleteMembershipPlan(Long membershipPlanId) {
        membershipPlanRepo.deleteById(membershipPlanId);
    }


}
