package com.example.Daos;

import com.example.Repos.DietPlanRepo;
import com.example.Services.DietPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DietPlanDao implements DietPlanService {
    @Autowired
    private DietPlanRepo dietPlanRepo;
}
