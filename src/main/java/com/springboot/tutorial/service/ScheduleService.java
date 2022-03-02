package com.springboot.tutorial.service;

import java.util.List;

import com.springboot.tutorial.dtos.ScheduleDto;
import com.springboot.tutorial.model.Schedule;

import com.springboot.tutorial.repository.ScheduleRepository;

import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule getSchedule(int id) {
        return scheduleRepository.findById(id).get();
    }

    public void addSchedule(ScheduleDto scheduleDto) {
        Schedule schedule = getScheduleInstanceFromDto(scheduleDto);
        scheduleRepository.save(schedule);
    }

    public void updateSchedule(ScheduleDto scheduleDto) {
        Schedule schedule = getScheduleInstanceFromDto(scheduleDto);
        scheduleRepository.save(schedule);
    }

    public void deleteSchedule(int id) {
        scheduleRepository.deleteById(id);
    }

    private Schedule getScheduleInstanceFromDto(ScheduleDto scheduleDto) {
        Schedule schedule = new Schedule();
        schedule.setScheduleId(scheduleDto.getScheduleId());
        schedule.setStartTime(scheduleDto.getStartTime());
        schedule.setEndTime(scheduleDto.getEndTime());
        schedule.setWeekDay(scheduleDto.getWeekDay());
        return schedule;
    }

}