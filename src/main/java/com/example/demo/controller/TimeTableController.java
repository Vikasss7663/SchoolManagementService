package com.example.demo.controller;

import com.example.demo.dtos.CourseScheduleLocationDto;
import com.example.demo.dtos.TimeTableDto;
import com.example.demo.service.TimeTableService;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timetable")
public class TimeTableController {

    private final TimeTableService service;

    public TimeTableController(TimeTableService service) {
        this.service = service;
    }

    // GET ( Get Course Schedule Location )
    @GetMapping
    public List<CourseScheduleLocationDto> getCourseScheduleLocations() {
        return service.getCourseScheduleLocations();
    }

    // GET ( Get Course Schedule Location by Course ID )
    @GetMapping(value = "course/{id}")
    public List<CourseScheduleLocationDto> getCourseScheduleLocationsByCourseId(@NonNull @PathVariable String id) {
        return service.getCourseScheduleLocationsByCourseId(id);
    }

    // GET ( Get Course Schedule Location by Course ID )
    @GetMapping(value = "location/{id}")
    public List<CourseScheduleLocationDto> getCourseScheduleLocationsByLocationId(@PathVariable int id) {
        return service.getCourseScheduleLocationsByLocationId(id);
    }

    // GET ( Get Course Schedule Location by Course ID )
    @GetMapping(value = "student/{id}")
    public List<CourseScheduleLocationDto> getCourseScheduleLocationsByStudentId(@NonNull @PathVariable String id) {
        return service.getCourseScheduleLocationsByStudentId(id);
    }

    // POST ( Add Time Table )
    @PostMapping
    public void addTimeTable(@NonNull @RequestBody TimeTableDto timeTableDto) {
        service.addTimeTable(timeTableDto);
    }

    // PUT ( Update Time Table )
    @PutMapping
    public void updateTimeTable(@NonNull @RequestBody TimeTableDto timeTableDto) {
        service.addTimeTable(timeTableDto);
    }

    // DELETE ( Delete Time Table )
    @DeleteMapping
    public void deleteTimeTable(@NonNull @RequestBody TimeTableDto timeTableDto) {
        service.deleteTimeTable(timeTableDto);
    }

}
