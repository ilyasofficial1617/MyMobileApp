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
    private final Task[] tasks;

    public CustomListAdapter(Activity context,Task[] tasks){
        super(context, R.layout.row_listview, tasks);
        this.context = context;
        this.tasks = tasks;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.row_listview, null, true);

        //search element in template
        TextView nameField = (TextView) rowView.findViewById(R.id.nameTextview);
        TextView detailField = (TextView) rowView.findViewById(R.id.detailsTextview);

        //set value from array to field
        nameField.setText(tasks[position].getName());
        detailField.setText(tasks[position].getDetail());

        return rowView;
    }

}
