package com.example.cstools.model;
public class Number {
    private String key;
    private String type;
    private String number;
    private String value1;
    private String value2;
    private String value3;
    private String value4;

    public Number(){ }
    public Number(String type, String number, String value1, String value2, String value3, String value4) {
        this.type = type;
        this.number = number;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getValue1() {
        return value1;
    }
    public void setValue1(String value1) {
        this.value1 = value1;
    }
    public String getValue2() {
        return value2;
    }
    public void setValue2(String value2) {
        this.value2 = value2;
    }
    public String getValue3() {
        return value3;
    }
    public void setValue3(String value3) {
        this.value3 = value3;
    }
    public String getValue4() {
        return value4;
    }
    public void setValue4(String value4) {
        this.value4 = value4;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    @Override
    public String toString() {
        return "Number{" +
                ", type=" + type +
                ", number='" + number + '\'' +
                ", value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                ", value3='" + value3 + '\'' +
                ", value4='" + value4 + '\'' +
                '}';
    }
}
