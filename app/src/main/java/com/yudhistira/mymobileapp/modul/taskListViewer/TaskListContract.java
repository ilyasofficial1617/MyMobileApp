package com.yudhistira.mymobileapp.modul.taskListViewer;

import com.yudhistira.mymobileapp.base.Task;
import com.yudhistira.mymobileapp.base.BasePresenter;
import com.yudhistira.mymobileapp.base.BaseView;

import java.util.ArrayList;

public interface TaskListContract {
    interface View extends BaseView<Presenter> {
        public void updateContentList(ArrayList<Task> list);
    }
    interface Presenter extends BasePresenter {
        public String getSummary();
        public void update(Task task);
    }
}
