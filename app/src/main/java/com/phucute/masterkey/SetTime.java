package com.phucute.masterkey;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Windows 10 Gamer on 26/03/2016.
 */
public class SetTime extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b);
        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("GoiTin");


        final String a = bundle.getString("name");

        final CheckBox monday = (CheckBox)findViewById(R.id.monday);
        final CheckBox tueday = (CheckBox)findViewById(R.id.tuesday);
        final CheckBox thursday = (CheckBox)findViewById(R.id.thursday);
        final CheckBox wednesday = (CheckBox)findViewById(R.id.wednesday);
        final CheckBox friday = (CheckBox)findViewById(R.id.friday);
        final CheckBox saturday = (CheckBox)findViewById(R.id.saturday);
        final CheckBox sunday = (CheckBox)findViewById(R.id.sunday);








        final EditText hourEdit = (EditText) findViewById(R.id.hour_edit);
        final EditText minuteEdit = (EditText) findViewById(R.id.minute_edit);
        final EditText hourEdit2 = (EditText) findViewById(R.id.hour_edit2);
        final EditText minuteEdit2 = (EditText) findViewById(R.id.minute_edit2);


        final Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hourEdit.getText().toString().equals("") || minuteEdit.getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SetTime.this);
                    builder.setTitle("Info missing");
                    builder.setMessage("Please enter all information of the work");
                    builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                        }
                    });
                    builder.show();
                }
                else {
                    ArrayList <Day> mang = new ArrayList<Day>();
                    String h =hourEdit.getText().toString()+minuteEdit.getText().toString()
                            +"*"+hourEdit2.getText().toString()+minuteEdit2.getText().toString();
                    if (monday.isChecked()) {
                        for (String each :
                                DoorSetting.tick) {

                            String tamp = monday.getText().toString();
                            mang.add(new Day(tamp, h));
                        }
                    }
                    if (tueday.isChecked()) {
                        for (String each :
                                DoorSetting.tick) {

                            String tamp = tueday.getText().toString();
                            mang.add(new Day(tamp, h));
                        }
                    }
                    if (thursday.isChecked()) {
                        for (String each :
                                DoorSetting.tick) {

                            String tamp = thursday.getText().toString();
                            mang.add(new Day(tamp, h));
                        }
                    }
                    if (wednesday.isChecked()) {
                        for (String each :
                                DoorSetting.tick) {

                            String tamp = wednesday.getText().toString();
                            mang.add(new Day(tamp, h));
                        }
                    }
                    if (friday.isChecked()) {
                        for (String each :
                                DoorSetting.tick) {

                            String tamp = friday.getText().toString();
                            mang.add(new Day(tamp, h));
                        }
                    }
                    if (saturday.isChecked()) {
                        for (String each :
                                DoorSetting.tick) {

                            String tamp = saturday.getText().toString();
                            mang.add(new Day(tamp, h));
                        }
                    }
                    if (sunday.isChecked()) {
                        for (String each :
                                DoorSetting.tick) {

                            String tamp = sunday.getText().toString();
                            mang.add(new Day(tamp, h));
                        }
                    }
//                    for (int i = 0; i < array.size(); i++) {
//                        if (array.get(i).isChecked()) {
//                            for (String each:
//                                 DoorSetting.tick) {
//
//                               String tamp = array.get(i).getContent().toString();
//                               mang.add(new Day(tamp,h));
//                            }
//                        }
//                    }
                    for (String var:
                            DoorSetting.tick) {
                        PersonDatabase.hs.put(var,mang);


                    }
                    DoorInformation.hs.put(a, DoorSetting.tick);
                    DoorSetting.tick.clear();
                    thongbao();

                }
            }
        });




    }
    public void thongbao(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm");
        builder.setMessage("SAVED");
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.setIcon(android.R.drawable.ic_dialog_info);
        builder.show();
    }
}