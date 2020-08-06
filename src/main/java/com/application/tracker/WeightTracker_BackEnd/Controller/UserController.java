package com.application.tracker.WeightTracker_BackEnd.Controller;


import com.application.tracker.WeightTracker_BackEnd.Role;
import com.application.tracker.WeightTracker_BackEnd.beans.AdminUserData;
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
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/getAllUsers")
    public List<AdminUserData> getAllUsers(){
        List<AdminUserData> users =  new ArrayList<>();
        this.userRepo.findAll().forEach(user -> {
            AdminUserData adminUserData = new AdminUserData();
            adminUserData.setId(user.getId());
            adminUserData.setfName(user.getFirstName());
            adminUserData.setlName(user.getLastName());
            adminUserData.setEmail(user.getEmailId());
            adminUserData.setRole(user.getRole());
            users.add(adminUserData);
        });
        return users;
    }

    @PostMapping("/login/{emailId}")
    public User login(@PathVariable(value = "emailId") String email, @RequestBody String password) {
        User user =  userRepo.findByEmailId(email);
        if (user.getEmailId().equals(email) && user.getPassword().equals(password)) {
            return user;
        }
        else {
            throw new NullPointerException("User email or/and password are incorrect!");
        }
    }

    @PostMapping("/registerUser")
    public User registerUser(@RequestBody UserDto userDto) {

        System.out.println("Here in register User");
        System.out.println(userDto.getFirstName());

        //List<User> user = userRepo.find
        User user = userRepo.findByEmailId(userDto.getEmailId());
        if (user == null) {
            User newUser =  new User();
            newUser.setFirstName(userDto.getFirstName());
            newUser.setLastName(userDto.getLastName());
            newUser.setEmailId(userDto.getEmailId());
            newUser.setHeight(userDto.getHeight());
            newUser.setPassword(userDto.getPassword());
            if (userDto.getRole().toString().isEmpty()) {
                newUser.setRole(Role.User.toString());
            } else {
                newUser.setRole(userDto.getRole().toString());
            }
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
            User user = userRepo.findById(id).get();
            System.out.println("The users data is : "+ weightDto.getWeight() + weightDto.getUnit()+ weightDto.getDate());
            if(weightDto.getId() == null) {
                WeightData weightData = new WeightData();
                weightData.setUnit(weightDto.getUnit().toString());
                weightData.setWeight(weightDto.getWeight());
                weightData.setUser(user);
                //Converting date from string format to java.util.date then java.sql.date
                weightData.setDate(convertDate(weightDto.getDate()));

                weightRepo.save(weightData);
            } else{
                WeightData existingData = weightRepo.findById(weightDto.getId()).get();
                existingData.setUnit(weightDto.getUnit().toString());
                existingData.setWeight(weightDto.getWeight());
                existingData.setDate(convertDate(weightDto.getDate()));
                weightRepo.save(existingData);
            }
        } else {
            throw new NullPointerException("not user found");
        }
    }

    @DeleteMapping("/user/delete/id/{id}")
    public void deleteUser(@PathVariable(value = "id") Long id) {
        if (this.userRepo.findById(id) != null ) {
            this.weightRepo.findAllByUserId(id).forEach(data -> {
                this.weightRepo.delete(data);
            });
            this.userRepo.delete(this.userRepo.findById(id).get());
        } else {
            throw new NullPointerException("Unable to find user with id "+ id);
        }
    }

    @PostMapping("/user/update")
    public void updateUser(@RequestBody AdminUserData adminUserData) {
        if (adminUserData != null) {
            User user = this.userRepo.findById(adminUserData.getId()).get();
            user.setFirstName(adminUserData.getfName());
            user.setLastName(adminUserData.getlName());
            user.setRole(adminUserData.getRole());
            user.setEmailId(adminUserData.getEmail());
            this.userRepo.save(user);
        } else {
            throw  new NullPointerException("Unable to find the user");
        }
    }

    private Date convertDate(String date) throws ParseException {

        System.out.println(date);
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
