package com.example.demo.service;

import java.util.*;

import com.example.demo.dtos.CourseDto;
import com.example.demo.dtos.CourseRegistrationDto;
import com.example.demo.dtos.CourseScheduleLocationDto;
import com.example.demo.dtos.CourseTimeTableDto;
import com.example.demo.model.*;
import com.example.demo.repository.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final CourseRegistrationRepository courseRegistrationRepository;
    private final CourseTimeTableRepository courseTimeTableRepository;
    private final ScheduleRepository scheduleRepository;
    private final LocationRepository locationRepository;

    public CourseService(CourseRepository courseRepository, CourseRegistrationRepository courseRegistrationRepository, CourseTimeTableRepository courseTimeTableRepository, StudentRepository studentRepository, LocationRepository locationRepository, ScheduleRepository scheduleRepository) {
        this.courseRepository = courseRepository;
        this.courseRegistrationRepository = courseRegistrationRepository;
        this.courseTimeTableRepository = courseTimeTableRepository;
        this.studentRepository = studentRepository;
        this.locationRepository = locationRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public List<Course> getCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses;
    }

    public List<Course> getCoursesBySemester(int semester) {
        return courseRepository.findBycourseSemester(semester);
    }

    public Course getCourse(String id) {
        Course dummyCourse = new Course();
        return courseRepository.findById(id).orElse(dummyCourse);
    }

    public void addCourse(CourseDto courseDto) {
        Course course = getCourseInstanceFromDto(courseDto);
        courseRepository.save(course);
    }

    public void updateCourse(CourseDto courseDto) {
        Course course = getCourseInstanceFromDto(courseDto);
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }

    public List<Course> getCoursesByStudentId(String studentId) {
        return courseRegistrationRepository.findCoursesByStudentId(studentId);
    }

    public void addStudent(CourseRegistrationDto courseRegistrationDto) {

        Course course = courseRepository.findById(courseRegistrationDto.getCourseId()).get();
        Student student = studentRepository.findById(courseRegistrationDto.getStudentId()).get();

        CourseRegistrationKey courseRegistrationKey = new CourseRegistrationKey();
        courseRegistrationKey.setCourseId(courseRegistrationDto.getCourseId());
        courseRegistrationKey.setStudentId(courseRegistrationDto.getStudentId());

        CourseRegistration courseRegistration = new CourseRegistration();
        courseRegistration.setCourseRegistrationKey(courseRegistrationKey);
        courseRegistration.setCourse(course);
        courseRegistration.setStudent(student);

        courseRegistrationRepository.save(courseRegistration);
    }

    private Course getCourseInstanceFromDto(CourseDto courseDto) {
        Course course = new Course();
        course.setCourseId(courseDto.getCourseId());
        course.setCourseName(courseDto.getCourseName());
        course.setCourseSemester(courseDto.getCourseSemester());
        return course;
    }

    public void addTimeTable(CourseTimeTableDto courseTimeTableDto) {

        Course course = courseRepository.findById(courseTimeTableDto.getCourseId()).get();
        Schedule schedule = scheduleRepository.findById(courseTimeTableDto.getScheduleId()).get();
        Location location = locationRepository.findById(courseTimeTableDto.getLocationId()).get();

        CourseTimeTableKey courseTimeTableKey = new CourseTimeTableKey();
        courseTimeTableKey.setCourseId(courseTimeTableDto.getCourseId());
        courseTimeTableKey.setScheduleId(courseTimeTableDto.getScheduleId());
        courseTimeTableKey.setLocationId(courseTimeTableDto.getLocationId());

        CourseTimeTable courseTimeTable = new CourseTimeTable();
        courseTimeTable.setCourseTimeTableKey(courseTimeTableKey);
        courseTimeTable.setCourse(course);
        courseTimeTable.setSchedule(schedule);
        courseTimeTable.setLocation(location);

        courseTimeTableRepository.save(courseTimeTable);
    }


    public List<CourseScheduleLocationDto> getCourseScheduleLocation() {

        List<CourseScheduleLocationDto> courseScheduleLocations = new ArrayList<>();
        List<Tuple> tuples =  courseTimeTableRepository.findCourseScheduleLocation();

        for(Tuple tuple: tuples) {
            courseScheduleLocations.add(extractCourseScheduleLocationFromTuple(tuple));
        }

        return courseScheduleLocations;
    }

    private CourseScheduleLocationDto extractCourseScheduleLocationFromTuple(Tuple tuple) {

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
}
