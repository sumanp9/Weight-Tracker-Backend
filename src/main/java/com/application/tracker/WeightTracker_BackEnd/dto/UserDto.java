package com.application.tracker.WeightTracker_BackEnd.dto;

import com.application.tracker.WeightTracker_BackEnd.Role;

public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private int height;
    private Role role;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public int getHeight() {
        return height;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
