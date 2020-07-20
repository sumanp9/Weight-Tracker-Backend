package com.application.tracker.WeightTracker_BackEnd.dto;

import com.application.tracker.WeightTracker_BackEnd.Unit;

public class WeightDto {

    private Long id;
    private String date;
    private int weight;
    private Unit unit;

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
