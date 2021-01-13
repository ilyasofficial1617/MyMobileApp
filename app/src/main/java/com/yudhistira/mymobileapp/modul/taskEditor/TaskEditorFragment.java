package com.yudhistira.mymobileapp.modul.taskEditor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.yudhistira.mymobileapp.R;
import com.yudhistira.mymobileapp.base.BaseFragment;
import com.yudhistira.mymobileapp.base.Profile;
import com.yudhistira.mymobileapp.base.Task;
import com.yudhistira.mymobileapp.modul.taskListViewer.CustomListAdapter;
import com.yudhistira.mymobileapp.modul.taskListViewer.TaskListContract;
import com.yudhistira.mymobileapp.modul.taskListViewer.TaskListPresenter;

public class TaskEditorFragment extends BaseFragment<TaskEditorActivity, TaskEditorContract.Presenter> implements TaskEditorContract.View{

    TaskEditorContract.Presenter presenter;
    View layoutView;

    Button deleteButton;
    Button saveButton;
    TextInputLayout nameField;
    TextInputLayout detailField;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        Task task = (Task) intent.getSerializableExtra("task");

        setPresenter(new TaskEditorPresenter(this,getContext(),task));
        layoutView = inflater.inflate(R.layout.task_editor, container, false);

        nameField =  layoutView.findViewById(R.id.TaskNameInput);
        detailField =  layoutView.findViewById(R.id.TaskDetailInput);
        saveButton = layoutView.findViewById(R.id.SaveTaskInputButton);
        saveButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String name = nameField.getEditText().getText().toString();
                String detail = detailField.getEditText().getText().toString();
                presenter.save(name, detail);
                Intent output = new Intent();
                getActivity().setResult(Activity.RESULT_OK,output);
                getActivity().finish();
            }
        });
        deleteButton = layoutView.findViewById(R.id.DeleteTaskInputButton);
        deleteButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                presenter.deleteTask();
                Intent output = new Intent();
                getActivity().setResult(Activity.RESULT_OK,output);
                getActivity().finish();
            }
        });
        if(task==null){
            deleteButton.setVisibility(View.GONE);
        }

        setTitle("Add Task");

        this.presenter.start();

        return layoutView;
    }

    @Override
    public void setPresenter(TaskEditorContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void viewTask(String name, String detail) {
        nameField.getEditText().setText(name);
        detailField.getEditText().setText(detail);
        setTitle("Edit Task");
    }


}
