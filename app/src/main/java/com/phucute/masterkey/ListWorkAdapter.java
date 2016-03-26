package com.phucute.masterkey;

import java.util.ArrayList; import android.content.Context;
import android.view.LayoutInflater; import android.view.View;
import android.view.ViewGroup; import android.widget.ArrayAdapter;
import android.widget.CheckBox; import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
/**
 * Created by whyal on 3/24/2016.
 */
public class ListWorkAdapter extends ArrayAdapter<Door> {
    ArrayList<Door> array;
    int resource;
    Context context;

    public ListWorkAdapter(Context context, int textViewResourceId,
                           ArrayList<Door> objects) {
//        super(context, textViewResourceId, objects);
        super(context, textViewResourceId, objects);
        this.context = context;
        resource = textViewResourceId;
        array = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View doorView = convertView;
        if (doorView == null) {
            doorView = new CustomViewGroup(getContext());
        }
        final Door door = array.get(position);
        if (door != null) {
            TextView doorContent = ((CustomViewGroup) doorView).doorContent;

            CheckBox checkDoor = ((CustomViewGroup) doorView).cb;

            checkDoor.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    door.setChecked(isChecked);
                }
            });

            doorContent.setText(door.getContent());

            checkDoor.setChecked(door.isChecked());
        }
        return doorView;
    }
}