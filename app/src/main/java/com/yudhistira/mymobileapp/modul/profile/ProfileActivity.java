package com.yudhistira.mymobileapp.modul.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yudhistira.mymobileapp.R;
import com.yudhistira.mymobileapp.TaskEditor;
import com.yudhistira.mymobileapp.base.BaseFragmentHolderActivity;
import com.yudhistira.mymobileapp.base.Profile;
import com.yudhistira.mymobileapp.modul.login.LoginFragment;
import com.yudhistira.mymobileapp.modul.taskListViewer.TaskListActivity;

public class ProfileActivity extends BaseFragmentHolderActivity{
    ProfileFragment profileFragment;
    private final int UPDATE_REQUEST = 2019;

    @Override
    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
//        ivIcon.setImageResource(R.drawable.....);
        ivIcon.setVisibility(View.VISIBLE);

        profileFragment = new ProfileFragment();
        setCurrentFragment(profileFragment, false);
    }

    /*
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
                startActivity(new Intent(ProfileActivity.this, TaskListActivity.class));
            }
        });

    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        this.presenter = presenter;
    }
    */
}