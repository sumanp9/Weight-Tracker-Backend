package com.application.tracker.WeightTracker_BackEnd.dto;

import com.application.tracker.WeightTracker_BackEnd.Unit;

public class BMIDto {

    public int Weight;
    public Unit unit;

    public BMIDto() {
    }

    public BMIDto(int weight, Unit unit) {
        Weight = weight;
        this.unit = unit;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
