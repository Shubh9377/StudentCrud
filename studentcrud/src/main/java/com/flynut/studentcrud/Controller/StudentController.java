package com.flynut.studentcrud.Controller;

import com.flynut.studentcrud.entity.Student;
import com.flynut.studentcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student){
        try{
            return  ResponseEntity.ok(studentService.updatStudent(id, student));
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String > deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student Deleted Successfully");
    }
}
