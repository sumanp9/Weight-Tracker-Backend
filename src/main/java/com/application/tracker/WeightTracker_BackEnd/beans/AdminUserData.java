package com.application.tracker.WeightTracker_BackEnd.beans;

public class AdminUserData {
    private Long id;
    private String fName;
    private String lName;
    private String email;
    private String role;


    public AdminUserData() {
    }

    public AdminUserData(String fName, String lName, String email, String role) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
