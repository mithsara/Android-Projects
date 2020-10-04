package com.example.cstools;

public class DTCal {
    private String conType;
    private double speed;
    private String key;

    public DTCal(String Type, double Speed){
        conType = Type;
        speed = Speed;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getConType() {
        return conType;
    }

    public double getSpeed() {
        return speed;
    }
}
