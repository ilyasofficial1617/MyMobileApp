package com.yudhistira.mymobileapp.modul.TaskListViewer;

import com.yudhistira.mymobileapp.Task;
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
