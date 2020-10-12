package com.yudhistira.mymobileapp.modul.login;

import com.yudhistira.mymobileapp.base.BasePresenter;
import com.yudhistira.mymobileapp.base.BaseView;
import com.yudhistira.mymobileapp.base.Profile;

/**
 * Created by fahrul on 13/03/19.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void redirectToProfile(Profile profile);
    }

    interface Presenter extends BasePresenter {
        void performLogin(String username, String password);
    }
}
