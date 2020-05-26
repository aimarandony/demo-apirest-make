package com.d4si.api.attendance.controller;

import com.d4si.api.attendance.domain.Student;
import com.d4si.api.attendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRest {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll());
    }

    @PostMapping("/students")
    public ResponseEntity<Student> create(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.create(student));
    }
}
