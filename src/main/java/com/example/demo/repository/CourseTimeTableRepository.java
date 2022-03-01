package com.example.demo.repository;

import com.example.demo.dtos.CourseScheduleLocationDto;
import com.example.demo.model.CourseTimeTable;
import com.example.demo.model.CourseTimeTableKey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;
import java.util.List;

public interface CourseTimeTableRepository extends JpaRepository<CourseTimeTable, CourseTimeTableKey> {

    @Query(value = "select c.course_id,c.course_name,l.building,l.floor,l.room,s.week_day,s.start_time,s.end_time from course as c " +
            "inner join course_time_table as ctt on c.course_id = ctt.course_id " +
            "inner join location as l on l.location_id = ctt.location_id " +
            "inner join schedule as s on s.schedule_id = ctt.schedule_id", nativeQuery = true)
    List<Tuple> findCourseScheduleLocation();

}