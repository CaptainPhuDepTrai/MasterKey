package com.phucute.masterkey;

/**
 * Created by Windows 10 Gamer on 26/03/2016.
 */
public class Door {

    private String doorContent;

    private boolean isChecked;
    public Door(String doorContent) {
        this.doorContent = doorContent;

        isChecked = false;
    }
    public String getContent() {
        return doorContent;
    }
    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
    public boolean isChecked() {
        return isChecked;
    }
}