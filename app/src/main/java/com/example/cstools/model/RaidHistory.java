package com.example.cstools.model;

public class RaidHistory {
    private String key;
    private String raidType;
    private String driveCapacity;
    private String driveCost;
    private String drivesPerRaid;
    private String raidGroup;


    public RaidHistory() {
    }

    public RaidHistory(String raidType, String driveCapacity, String driveCost, String drivesPerRaid, String raidGroup) {
        this.raidType = raidType;
        this.driveCapacity = driveCapacity;
        this.driveCost = driveCost;
        this.drivesPerRaid = drivesPerRaid;
        this.raidGroup = raidGroup;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRaidType() {
        return raidType;
    }

    public void setRaidType(String raidType) {
        this.raidType = raidType;
    }

    public String getDriveCapacity() {
        return driveCapacity;
    }

    public void setDriveCapacity(String driveCapacity) {
        this.driveCapacity = driveCapacity;
    }

    public String getDriveCost() {
        return driveCost;
    }

    public void setDriveCost(String driveCost) {
        this.driveCost = driveCost;
    }

    public String getDrivesPerRaid() {
        return drivesPerRaid;
    }

    public void setDrivesPerRaid(String drivesPerRaid) {
        this.drivesPerRaid = drivesPerRaid;
    }

    public String getRaidGroup() {
        return raidGroup;
    }

    public void setRaidGroup(String raidGroup) {
        this.raidGroup = raidGroup;
    }

    @Override
    public String toString() {
        return "RaidHistory{" +
                ", raidType=" + raidType +
                ", driveCapacity='" + driveCapacity + '\'' +
                ", driveCost=" + driveCost +
                ", drivesPerRaid=" + drivesPerRaid +
                ", raidGroup=" + raidGroup +
                '}';
    }
}