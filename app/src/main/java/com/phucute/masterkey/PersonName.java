package com.phucute.masterkey;

public class PersonName {
    private String nameContent;

    private boolean isChecked;
    public PersonName(String nameContent) {
        this.nameContent = nameContent;

        isChecked = false;
    }
    public String getContent() {
        return nameContent;
    }
    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
    public boolean isChecked() {
        return isChecked;
    }
}
