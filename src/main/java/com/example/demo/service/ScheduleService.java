package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Schedule;

import com.example.demo.repository.ScheduleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    

    @Autowired
    private ScheduleRepository scheduleRepository;


    public List<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule getSchedule(int id) {
        return scheduleRepository.findById(id).get();
    }

    public void addSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public void updateSchedule(int id, Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public void deleteSchedule(int id) {
        scheduleRepository.deleteById(id);
    }

}