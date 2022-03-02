package com.springboot.tutorial.service;

import com.springboot.tutorial.dtos.StudentDto;
import com.springboot.tutorial.model.Student;
import com.springboot.tutorial.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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


    private Student getStudentInstanceFromDto(StudentDto studentDto) {
        Student student = new Student();
        student.setStudentId(studentDto.getStudentId());
        student.setStudentName(studentDto.getStudentName());
        student.setStudentSemester(studentDto.getStudentSemester());
        student.setStudentYear(studentDto.getStudentYear());
        return student;
    }

}
