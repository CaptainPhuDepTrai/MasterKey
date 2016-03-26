package com.phucute.masterkey;

public class Time {

    private String timeContent;

    private boolean isChecked;
    public Time(String doorContent) {
        this.timeContent = timeContent;

        isChecked = false;
    }
    public String getContent() {
        return timeContent;
    }
    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
    public boolean isChecked() {
        return isChecked;
    }
}
