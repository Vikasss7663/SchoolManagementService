package com.springboot.tutorial.service;

import com.springboot.tutorial.dtos.CourseScheduleLocationDto;
import com.springboot.tutorial.dtos.TimeTableDto;
import com.springboot.tutorial.model.Course;
import com.springboot.tutorial.model.Location;
import com.springboot.tutorial.model.Schedule;
import com.springboot.tutorial.model.TimeTable;
import com.springboot.tutorial.repository.CourseRepository;
import com.springboot.tutorial.repository.TimeTableRepository;
import com.springboot.tutorial.repository.LocationRepository;
import com.springboot.tutorial.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeTableService {

    private final CourseRepository courseRepository;
    private final ScheduleRepository scheduleRepository;
    private final LocationRepository locationRepository;
    private final TimeTableRepository timeTableRepository;

    public void addTimeTable(TimeTableDto timeTableDto) {

        Course course = courseRepository.findById(timeTableDto.getCourseId()).get();
        Schedule schedule = scheduleRepository.findById(timeTableDto.getScheduleId()).get();
        Location location = locationRepository.findById(timeTableDto.getLocationId()).get();

        TimeTable timeTable = new TimeTable();
        timeTable.setId(timeTableDto.getId());
        timeTable.setCourse(course);
        timeTable.setSchedule(schedule);
        timeTable.setLocation(location);

        timeTableRepository.save(timeTable);
    }

    public List<CourseScheduleLocationDto> getTimeTables() {
        List<Tuple> tuples =  timeTableRepository.findCourseScheduleLocation();
        return tupleToCourseScheduleLocationList(tuples);
    }

    public List<CourseScheduleLocationDto> getTimeTableByCourseId(String courseId) {
        List<Tuple> tuples =  timeTableRepository.findCourseScheduleLocationByCourseId(courseId);
        return tupleToCourseScheduleLocationList(tuples);
    }

    public List<CourseScheduleLocationDto> getTimeTableByLocationId(int locationId) {
        List<Tuple> tuples =  timeTableRepository.findCourseScheduleLocationByLocationId(locationId);
        return tupleToCourseScheduleLocationList(tuples);
    }

    public List<CourseScheduleLocationDto> getTimeTableByStudentId(String studentId) {
        List<Tuple> tuples =  timeTableRepository.findCourseScheduleLocationByStudentId(studentId);
        return tupleToCourseScheduleLocationList(tuples);
    }

    private List<CourseScheduleLocationDto> tupleToCourseScheduleLocationList(List<Tuple> tuples) {
        List<CourseScheduleLocationDto> courseScheduleLocations = new ArrayList<>();
        for(Tuple tuple: tuples) {
            courseScheduleLocations.add(tupleToCourseScheduleLocationItem(tuple));
        }
        return courseScheduleLocations;
    }

    private CourseScheduleLocationDto tupleToCourseScheduleLocationItem(Tuple tuple) {

        CourseScheduleLocationDto courseScheduleLocationDto = new CourseScheduleLocationDto();
        courseScheduleLocationDto.setCourseId(tuple.get("course_id").toString());
        courseScheduleLocationDto.setCourseName(tuple.get("course_name").toString());
        courseScheduleLocationDto.setBuilding(tuple.get("building").toString());
        courseScheduleLocationDto.setFloor(tuple.get("floor").toString());
        courseScheduleLocationDto.setRoom(tuple.get("room").toString());
        courseScheduleLocationDto.setWeekDay(tuple.get("week_day").toString());
        courseScheduleLocationDto.setStartTime(tuple.get("start_time").toString());
        courseScheduleLocationDto.setEndTime(tuple.get("end_time").toString());

        return courseScheduleLocationDto;

    }

    public void deleteTimeTable(int timeTableId) {
        timeTableRepository.deleteById(timeTableId);

    }

}
