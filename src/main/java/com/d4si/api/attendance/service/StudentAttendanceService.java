package com.d4si.api.attendance.service;

import com.d4si.api.attendance.domain.StudentAttendance;
import com.d4si.api.attendance.repository.StudentAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAttendanceService {

    @Autowired
    StudentAttendanceRepository studentAttendanceRepository;

    public List<StudentAttendance> findAll(){
        return studentAttendanceRepository.findAll();
    }

    public StudentAttendance create(StudentAttendance studentAttendance){
        return studentAttendanceRepository.save(studentAttendance);
    }
}
