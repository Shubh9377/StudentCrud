package com.flynut.studentcrud.service;

import com.flynut.studentcrud.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student addStudent(Student student);

    List<Student> getAllStudents();

    Optional<Student> getStudentById(int id);

    Student updatStudent(int id, Student student);

    void deleteStudent(int id);
}
