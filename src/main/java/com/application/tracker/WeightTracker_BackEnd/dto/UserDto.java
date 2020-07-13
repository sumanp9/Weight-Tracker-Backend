package com.application.tracker.WeightTracker_BackEnd.dto;

public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private int height;

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

    public int getHeight() {
        return height;
    }
}
