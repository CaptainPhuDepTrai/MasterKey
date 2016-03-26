package com.phucute.masterkey;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
public class CustomViewGroup2 extends LinearLayout {
    public CheckBox cb2;
    public TextView nameContent;

    public CustomViewGroup2(Context context) {
        super(context);
        LayoutInflater li2 = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        li2.inflate(R.layout.list2, this, true);
        cb2 = (CheckBox) findViewById(R.id.check_name);
        nameContent = (TextView) findViewById(R.id.name_content);


    }
}