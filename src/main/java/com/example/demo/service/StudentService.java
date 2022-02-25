package com.example.demo.service;

import com.example.demo.repository.StudentCourseRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.model.Student;
import com.example.demo.model.StudentCourse;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsBySemester(int semester) {
        return studentRepository.findStudentsBySemester(semester);
    }

    public List<Student> getStudentsByYear(int year) {
        return studentRepository.findStudentsByYear(year);
    }

    public Student getStudent(String id) {
        return studentRepository.findById(id).get();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(int id, Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentsByCourseId(String courseId) {
        return studentCourseRepository.findStudentsByCourseId(courseId);
    }

    public void addCourse(StudentCourse studentCourse) {
        studentCourseRepository.save(studentCourse);
    }

}
