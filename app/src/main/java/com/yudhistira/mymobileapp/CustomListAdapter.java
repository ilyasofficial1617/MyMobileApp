package com.yudhistira.mymobileapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CustomListAdapter extends android.widget.ArrayAdapter {
    //reference the activity
    private final Activity context;

    //store list of taskname
    private final String[] tasksName;

    //store list of taskdetails
    private final String[] tasksDetail;

    public CustomListAdapter(Activity context, String[] tasksName, String[] tasksDetail){
        super(context, R.layout.row_listview, tasksName);
        this.context = context;
        this.tasksName = tasksName;
        this.tasksDetail = tasksDetail;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.row_listview, null, true);

        //search element in template
        TextView nameField = (TextView) rowView.findViewById(R.id.nameTextview);
        TextView detailField = (TextView) rowView.findViewById(R.id.nameTextview);

        //set value from array to field
        nameField.setText(tasksName[position]);
        detailField.setText(tasksDetail[position]);

        return rowView;
    }

}
