package com.example.Repos;

import com.example.Entities.Attendance;
import com.example.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AttendanceRepo extends JpaRepository<Attendance, Long> {

    List<Attendance> findByUserId(Long id);
}
