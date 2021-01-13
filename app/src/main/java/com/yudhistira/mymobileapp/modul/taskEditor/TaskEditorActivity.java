package com.yudhistira.mymobileapp.modul.taskEditor;

import android.content.Intent;
import android.view.View;

import androidx.annotation.Nullable;

import com.yudhistira.mymobileapp.base.BaseFragmentHolderActivity;
import com.yudhistira.mymobileapp.modul.login.LoginFragment;

public class TaskEditorActivity extends BaseFragmentHolderActivity {
    private final int UPDATE_REQUEST = 2019;
    TaskEditorFragment taskEditorFragment;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);

        ivIcon.setVisibility(View.VISIBLE);

        taskEditorFragment = new TaskEditorFragment();
        setCurrentFragment(taskEditorFragment, true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
