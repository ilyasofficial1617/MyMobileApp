package com.yudhistira.mymobileapp.modul.taskListViewer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yudhistira.mymobileapp.R;
import com.yudhistira.mymobileapp.base.Task;
import com.yudhistira.mymobileapp.TaskEditor;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class TaskListView extends Fragment implements TaskListContract.View{

    TaskListContract.Presenter presenter;
    ListView listView;
    CustomListAdapter listAdapter;
    View layoutView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setPresenter(new TaskListPresenter(this));
        layoutView = inflater.inflate(R.layout.task_list_view, container, false);

        listView = (ListView) layoutView.findViewById(R.id.TaskListview);
        presenter.start();

        //get add button
        FloatingActionButton addButton = (FloatingActionButton) layoutView.findViewById(R.id.AddTaskButton);
        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivityForResult(new Intent(getActivity(), TaskEditor.class),0);
            }
        });

        return layoutView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //
    }

    @Override
    public void setPresenter(TaskListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setupContentList(ArrayList<Task> list) {
        //custom listadapter for listview
        listAdapter = new CustomListAdapter(getActivity(),list);
        listView.setAdapter(listAdapter);
    }

    //receive input from task adder
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        Task task = (Task)data.getSerializableExtra("newTask");
        if(resultCode == RESULT_OK && data!= null){
            if(requestCode == 0){
                presenter.add(task);
            } else if(requestCode == 1){
                int index = data.getIntExtra("index",0);
                presenter.add(task);
            }

        }
        listAdapter.notifyDataSetChanged();
    }
}