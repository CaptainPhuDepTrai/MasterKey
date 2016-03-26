package com.phucute.masterkey;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
public class CustomViewGroup extends LinearLayout {
    public CheckBox cb;
    public TextView doorContent;

    public CustomViewGroup(Context context) {
        super(context);
        LayoutInflater li = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li.inflate(R.layout.list, this, true);
        cb = (CheckBox) findViewById(R.id.check_door);
        doorContent = (TextView) findViewById(R.id.door_content);

    }
}