package com.yudhistira.mymobileapp.modul.taskEditor;

import android.content.Context;
import android.util.Log;

import com.yudhistira.mymobileapp.base.Task;
import com.yudhistira.mymobileapp.modul.repository.DatabaseHelper;
import com.yudhistira.mymobileapp.modul.taskListViewer.CustomListAdapter;
import com.yudhistira.mymobileapp.modul.taskListViewer.TaskListContract;

import java.util.ArrayList;

public class TaskEditorPresenter  implements TaskEditorContract.Presenter{
    private TaskEditorContract.View view;
    DatabaseHelper dbHelper;
    private Task task;

    public TaskEditorPresenter(TaskEditorContract.View view, Context context, Task task){
        this.view = view;
        dbHelper = new DatabaseHelper(context);
        this.task = task;
    }

    @Override
    public void start() {
        if(task!=null){
            view.viewTask(this.task.getName(), this.task.getDetail());
        }
    }

    @Override
    public void save(String name, String detail) {
        //if create new
        if(task == null){
            Task newTask = new Task(name, detail);
            dbHelper.insertTask(newTask);
        } else {
            Log.d("pak","id="+String.valueOf(task.getId()));
            task.setName(name);
            task.setDetail(detail);
            dbHelper.updateTask(task);
        }
    }

    @Override
    public void deleteTask() {
        if(task != null){
            dbHelper.deleteTask(task);
        }
    }
}
