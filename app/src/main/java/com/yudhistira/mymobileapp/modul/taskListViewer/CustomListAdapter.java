package com.yudhistira.mymobileapp.modul.taskListViewer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.yudhistira.mymobileapp.R;
import com.yudhistira.mymobileapp.base.Task;
import com.yudhistira.mymobileapp.modul.taskEditor.TaskEditorActivity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.EventListener;

public class CustomListAdapter extends android.widget.ArrayAdapter {
    //reference the activity
    private final Activity context;

    //store list of taskname
    private final ArrayList<Task> tasks;

    //event listener
    EventListener listener;

    public interface EventListener {
        void onEventChecked(Task task);
    }

    public CustomListAdapter(Activity context,ArrayList<Task> tasks, EventListener listener){
        super(context, R.layout.row_listview, tasks);
        this.context = context;
        this.tasks = tasks;
        this.listener = listener;
    }

    public void update(ArrayList<Task> tasksInput){
        tasks.clear();
        for (int i = 0; i<tasksInput.size(); i++){
            tasks.add(tasksInput.get(i));
        }
        Log.d("pak","masuk up");
    }

    public View getView(final int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.row_listview, null, true);

        //search element in template
        TextView nameField = (TextView) rowView.findViewById(R.id.nameTextview);
        TextView detailField = (TextView) rowView.findViewById(R.id.detailsTextview);
        ToggleButton doneToggleButton = (ToggleButton) rowView.findViewById(R.id.toggleButton);

        //set value from array to list elements
        nameField.setText(tasks.get(position).getName());
        detailField.setText(tasks.get(position).getDetail());
        doneToggleButton.setChecked(tasks.get(position).isDone());

        //add onclick edit
        rowView.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Context context = v.getContext();
                        Intent intent = new Intent(context, TaskEditorActivity.class);
                        intent.putExtra("task",(Serializable)tasks.get(position));
                        Log.d("pak",tasks.get(position).getName());
                        ((Activity) context).startActivityForResult(intent,1);
                    }
                }

        );

        //add onclick toggle
        doneToggleButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Task selectedTask = tasks.get(position);
                        selectedTask.setDone( !selectedTask.isDone() );
                        listener.onEventChecked(selectedTask);
                    }
                }

        );


        return rowView;
    }



}
