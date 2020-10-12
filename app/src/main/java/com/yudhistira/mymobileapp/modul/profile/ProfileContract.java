package com.yudhistira.mymobileapp.modul.profile;

import com.yudhistira.mymobileapp.base.BasePresenter;
import com.yudhistira.mymobileapp.base.BaseView;
import com.yudhistira.mymobileapp.base.Profile;

public interface ProfileContract {
    interface View extends BaseView<ProfileContract.Presenter> {
    }

    interface Presenter extends BasePresenter {
    }
}
