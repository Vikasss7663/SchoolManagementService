package com.example.demo.service;

import com.example.demo.dtos.RegistrationDto;
import com.example.demo.model.Course;
import com.example.demo.model.Registration;
import com.example.demo.model.RegistrationKey;
import com.example.demo.model.Student;
import com.example.demo.repository.RegistrationRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final RegistrationRepository registrationRepository;


    public RegistrationService(CourseRepository courseRepository, StudentRepository studentRepository, RegistrationRepository registrationRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.registrationRepository = registrationRepository;
    }

    public List<Course> getCoursesByStudentId(String studentId) {
        return registrationRepository.findCoursesByStudentId(studentId);
    }

    public List<Student> getStudentsByCourseId(String courseId) {
        return registrationRepository.findStudentsByCourseId(courseId);
    }

    public void addStudent(RegistrationDto registrationDto) {

        Course course = courseRepository.findById(registrationDto.getCourseId()).get();
        Student student = studentRepository.findById(registrationDto.getStudentId()).get();

        RegistrationKey registrationKey = new RegistrationKey();
        registrationKey.setCourseId(registrationDto.getCourseId());
        registrationKey.setStudentId(registrationDto.getStudentId());

        Registration registration = new Registration();
        registration.setRegistrationKey(registrationKey);
        registration.setCourse(course);
        registration.setStudent(student);

        registrationRepository.save(registration);
    }

}
