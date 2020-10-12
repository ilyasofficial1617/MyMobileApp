package com.yudhistira.mymobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.yudhistira.mymobileapp.base.Task;

public class TaskEditor extends AppCompatActivity {
    Task task;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_editor);


        Intent intent = getIntent();
        Task inputTask = (Task)intent.getSerializableExtra("task");
        //if it's for editing
        if(inputTask != null) {
            task = inputTask;
            ((TextInputLayout)findViewById(R.id.TaskNameInput))
                    .getEditText().setText(task.getName());
            ((TextInputLayout)findViewById(R.id.TaskDetailInput))
                    .getEditText().setText(task.getDetail());
            TextView title =  (TextView) findViewById(R.id.title_task_editor);
            title.setText("Task Editor");
            Button addButton = (Button) findViewById(R.id.AddTaskInputButton);
            addButton.setText("EDIT");
            index = intent.getIntExtra("index",0);
        } else {//add new
            task = new Task();
        }

        Button addButton = (Button) findViewById(R.id.AddTaskInputButton);
        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String name = ((TextInputLayout)findViewById(R.id.TaskNameInput))
                        .getEditText().getText().toString();
                String detail = ((TextInputLayout)findViewById(R.id.TaskDetailInput))
                        .getEditText().getText().toString();
                task.setName(name);
                task.setDetail(detail);
                Intent output = new Intent();
                output.putExtra("newTask",task);
                output.putExtra("index", index);
                setResult(RESULT_OK,output);
                finish();
            }
        });
    }
}
