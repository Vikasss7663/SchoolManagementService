package com.springboot.tutorial.repository;

import com.springboot.tutorial.model.Schedule;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    
}
