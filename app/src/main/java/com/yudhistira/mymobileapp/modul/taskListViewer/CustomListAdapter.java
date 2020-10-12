package com.yudhistira.mymobileapp.modul.taskListViewer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.yudhistira.mymobileapp.R;
import com.yudhistira.mymobileapp.base.Task;
import com.yudhistira.mymobileapp.TaskEditor;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomListAdapter extends android.widget.ArrayAdapter {
    //reference the activity
    private final Activity context;

    //store list of taskname
    private final ArrayList<Task> tasks;

    public CustomListAdapter(Activity context,ArrayList<Task> tasks){
        super(context, R.layout.row_listview, tasks);
        this.context = context;
        this.tasks = tasks;
    }

    public View getView(final int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.row_listview, null, true);

        //search element in template
        TextView nameField = (TextView) rowView.findViewById(R.id.nameTextview);
        TextView detailField = (TextView) rowView.findViewById(R.id.detailsTextview);
        ImageButton deleteButton = (ImageButton) rowView.findViewById(R.id.DeleteButton);

        //set value from array to list elements
        nameField.setText(tasks.get(position).getName());
        detailField.setText(tasks.get(position).getDetail());
        //add onclick delete
        deleteButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        tasks.remove(position);
                        CustomListAdapter.this.notifyDataSetChanged();
                    }
                }

        );
        //add onclick edit
        rowView.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Context context = v.getContext();
                        Intent intent = new Intent(context, TaskEditor.class);
                        intent.putExtra("task",(Serializable)tasks.get(position));
                        intent.putExtra("index",position);
                        ((Activity) context).startActivityForResult(intent,1);
                        CustomListAdapter.this.notifyDataSetChanged();
                    }
                }

        );


        return rowView;
    }



}
