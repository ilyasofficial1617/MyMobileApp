package com.yudhistira.mymobileapp.modul.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.yudhistira.mymobileapp.R;
import com.yudhistira.mymobileapp.base.BaseFragment;
import com.yudhistira.mymobileapp.base.Profile;
import com.yudhistira.mymobileapp.modul.taskListViewer.TaskListActivity;
import com.yudhistira.mymobileapp.modul.taskListViewer.TaskListPresenter;

public class LoginFragment extends BaseFragment<LoginActivity, LoginContract.Presenter> implements LoginContract.View {

    LoginContract.Presenter presenter;

    View layoutView;

    Button loginButton;
    TextInputLayout usernameField;
    TextInputLayout passwordField;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setPresenter(new LoginPresenter(this));
        layoutView = inflater.inflate(R.layout.activity_login, container, false);

        loginButton = layoutView.findViewById(R.id.LoginButton);
        usernameField = layoutView.findViewById(R.id.TextInputUsername);
        passwordField = layoutView.findViewById(R.id.TextInputPassword);

        presenter.start();

        loginButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameField.getEditText().getText().toString();
                String password = passwordField.getEditText().getText().toString();
                presenter.performLogin(username,password);
            }
        });

        setTitle("Login");

        return layoutView;
    }

    @Override
    public void redirectToTaskList(Profile profile) {
        Intent intent = new Intent(getActivity(), TaskListActivity.class);
        intent.putExtra("profile",profile);
        getActivity().startActivity(intent);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }
}