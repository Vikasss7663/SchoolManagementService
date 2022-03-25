package com.school.management.service;

import java.util.ArrayList;
import java.util.List;

import com.school.management.dtos.ScheduleDto;
import com.school.management.repository.ScheduleRepository;
import com.school.management.model.Schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public List<ScheduleDto> getSchedules() {
        List<ScheduleDto> scheduleDtos = new ArrayList<>();
        scheduleRepository.findAll().forEach(it -> scheduleDtos.add(getScheduleDtoInstance(it)));
        return scheduleDtos;
    }

    public ScheduleDto getSchedule(int id) {
        return getScheduleDtoInstance(scheduleRepository.findById(id).get());
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

    private ScheduleDto getScheduleDtoInstance(Schedule schedule) {
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setScheduleId(schedule.getScheduleId());
        scheduleDto.setStartTime(schedule.getStartTime());
        scheduleDto.setEndTime(schedule.getEndTime());
        scheduleDto.setWeekDay(schedule.getWeekDay());
        return scheduleDto;
    }

}