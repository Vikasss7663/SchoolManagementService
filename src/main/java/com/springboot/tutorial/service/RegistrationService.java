package com.springboot.tutorial.service;

import com.springboot.tutorial.dtos.CourseDto;
import com.springboot.tutorial.dtos.RegistrationDto;
import com.springboot.tutorial.dtos.StudentDto;
import com.springboot.tutorial.model.Course;
import com.springboot.tutorial.model.Registration;
import com.springboot.tutorial.model.Student;
import com.springboot.tutorial.repository.CourseRepository;
import com.springboot.tutorial.repository.RegistrationRepository;
import com.springboot.tutorial.repository.StudentRepository;
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
