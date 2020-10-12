package com.yudhistira.mymobileapp.modul.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yudhistira.mymobileapp.R;
import com.yudhistira.mymobileapp.TaskEditor;
import com.yudhistira.mymobileapp.base.Profile;
import com.yudhistira.mymobileapp.modul.taskListViewer.TaskListActivity;

public class ProfileActivity extends AppCompatActivity implements ProfileContract.View{

    TextView usernameText;
    TextView passwordText;

    Button taskListButton;

    ProfileContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        this.usernameText = findViewById(R.id.UsernameText);
        this.passwordText = findViewById(R.id.PasswordText);
        this.taskListButton = findViewById(R.id.taskListButton);

        Intent intent = getIntent();
        Profile profile  = (Profile) intent.getSerializableExtra("profile");

        usernameText.setText( profile.getName() );
        passwordText.setText( profile.getPassword() );

        taskListButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivityForResult(new Intent(ProfileActivity.this, TaskListActivity.class),0);
            }
        });

    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        this.presenter = presenter;
    }
}