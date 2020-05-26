package com.d4si.api.attendance.config;

import com.d4si.api.attendance.util.InitDatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PopulateConfig {

    @Autowired
    InitDatabaseUtil initDatabaseUtil;

    @PostConstruct
    public void populateDatabase(){
        initDatabaseUtil.init();
    }
}