package com.example.demo.repository;

import com.example.demo.model.Schedule;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    
}
