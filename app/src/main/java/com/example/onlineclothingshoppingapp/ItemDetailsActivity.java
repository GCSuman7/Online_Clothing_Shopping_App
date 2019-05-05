package com.example.onlineclothingshoppingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemDetailsActivity extends AppCompatActivity {
    CircleImageView circImg;
    TextView Name, Price, Description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_item_details);

        circImg = findViewById(R.id.circImg);
        Name = findViewById(R.id.Name);
        Price = findViewById(R.id.Price);
        Description = findViewById(R.id.Description);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            circImg.setImageResource(bundle.getInt("image"));
            Name.setText(bundle.getString("name"));
            Price.setText(bundle.getString("price"));
            Description.setText(bundle.getString("description"));
        }

    }
}
