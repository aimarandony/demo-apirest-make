package com.d4si.api.attendance.service;

import com.d4si.api.attendance.domain.District;
import com.d4si.api.attendance.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    @Autowired
    DistrictRepository districtRepository;

    public List<District> findAll(){
        return districtRepository.findAll();
    }

    public District create(District district){
        if (district.getName().isEmpty() || district.getName() == null){
            throw new RuntimeException();
        }
        return districtRepository.save(district);
    }
}
