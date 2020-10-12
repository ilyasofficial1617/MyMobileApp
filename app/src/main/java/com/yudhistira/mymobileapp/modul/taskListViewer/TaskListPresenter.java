package com.yudhistira.mymobileapp.modul.taskListViewer;

import com.yudhistira.mymobileapp.base.Task;

import java.util.ArrayList;

public class TaskListPresenter implements TaskListContract.Presenter {
    private final TaskListContract.View view;

    CustomListAdapter listAdapter;
    ArrayList<Task> tasks = new ArrayList<>();

    public TaskListPresenter(TaskListContract.View view){
        this.view = view;
        //dummy data
        tasks.add(new Task("belanja","di online shop"));
        tasks.add(new Task("belajar","android dev"));
        tasks.add(new Task("memasak","overcooked game"));
        tasks.add(new Task("belajar","android dev"));
        tasks.add(new Task("kesana kemari dan tertawa","bila saatnya tlah tiba"));
    }

    @Override
    public void start() {
        view.setupContentList(tasks);
    }

    @Override
    public void add(Task task) {
        this.tasks.add(task);
    }

    @Override
    public void replace(Task task, int index) {
        this.tasks.set(index,task);
    }
}
