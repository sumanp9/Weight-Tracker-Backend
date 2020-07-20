package com.application.tracker.WeightTracker_BackEnd.beans;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class WeightData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;
    private int weight;
    private String unit;


    // Added JsonBackReference to resolve infinite recursion issue
    @ManyToOne
    @JsonBackReference
    private User user;

    public WeightData() {
    }

    public WeightData(Date date, int weight, String unit, User user) {
        this.date = date;
        this.weight = weight;
        this.unit = unit;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "WeightData{" +
                "id=" + id +
                ", date=" + date +
                ", weight=" + weight +
                ", unit='" + unit + '\'' +
                ", user=" + user +
                '}';
    }
}
