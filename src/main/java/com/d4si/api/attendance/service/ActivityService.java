package com.d4si.api.attendance.service;

import com.d4si.api.attendance.domain.Activity;
import com.d4si.api.attendance.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    public List<Activity> findAll(){
        return activityRepository.findAll();
    }

    public Activity create(Activity activity){
        if (activity.getName().isEmpty() || activity.getName() == null){
            throw new RuntimeException();
        }
        return activityRepository.save(activity);
    }
}
