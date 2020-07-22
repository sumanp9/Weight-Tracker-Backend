package com.application.tracker.WeightTracker_BackEnd.beans;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private int height;


    //Added JsonManagedReference to resolve infinite recursion issue.
    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<WeightData> weightData;

    public User() {
    }

    public User(String firstName, String lastName, String emailId, String password, int height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.height = height;
        this.password = password;
    }

    public Long getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Set<WeightData> getWeightData() {
        return weightData;
    }

    public void setWeightData(Set<WeightData> weightData) {
        this.weightData = weightData;
    }
}
