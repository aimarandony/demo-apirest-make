package com.d4si.api.attendance.controller;

import com.d4si.api.attendance.domain.Activity;
import com.d4si.api.attendance.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ActivityRest {

    @Autowired
    ActivityService activityService;

    @GetMapping("/activities")
    private ResponseEntity<List<Activity>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(activityService.findAll());
    }

    @PostMapping("/activities")
    private ResponseEntity<Activity> create(@RequestBody Activity activity){
        return ResponseEntity.status(HttpStatus.OK).body(activityService.create(activity));
    }
}
