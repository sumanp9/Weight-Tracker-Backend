package com.application.tracker.WeightTracker_BackEnd.beans;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "userprofile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Double height;

    //One to Many relation between userprofile and weightTrack.
    //One Person can have many Weight Tracking for each day
    @OneToMany (mappedBy = "userprofile",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<WeightTrack> weightData;

    public UserProfile() {
    }

    public UserProfile(String firstName, String lastName, String email, Double height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Double getHeight() {
        return height;
    }

    public List<WeightTrack> getWeightData() {
        return weightData;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "FirstName: "+ getFirstName()+
                " Last Name: "+ getLastName()+
                " Email Id: "+ getEmail()+
                " Height: "+ getHeight();
    }
}
