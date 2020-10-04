package com.example.cstools;

public class DTCal {
    private String conType;
    private double speed;

    public DTCal(String Type, double Speed){
        conType = Type;
        speed = Speed;
    }

    public String getConType() {
        return conType;
    }

    public double getSpeed() {
        return speed;
    }
}
