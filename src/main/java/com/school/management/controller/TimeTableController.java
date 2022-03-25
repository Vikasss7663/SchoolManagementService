package com.school.management.controller;

import com.school.management.dtos.CourseScheduleLocationDto;
import com.school.management.dtos.TimeTableDto;
import com.school.management.service.TimeTableService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.school.management.constants.ApplicationConstants.CROSS_ORIGIN_URL;

@CrossOrigin(origins = CROSS_ORIGIN_URL)
@RestController
@RequestMapping("/timetable")
@RequiredArgsConstructor
public class TimeTableController {

    private final TimeTableService service;

    // GET ( Get Course Schedule Location )
    @GetMapping
    public List<CourseScheduleLocationDto> getTimeTables() {
        return service.getTimeTables();
    }

    // GET ( Get Course Schedule Location by Course ID )
    @GetMapping(value = "course/{id}")
    public List<CourseScheduleLocationDto> getTimeTableByCourseId(@NonNull @PathVariable String id) {
        return service.getTimeTableByCourseId(id);
    }

    // GET ( Get Course Schedule Location by Course ID )
    @GetMapping(value = "location/{id}")
    public List<CourseScheduleLocationDto> getTimeTableByLocationId(@PathVariable int id) {
        return service.getTimeTableByLocationId(id);
    }

    // GET ( Get Course Schedule Location by Course ID )
    @GetMapping(value = "student/{id}")
    public List<CourseScheduleLocationDto> getTimeTableByStudentId(@NonNull @PathVariable String id) {
        return service.getTimeTableByStudentId(id);
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
    @DeleteMapping(value = "{id}")
    public void deleteTimeTable(@PathVariable int id) {
        service.deleteTimeTable(id);
    }

}
