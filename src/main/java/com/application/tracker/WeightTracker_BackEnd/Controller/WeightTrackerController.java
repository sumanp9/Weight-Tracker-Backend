package com.application.tracker.WeightTracker_BackEnd.Controller;


import com.application.tracker.WeightTracker_BackEnd.Unit;
import com.application.tracker.WeightTracker_BackEnd.beans.WeightData;
import com.application.tracker.WeightTracker_BackEnd.dto.BMIDto;
import com.application.tracker.WeightTracker_BackEnd.repository.UserProfileRepo;
import com.application.tracker.WeightTracker_BackEnd.repository.WeightDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class WeightTrackerController {

    @Autowired
    WeightDataRepo weightDataRepo;

    @Autowired
    UserProfileRepo userRepo;

    @RequestMapping("/getData/{id}")
    public List<WeightData> getUserData(@PathVariable(value = "id") Long id) {
        return this.weightDataRepo.findAllByUserId(id);
    }

    @GetMapping("getCurrentUserWeight/{id}")
    public WeightData getUserCurrentWeight(@PathVariable(value = "id") Long id) {

        List<WeightData> data =  this.weightDataRepo.findAllByUserId(id);
        return data.get(data.size()-1);
    }

    @RequestMapping("/trackerHello")
    public String hello() {
        return "Hello you are now in Weight Tracker";
    }

    @DeleteMapping("/deleteData/{dataId}")
    public void deleteUserDataById(@PathVariable(value = "dataId") Long dataId) {
        this.weightDataRepo.delete(this.weightDataRepo.findById(dataId).get());
    }


}
