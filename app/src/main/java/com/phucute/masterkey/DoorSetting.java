package com.phucute.masterkey;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Windows 10 Gamer on 26/03/2016.
 */
public class DoorSetting extends Activity {
    public final static ArrayList<PersonName> array = new ArrayList<PersonName>();
    public static final ArrayList<String>  tick = new ArrayList<String>() ;
    ListWorkAdapter2 arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.door_permission);
        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("GoiTin");


        final String a = bundle.getString("name");
        TextView doorname = (TextView)findViewById(R.id.doorsName);
        doorname.setText(a);
        arrayAdapter = new ListWorkAdapter2(this,
                R.layout.list2, array);
        final ListView list = (ListView) findViewById(R.id.listNames);
        list.setAdapter(arrayAdapter);
        Button plus = (Button) findViewById(R.id.buttonplus);
        final EditText person = (EditText)findViewById(R.id.persons);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (person.getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(DoorSetting.this);
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
                    String person_name = person.getText().toString();

                    PersonName name2 = new PersonName(person_name);
                    array.add(0, name2);

                    person.setText("");
                }

            }
        });



        Button OptionName = (Button) findViewById(R.id.OptionName);
        OptionName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < array.size(); i++) {
                    if (array.get(i).isChecked()) {
                        tick.add(array.get(i).getContent());

                        changed(a);

                    }
                }


            }
        });






    }
    public void changed(String a){
        Intent intent = new Intent(this, SetTime.class);
        Bundle bundle= new Bundle();
        bundle.putString("name",a);
        intent.putExtra("GoiTin", bundle);
        startActivity(intent);
    }
}