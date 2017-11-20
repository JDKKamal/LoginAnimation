package com.jdkgroup.loginanimation.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.jdkgroup.loginanimation.R;
import com.jdkgroup.loginanimation.fragment.DashboardFragment;
import com.jdkgroup.loginanimation.fragment.LoginFragment;

public class MainActivity extends AppCompatActivity {
    private Fragment frag_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        frag_login = new DashboardFragment();
        //frag_login = new LoginFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, frag_login).commit();
    }
}
