package com.yudhistira.mymobileapp.modul.taskEditor;

import com.yudhistira.mymobileapp.base.BasePresenter;
import com.yudhistira.mymobileapp.base.BaseView;
import com.yudhistira.mymobileapp.base.Profile;

public interface TaskEditorContract {
    interface View extends BaseView<Presenter> {
        void viewTask(String name, String detail);
    }

    interface Presenter extends BasePresenter {
        void save(String name, String detail);
        void deleteTask();
    }
}
