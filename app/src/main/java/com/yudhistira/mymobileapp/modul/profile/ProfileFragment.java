package com.yudhistira.mymobileapp.modul.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yudhistira.mymobileapp.R;
import com.yudhistira.mymobileapp.base.BaseFragment;
import com.yudhistira.mymobileapp.base.Profile;
import com.yudhistira.mymobileapp.modul.taskListViewer.TaskListActivity;

public class ProfileFragment extends BaseFragment<ProfileActivity, ProfileContract.Presenter> implements  ProfileContract.View{
    View layoutView;
    TextView usernameText;
    TextView passwordText;

    Button taskListButton;

    ProfileContract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setPresenter(new ProfilePresenter());
        layoutView = inflater.inflate(R.layout.activity_profile, container, false);


        this.usernameText = layoutView.findViewById(R.id.UsernameText);
        this.passwordText = layoutView.findViewById(R.id.PasswordText);
        this.taskListButton = layoutView.findViewById(R.id.taskListButton);

        Intent intent = getActivity().getIntent();
        Profile profile  = (Profile) intent.getSerializableExtra("profile");

        usernameText.setText( profile.getName() );
        passwordText.setText( profile.getPassword() );

        taskListButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                getActivity().startActivity(new Intent(getActivity(), TaskListActivity.class));
            }
        });
        return layoutView;
    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
