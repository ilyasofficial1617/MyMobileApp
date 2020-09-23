package com.yudhistira.mymobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.nio.channels.FileLock;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    //dummy data
    Task[] tasks = {
            new Task("belanja","di online shop"),
            new Task("memasak","overcooked game"),
            new Task("belajar","android dev"),
            new Task("bermain","counter strike global offensive"),
            new Task("kesana kemari dan tertawa","bila saatnya tlah tiba")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //custom listadapter for listview
        CustomListAdapter listAdapter = new CustomListAdapter(this,tasks);
        //get listview and set the adapter
        listView = (ListView) findViewById(R.id.TaskListview);
        listView.setAdapter(listAdapter);

        //get add button
        FloatingActionButton addButton = (FloatingActionButton) findViewById(R.id.AddButton);
        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,TaskAdder.class));
            }
        });
    }
}