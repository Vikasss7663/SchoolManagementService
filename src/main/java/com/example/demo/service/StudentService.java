package com.example.demo.service;

import com.example.demo.dtos.CourseRegistrationDto;
import com.example.demo.dtos.StudentDto;
import com.example.demo.model.Course;
import com.example.demo.model.CourseRegistration;
import com.example.demo.model.CourseRegistrationKey;
import com.example.demo.model.Student;
import com.example.demo.repository.CourseRegistrationRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    
    private final StudentRepository studentRepository;
    private final CourseRegistrationRepository courseRegistrationRepository;
    private final CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, CourseRegistrationRepository courseRegistrationRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRegistrationRepository = courseRegistrationRepository;
        this.courseRepository = courseRepository;
    }

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
        Student student = getStudentInstanceFromDto(studentDto);
        studentRepository.save(student);
    }

    public void updateStudent(StudentDto studentDto) {
        Student student = getStudentInstanceFromDto(studentDto);
        studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentsByCourseId(String courseId) {
        return courseRegistrationRepository.findStudentsByCourseId(courseId);
    }


    private Student getStudentInstanceFromDto(StudentDto studentDto) {
        Student student = new Student();
        student.setStudentId(studentDto.getStudentId());
        student.setStudentName(studentDto.getStudentName());
        student.setStudentSemester(studentDto.getStudentSemester());
        student.setStudentYear(studentDto.getStudentYear());
        return student;
    }

}
