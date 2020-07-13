package com.application.tracker.WeightTracker_BackEnd.Controller;


import com.application.tracker.WeightTracker_BackEnd.Unit;
import com.application.tracker.WeightTracker_BackEnd.beans.User;
import com.application.tracker.WeightTracker_BackEnd.beans.WeightData;
import com.application.tracker.WeightTracker_BackEnd.dto.UserDto;
import com.application.tracker.WeightTracker_BackEnd.dto.WeightDto;
import com.application.tracker.WeightTracker_BackEnd.repository.UserProfileRepo;
import com.application.tracker.WeightTracker_BackEnd.repository.WeightDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserProfileRepo userRepo;

    @Autowired
    private WeightDataRepo weightRepo;


    @GetMapping("/")
    public String homePage() {
        return "<h1>Welcome to back end of weight tracking application";
    }

    @GetMapping("/login/{emailId}")
    public User login(@PathVariable(value = "emailId") String email) {
        System.out.println("The email address is : "+ email);
        User user =  userRepo.findByEmailId(email);
        System.out.println("The user's first name is: "+ user.getFirstName());
        return user;
    }

    @PostMapping("/registerUser")
    public User registerUser(@RequestBody UserDto userDto) {

        System.out.println("Here in register User");
        System.out.println(userDto.getFirstName());

        //List<User> user = userRepo.find
        User user = login(userDto.getEmailId());
        if (user == null) {
            User newUser =  new User();
            newUser.setFirstName(userDto.getFirstName());
            newUser.setLastName(userDto.getLastName());
            newUser.setEmailId(userDto.getEmailId());
            newUser.setHeight(userDto.getHeight());
            user =  newUser;
            userRepo.save(newUser);
        } else {
            throw new NullPointerException("User with that email id does not exist!");
        }
        return user; // error here, always returns null

    }

    @PostMapping("/addWeightData/{id}")
    public void addUserWeightData(@PathVariable(value = "id") Long id, @RequestBody WeightDto weightDto) throws ParseException {
        if (validateUser(id)) {
            User user =  userRepo.findById(id).get();
            WeightData weightData = new WeightData();
            weightData.setUnit(weightDto.getUnit().toString() );
            weightData.setWeight(weightDto.getWeight());
            weightData.setUser(user);
            //Converting date from string format to java.util.date then java.sql.date
            weightData.setDate(convertDate(weightDto.getDate()));

            weightRepo.save(weightData);
        } else {
            throw new NullPointerException("not user found");
        }
    }

    private Date convertDate(String date) throws ParseException {
        String DATE_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        SimpleDateFormat format =  new SimpleDateFormat(DATE_FORMAT_PATTERN);
        java.util.Date parsedDate = format.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
        return sqlDate;
    }

    private boolean validateUser(Long id) {
        this.userRepo.findById(id).get();
        return true;
    }

}
