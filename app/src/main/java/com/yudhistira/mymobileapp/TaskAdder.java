package com.yudhistira.mymobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class TaskAdder extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_adder);

        Button addButton = (Button) findViewById(R.id.AddTaskInputButton);
        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String name = ((TextInputLayout)findViewById(R.id.TaskNameInput)).getEditText().getText().toString();
                String detail = ((TextInputLayout)findViewById(R.id.TaskDetailInput)).getEditText().getText().toString();
                Task newTask = new Task(name,detail);
                Intent output = new Intent();
                output.putExtra("newTask",newTask);
                setResult(RESULT_OK,output);
                finish();
            }
        });
    }
}
