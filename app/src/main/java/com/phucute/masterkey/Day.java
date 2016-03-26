package com.phucute.masterkey;

public class Day {

    private String weekday;
    private String time;
    private boolean isChecked;
    public Day(String weekday,String time) {
        this.weekday = weekday;
        this.time = time;


    }
    public String getWeekday() {
        return weekday;
    }
    public String getTime() {
        return time;
    }


}