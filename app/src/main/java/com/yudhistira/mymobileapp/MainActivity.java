package com.yudhistira.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    CustomListAdapter listAdapter;

    ArrayList<Task> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dummy data
        tasks.add(new Task("belanja","di online shop"));
        tasks.add(new Task("belajar","android dev"));
        tasks.add(new Task("memasak","overcooked game"));
        tasks.add(new Task("belajar","android dev"));
        tasks.add(new Task("kesana kemari dan tertawa","bila saatnya tlah tiba"));

        //custom listadapter for listview
        listAdapter = new CustomListAdapter(this,tasks);
        //get listview and set the adapter
        listView = (ListView) findViewById(R.id.TaskListview);
        listView.setAdapter(listAdapter);

        //get add button
        FloatingActionButton addButton = (FloatingActionButton) findViewById(R.id.AddTaskButton);
        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivityForResult(new Intent(MainActivity.this,TaskAdder.class),0);
            }
        });
    }

    //receive input from task adder
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 0 && resultCode == RESULT_OK && data!= null){
            Task task = (Task)data.getSerializableExtra("newTask");
            tasks.add(task);
            listAdapter.notifyDataSetChanged();
        }
    }
}