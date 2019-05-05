package com.example.onlineclothingshoppingapp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import fragments.LoginFragment;
import fragments.RegisterFragment;

public class ItemDetailsActivity extends AppCompatActivity {
    CircleImageView circImg;
    TextView tvname, tvprice, tvdescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_item_details);

        circImg = findViewById(R.id.circImg);
        tvname = findViewById(R.id.Name);
        tvprice = findViewById(R.id.Price);
        tvdescription = findViewById(R.id.Description);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            circImg.setImageResource(bundle.getInt("image"));
            tvname.setText(bundle.getString("name"));
            tvprice.setText(bundle.getString("price"));
            tvdescription.setText(bundle.getString("description"));
        }

    }

    public static class MainActivity extends AppCompatActivity implements View.OnClickListener {
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
}
