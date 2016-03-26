package com.phucute.masterkey;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.VoiceInteractor;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by whyal on 3/22/2016.
 */
public class MainMenu extends Activity {
    private static final int DELETE_WORK = Menu.FIRST;
    private static final int OPEN = Menu.FIRST + 2;
    private static final int CLOSE = Menu.FIRST + 4;
    private static final int SETTING = Menu.FIRST + 6;

    public final static ArrayList<Door> array = new ArrayList<Door>();
    ListWorkAdapter arrayAdapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        // Set up the login form.

        arrayAdapter = new ListWorkAdapter(this,
                R.layout.list, array);

        final ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(arrayAdapter);




        Button CameraButton = (Button) findViewById(R.id.buttonCamera);
        Button OpionButton = (Button) findViewById(R.id.optionButton);
        OpionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOptionsMenu();
            }
        });
        CameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doOpenChildActivity();
            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, DELETE_WORK, 0,"Delete" ).setIcon(android.R.drawable.ic_delete);
        menu.add(0, OPEN, 0,"Open" ).setIcon(android.R.drawable.ic_menu_info_details);
        menu.add(0, CLOSE, 0,"Close" ).setIcon(android.R.drawable.ic_menu_info_details);
        menu.add(0, SETTING, 0,"Setting" ).setIcon(android.R.drawable.ic_menu_info_details);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case DELETE_WORK: {
                deleteCheckedWork();
                break;
            }
            case OPEN: {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                String result = "";
                for (int i = 0; i < array.size(); i++) {
                    if(array.get(i).isChecked())
                        result += array.get(i).getContent();
                    result += "\n";
                }
                builder.setTitle(result);
                builder.setMessage("DOORS OPENED");
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.setIcon(android.R.drawable.ic_dialog_info);
                builder.show();
                break;
            }
            case CLOSE: {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                String result = "";
                for (int i = 0; i < array.size(); i++) {
                    if(array.get(i).isChecked())
                        result += array.get(i).getContent();
                    result += " ";
                }
                builder.setTitle(result);
                builder.setMessage("DOORS CLOSED");
                builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.setIcon(android.R.drawable.ic_dialog_info);
                builder.show();
                break;
            }
            case SETTING: {
                Intent intent = new Intent(this, DoorSetting.class);
                String result ="";
                for (int i = 0; i < array.size(); i++) {
                    if(array.get(i).isChecked())
                        result += array.get(i).getContent();

                }
                Bundle bundle= new Bundle();
                bundle.putString("name",result);
                intent.putExtra("GoiTin", bundle);
                startActivity(intent);
            }

        }
        return true;
    }


    private void deleteCheckedWork() {
        if (array.size() > 0) {
            for (int i = 0; i < array.size(); i++) {
                if (i > array.size()) {
                    break;
                }
                if (array.get(i).isChecked()) {
                    array.remove(i);
                    arrayAdapter.notifyDataSetChanged();
                    i--;
                    continue;
                }
            }
        }
    }



    public void doOpenChildActivity()
    {
        Intent myIntent=new Intent(this, UseCamera.class);
        startActivity(myIntent);
    }
}