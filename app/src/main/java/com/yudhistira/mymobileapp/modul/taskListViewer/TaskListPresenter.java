package com.yudhistira.mymobileapp.modul.taskListViewer;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.yudhistira.mymobileapp.base.Task;
import com.yudhistira.mymobileapp.modul.repository.DatabaseHelper;

import java.util.ArrayList;

public class TaskListPresenter implements TaskListContract.Presenter {
    private final TaskListContract.View view;
    DatabaseHelper dbHelper;

    CustomListAdapter listAdapter;
    ArrayList<Task> tasks;

    public TaskListPresenter(TaskListContract.View view, Context context){
        this.view = view;
        dbHelper = new DatabaseHelper(context);
    }

    @Override
    public void start() {
        tasks = dbHelper.getAllTask();
        view.updateContentList(tasks);

    }


    @Override
    public String getSummary() {
        String result = "";
        for(int i = 0; i<tasks.size(); i++){
            result+=tasks.get(i).getName();
            result+="\n";
            result+=tasks.get(i).getDetail();
            result+="\n";
            result+="\n";
        }
        return result;
    }

    @Override
    public void update(Task task) {
        dbHelper.updateTask(task);
    }
}
