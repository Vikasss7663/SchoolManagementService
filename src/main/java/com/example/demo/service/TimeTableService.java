package com.example.demo.service;

import com.example.demo.dtos.CourseScheduleLocationDto;
import com.example.demo.dtos.TimeTableDto;
import com.example.demo.model.*;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.TimeTableRepository;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeTableService {

    private final CourseRepository courseRepository;
    private final ScheduleRepository scheduleRepository;
    private final LocationRepository locationRepository;
    private final TimeTableRepository timeTableRepository;

    public TimeTableService(CourseRepository courseRepository, ScheduleRepository scheduleRepository, LocationRepository locationRepository, TimeTableRepository timeTableRepository) {
        this.courseRepository = courseRepository;
        this.scheduleRepository = scheduleRepository;
        this.locationRepository = locationRepository;
        this.timeTableRepository = timeTableRepository;
    }

    public void addTimeTable(TimeTableDto timeTableDto) {

        Course course = courseRepository.findById(timeTableDto.getCourseId()).get();
        Schedule schedule = scheduleRepository.findById(timeTableDto.getScheduleId()).get();
        Location location = locationRepository.findById(timeTableDto.getLocationId()).get();

        TimeTableKey timeTableKey = new TimeTableKey();
        timeTableKey.setCourseId(timeTableDto.getCourseId());
        timeTableKey.setScheduleId(timeTableDto.getScheduleId());
        timeTableKey.setLocationId(timeTableDto.getLocationId());

        TimeTable timeTable = new TimeTable();
        timeTable.setCourseTimeTableKey(timeTableKey);
        timeTable.setCourse(course);
        timeTable.setSchedule(schedule);
        timeTable.setLocation(location);

        timeTableRepository.save(timeTable);
    }

    public List<CourseScheduleLocationDto> getCourseScheduleLocations() {
        List<Tuple> tuples =  timeTableRepository.findCourseScheduleLocation();
        return tupleToCourseScheduleLocationList(tuples);
    }

    public List<CourseScheduleLocationDto> getCourseScheduleLocationsByCourseId(String courseId) {
        List<Tuple> tuples =  timeTableRepository.findCourseScheduleLocationByCourseId(courseId);
        return tupleToCourseScheduleLocationList(tuples);
    }

    public List<CourseScheduleLocationDto> getCourseScheduleLocationsByLocationId(int locationId) {
        List<Tuple> tuples =  timeTableRepository.findCourseScheduleLocationByLocationId(locationId);
        return tupleToCourseScheduleLocationList(tuples);
    }

    public List<CourseScheduleLocationDto> getCourseScheduleLocationsByStudentId(String studentId) {
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

    public void deleteTimeTable(TimeTableDto timeTableDto) {

        TimeTableKey timeTableKey = new TimeTableKey();
        timeTableKey.setCourseId(timeTableDto.getCourseId());
        timeTableKey.setScheduleId(timeTableDto.getScheduleId());
        timeTableKey.setLocationId(timeTableDto.getLocationId());

        timeTableRepository.deleteById(timeTableKey);

    }

}
