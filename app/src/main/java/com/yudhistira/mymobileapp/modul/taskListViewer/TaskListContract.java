package com.yudhistira.mymobileapp.modul.taskListViewer;

import com.yudhistira.mymobileapp.base.Task;
import com.yudhistira.mymobileapp.base.BasePresenter;
import com.yudhistira.mymobileapp.base.BaseView;

import java.util.ArrayList;

public interface TaskListContract {
    interface View extends BaseView<Presenter> {
        public void setupContentList(ArrayList<Task> list);
    }
    interface Presenter extends BasePresenter {
        public void add(Task task);
        public void replace(Task task, int index);
    }
}
