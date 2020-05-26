package com.d4si.api.attendance.controller;

import com.d4si.api.attendance.domain.StudentAttendance;
import com.d4si.api.attendance.service.StudentAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentAttendanceRest {

    @Autowired
    StudentAttendanceService studentAttendanceService;

    @GetMapping("/studentsAttendance")
    public ResponseEntity<List<StudentAttendance>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(studentAttendanceService.findAll());
    }

    @PostMapping("/studentsAttendance")
    public ResponseEntity<StudentAttendance> create(@RequestBody StudentAttendance studentAttendance){
        return ResponseEntity.status(HttpStatus.OK).body(studentAttendanceService.create(studentAttendance));
    }
}
