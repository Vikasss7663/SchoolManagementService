package com.example.demo.service;

import com.example.demo.model.CourseRegistrationKey;
import com.example.demo.dtos.CourseRegistrationDto;
import com.example.demo.dtos.StudentDto;
import com.example.demo.repository.CourseRegistrationRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.model.Student;
import com.example.demo.model.CourseRegistration;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsBySemester(int semester) {
        return studentRepository.findBystudentSemester(semester);
    }

    public List<Student> getStudentsByYear(int year) {
        return studentRepository.findBystudentYear(year);
    }

    public Student getStudent(String id) {
        return studentRepository.findById(id).get();
    }

    public void addStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setStudentId(UUID.randomUUID());
        student.setStudentName(studentDto.getStudentName());

        studentRepository.save(student);
    }

    public void updateStudent(int id, Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentsByCourseId(String courseId) {
        return courseRegistrationRepository.findStudentsByCourseId(courseId);
    }

    public void addCourse(CourseRegistrationDto courseRegistrationDto) {
        CourseRegistrationKey courseRegistrationKey = new CourseRegistrationKey(courseRegistrationDto.getStudentId(), courseRegistrationDto.getCourseId());

        CourseRegistration courseRegistration = new CourseRegistration();
        courseRegistration.setCourseRegistrationKey(courseRegistrationKey);

        courseRegistrationRepository.save(courseRegistration);
    }

}
