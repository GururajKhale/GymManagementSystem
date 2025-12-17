package com.example.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class MembershipPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membershipPlanId;
    private String membershipPlanName;
    private int membershipPlanDuration;
    private int membershipPlanCost;

    //One user can have only one active MembershipPlan
    @OneToMany(mappedBy = "membershipPlan")
    private List<User> users;


}
