package com.yudhistira.mymobileapp.modul.taskListViewer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.yudhistira.mymobileapp.R;
import com.yudhistira.mymobileapp.base.BaseFragment;
import com.yudhistira.mymobileapp.base.Profile;
import com.yudhistira.mymobileapp.base.Task;
import com.yudhistira.mymobileapp.modul.login.LoginActivity;
import com.yudhistira.mymobileapp.modul.login.LoginContract;
import com.yudhistira.mymobileapp.modul.taskEditor.TaskEditorActivity;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class TaskListFragment extends BaseFragment<TaskListActivity, TaskListContract.Presenter> implements TaskListContract.View, CustomListAdapter.EventListener{

    TaskListContract.Presenter presenter;
    ListView listView;
    CustomListAdapter listAdapter;
    View layoutView;
    FloatingActionButton addButton;
    FloatingActionButton shareButton;
    Profile profile;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setPresenter(new TaskListPresenter(this,getContext()));
        layoutView = inflater.inflate(R.layout.task_list_view, container, false);

        listView = (ListView) layoutView.findViewById(R.id.TaskListview);

        Intent intent = getActivity().getIntent();
        profile  = (Profile) intent.getSerializableExtra("profile");
        setTitle("Hello "+profile.getName());

        //get add button
        addButton = (FloatingActionButton) layoutView.findViewById(R.id.AddTaskButton);
        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                redirectToTaskEditor();
            }
        });
        //get share button
        shareButton = (FloatingActionButton) layoutView.findViewById(R.id.ShareTasksButton);
        shareButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                share();
            }
        });

        listAdapter = new CustomListAdapter(getActivity(),new ArrayList<Task>(),this);
        listView.setAdapter(listAdapter);

        presenter.start();

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
    public void updateContentList(ArrayList<Task> list) {
        listAdapter.update(list);
        listAdapter.notifyDataSetChanged();
        Log.d("pak","masuk update");
    }

    public void redirectToTaskEditor() {
        Intent intent = new Intent(getActivity(), TaskEditorActivity.class);
        getActivity().startActivityForResult(intent,0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        presenter.start();
    }

    public void share(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "TaskList "+profile.getName()+"\n\n"+
                presenter.getSummary());
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }

    @Override
    public void onEventChecked(Task task) {
        presenter.update(task);
        presenter.start();
        Log.d("pak","masok on event checked");
    }
}