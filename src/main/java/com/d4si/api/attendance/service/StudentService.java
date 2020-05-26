package com.d4si.api.attendance.service;

import com.d4si.api.attendance.domain.Student;
import com.d4si.api.attendance.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student create(Student student){
        return studentRepository.save(student);
    }
}
