package com.school.management.repository;

import com.school.management.model.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;
import java.util.List;

public interface TimeTableRepository extends JpaRepository<TimeTable, Integer> {

    @Query(value = "select c.course_id,c.course_name,l.building,l.floor,l.room,s.week_day,s.start_time,s.end_time from course as c " +
            "inner join time_table as tt on c.course_id = tt.course_id " +
            "inner join location as l on l.location_id = tt.location_id " +
            "inner join schedule as s on s.schedule_id = tt.schedule_id", nativeQuery = true)
    List<Tuple> findCourseScheduleLocation();

    @Query(value = "select c.course_id,c.course_name,l.building,l.floor,l.room,s.week_day,s.start_time,s.end_time from course as c " +
            "inner join time_table as tt on c.course_id = tt.course_id " +
            "inner join location as l on l.location_id = tt.location_id " +
            "inner join schedule as s on s.schedule_id = tt.schedule_id where c.course_id = ?1", nativeQuery = true)
    List<Tuple> findCourseScheduleLocationByCourseId(String courseId);


    @Query(value = "select c.course_id,c.course_name,l.building,l.floor,l.room,s.week_day,s.start_time,s.end_time from course as c " +
            "inner join time_table as tt on c.course_id = tt.course_id " +
            "inner join location as l on l.location_id = tt.location_id " +
            "inner join schedule as s on s.schedule_id = tt.schedule_id where l.location_id = ?1", nativeQuery = true)
    List<Tuple> findCourseScheduleLocationByLocationId(int locationId);


    @Query(value = "select c.course_id, c.course_name,l.building,l.floor,l.room,sd.week_day,sd.start_time,sd.end_time from course as c " +
            "inner join registration as r on c.course_id = r.course_id " +
            "inner join student as s on s.student_id = r.student_id " +
            "inner join time_table as tt on c.course_id = tt.course_id " +
            "inner join location as l on l.location_id = tt.location_id " +
            "inner join schedule as sd on sd.schedule_id = tt.schedule_id where s.student_id = ?1", nativeQuery = true)
    List<Tuple> findCourseScheduleLocationByStudentId(String studentId);


}