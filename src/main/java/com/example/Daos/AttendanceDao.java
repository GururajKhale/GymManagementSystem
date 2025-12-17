package com.example.Daos;

import com.example.Repos.AttendanceRepo;
import com.example.Services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AttendanceDao implements AttendanceService {
    @Autowired
    private AttendanceRepo attendanceRepo;
}
