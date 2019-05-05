package com.example.onlineclothingshoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class AddItemActivity extends AppCompatActivity {
    EditText ItemName, ItemPrice, ItemImageName, ItemDescription;
    Button btnAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_item);

        ItemName = findViewById(R.id.ItemName);
        ItemPrice = findViewById(R.id.ItemPrice);
        ItemImageName = findViewById(R.id.ItemImageName);
        ItemDescription = findViewById(R.id.ItemDescription);
        btnAddItem = findViewById(R.id.btnAddItem);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveItem();
            }
        });
    }

    private void SaveItem() {
        try {
            PrintStream printStream = new PrintStream(openFileOutput("items.txt", MODE_PRIVATE | MODE_APPEND));
            printStream.println(ItemName.getText().toString() + "->" + ItemPrice.getText().toString() + "->"
                    + ItemImageName.getText().toString() + "->" + ItemDescription.getText().toString());
            Toast.makeText(this, "Item Added Successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(AddItemActivity.this, DashboardActivity.class));
        } catch (IOException e) {
            Log.d("Online Shopping App", "Error" + e.toString());
            e.printStackTrace();
        }
    }
}
