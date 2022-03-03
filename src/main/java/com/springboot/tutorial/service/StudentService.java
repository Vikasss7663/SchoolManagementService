package com.springboot.tutorial.service;

import com.springboot.tutorial.dtos.StudentDto;
import com.springboot.tutorial.model.Student;
import com.springboot.tutorial.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    
    private final StudentRepository studentRepository;

    public List<StudentDto> getStudents() {
        List<StudentDto> studentDtos = new ArrayList<>();
        studentRepository.findAll().forEach(it -> studentDtos.add(getStudentDtoInstance(it)));
        return studentDtos;
    }

    public List<StudentDto> getStudentsBySemester(int semester) {
        List<StudentDto> studentDtos = new ArrayList<>();
        studentRepository.findBystudentSemester(semester).forEach(it -> studentDtos.add(getStudentDtoInstance(it)));
        return studentDtos;
    }

    public List<StudentDto> getStudentsByYear(int year) {
        List<StudentDto> studentDtos = new ArrayList<>();
        studentRepository.findBystudentYear(year).forEach(it -> studentDtos.add(getStudentDtoInstance(it)));
        return studentDtos;
    }

    public StudentDto getStudent(String id) {
        return getStudentDtoInstance(studentRepository.findById(id).get());
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

    private StudentDto getStudentDtoInstance(Student student) {
        if(student == null) return new StudentDto();
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(student.getStudentId());
        studentDto.setStudentName(student.getStudentName());
        studentDto.setStudentSemester(student.getStudentSemester());
        studentDto.setStudentYear(student.getStudentYear());
        return studentDto;
    }

}
