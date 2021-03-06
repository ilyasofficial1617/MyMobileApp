package com.yudhistira.mymobileapp.modul.taskListViewer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yudhistira.mymobileapp.R;
import com.yudhistira.mymobileapp.base.BaseFragmentHolderActivity;
import com.yudhistira.mymobileapp.modul.login.LoginFragment;

public class TaskListActivity extends BaseFragmentHolderActivity {
    TaskListFragment taskListFragment;

    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.VISIBLE);

        taskListFragment = new TaskListFragment();
        setCurrentFragment(taskListFragment, false);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        taskListFragment.onActivityResult(requestCode, resultCode, data);
    }
}