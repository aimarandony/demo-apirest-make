package com.d4si.api.attendance.util;

import com.d4si.api.attendance.domain.Activity;
import com.d4si.api.attendance.domain.District;
import com.d4si.api.attendance.domain.Student;
import com.d4si.api.attendance.domain.StudentAttendance;
import com.d4si.api.attendance.service.ActivityService;
import com.d4si.api.attendance.service.DistrictService;
import com.d4si.api.attendance.service.StudentAttendanceService;
import com.d4si.api.attendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class InitDatabaseUtil {

    @Autowired
    DistrictService districtService;

    @Autowired
    ActivityService activityService;

    @Autowired
    StudentService studentService;

    @Autowired
    StudentAttendanceService studentAttendanceService;

    public void init(){
        Activity activity1 = null, activity2 = null;
        District district1 = null, district2 = null;
        Student student1 = null, student2 = null;

        if (activityService.findAll().isEmpty()){
            Activity activity = new Activity();
            activity.setName("Star Kids");
            activity.setDescription("Descripción de star kids");
            activity1 = activityService.create(activity);

            activity = new Activity();
            activity.setName("Construcción");
            activity.setDescription("Descripción de la construcción.");
            activity2 = activityService.create(activity);
        }
        if (districtService.findAll().isEmpty()){
            District district = new District();
            district.setName("San Juan");
            district1 = districtService.create(district);

            district = new District();
            district.setName("Callao");
            district2 = districtService.create(district);
        }
        if (studentService.findAll().isEmpty()){
            Student student = new Student();
            student.setName("Aimar");
            student.setLastname("Berrocal");
            student.setBirthdate(new Date());
            student.setGender("M");
            student.setMail("aimar@gmail.com");
            student.setPhone("924630120");
            student.setDistrict(district1);
            student1 = studentService.create(student);

            student = new Student();
            student.setName("Jean");
            student.setLastname("Vereau");
            student.setBirthdate(new Date());
            student.setGender("M");
            student.setMail("jean@gmail.com");
            student.setPhone("959694120");
            student.setDistrict(district2);
            student2 = studentService.create(student);
        }

        if (studentAttendanceService.findAll().isEmpty()){
            StudentAttendance studentAttendance = new StudentAttendance();
            studentAttendance.setActivity(activity1);
            studentAttendance.setStudent(student1);
            studentAttendance.setArrivalTime(new Date());
            studentAttendance.setDepartureTime(new Date());
            studentAttendanceService.create(studentAttendance);

            studentAttendance = new StudentAttendance();
            studentAttendance.setActivity(activity1);
            studentAttendance.setStudent(student2);
            studentAttendance.setArrivalTime(new Date());
            studentAttendance.setDepartureTime(new Date());
            studentAttendanceService.create(studentAttendance);
        }
    }
}
