package com.application.tracker.WeightTracker_BackEnd.beans;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String emailId;
    private int height;

    @OneToMany(mappedBy = "user_profile")
    private Set<WeightData> weightData;

    public UserProfile() {
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
