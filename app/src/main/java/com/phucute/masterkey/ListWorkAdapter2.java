package com.phucute.masterkey;

import java.util.ArrayList; import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup; import android.widget.ArrayAdapter;
import android.widget.CheckBox; import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
/**
 * Created by whyal on 3/24/2016.
 */
public class ListWorkAdapter2 extends ArrayAdapter<PersonName> {
    ArrayList<PersonName> array;
    int resource;
    Context context;

    public ListWorkAdapter2(Context context, int textViewResourceId,
                            ArrayList<PersonName> objects) {
//        super(context, textViewResourceId, objects);
        super(context, textViewResourceId, objects);
        this.context = context;
        resource = textViewResourceId;
        array = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View nameView = convertView;
        if (nameView == null) {
            nameView = new CustomViewGroup2(getContext());
        }
        final PersonName name = array.get(position);
        if (name != null) {
            TextView nameContent = ((CustomViewGroup2) nameView).nameContent;

            CheckBox checkName = ((CustomViewGroup2) nameView).cb2;

            checkName.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    name.setChecked(isChecked);
                }
            });

            nameContent.setText(name.getContent());

            checkName.setChecked(name.isChecked());         }
        return nameView;
    }

}