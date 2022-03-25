package com.school.management.service;

import com.school.management.dtos.CourseDto;
import com.school.management.dtos.RegistrationDto;
import com.school.management.dtos.StudentDto;
import com.school.management.model.Registration;
import com.school.management.repository.CourseRepository;
import com.school.management.repository.RegistrationRepository;
import com.school.management.repository.StudentRepository;
import com.school.management.model.Course;
import com.school.management.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final RegistrationRepository registrationRepository;

    public List<CourseDto> getCoursesByStudentId(String studentId) {
        List<Tuple> tuples = registrationRepository.findCoursesByStudentId(studentId);
        return tupleToCourseList(tuples);
    }

    public List<StudentDto> getStudentsByCourseId(String courseId) {
        List<Tuple> tuples =  registrationRepository.findStudentsByCourseId(courseId);
        return tupleToStudentList(tuples);
    }

    public void addStudent(RegistrationDto registrationDto) {

        Course course = courseRepository.findById(registrationDto.getCourseId()).get();
        Student student = studentRepository.findById(registrationDto.getStudentId()).get();

        Registration registration = new Registration();
        registration.setId(registration.getId());
        registration.setCourse(course);
        registration.setStudent(student);

        registrationRepository.save(registration);
    }

    private List<CourseDto> tupleToCourseList(List<Tuple> tuples) {
        List<CourseDto> courseDtos = new ArrayList<>();
        for(Tuple tuple: tuples) {
            courseDtos.add(tupleToCourseItem(tuple));
        }
        return courseDtos;
    }

    private CourseDto tupleToCourseItem(Tuple tuple) {
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseId((int)tuple.get("course_id"));
        courseDto.setCourseName(tuple.get("course_name").toString());
        courseDto.setCourseSemester((int)tuple.get("course_semester"));
        return courseDto;
    }

    private List<StudentDto> tupleToStudentList(List<Tuple> tuples) {
        List<StudentDto> studentDtos = new ArrayList<>();
        for(Tuple tuple: tuples) {
            studentDtos.add(tupleToStudentItem(tuple));
        }
        return studentDtos;
    }

    private StudentDto tupleToStudentItem(Tuple tuple) {
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId((int)tuple.get("student_id"));
        studentDto.setStudentName(tuple.get("student_name").toString());
        studentDto.setStudentSemester((int)tuple.get("student_semester"));
        studentDto.setStudentYear((int)tuple.get("student_year"));
        return studentDto;
    }

}
