package com.example.onlineclothingshoppingapp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fragments.LoginFragment;
import fragments.RegisterFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_fragment;
    private Boolean status = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(MainActivity.this, ViewPagerActivity.class));

        btn_fragment = findViewById(R.id.btn_fragment);
        btn_fragment.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (status) {
            LoginFragment loginFragment = new LoginFragment();
            fragmentTransaction.replace(R.id.fragmentContainer, loginFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            btn_fragment.setText("load register fragment");
            status = false;
        } else {
            RegisterFragment registerFragment = new RegisterFragment();
            fragmentTransaction.replace(R.id.fragmentContainer, registerFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            btn_fragment.setText("Load Login Fragment");
            status = true;
        }

    }
}
