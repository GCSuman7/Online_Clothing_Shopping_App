package com.example.onlineclothingshoppingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import adapter.ItemsAdapter;
import model.Items;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnAddItems;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.recyclerView);

//        List<Items> itemsList = new ArrayList<>();
//        itemsList.add(new Items("Shirt", "1100", R.drawable.tshirt));
//        itemsList.add(new Items("sandal", "500", R.drawable.sandal));
//        itemsList.add(new Items("Shoes", "500", R.drawable.shoes));

        List<Items> itemsList = new ArrayList<>();
        try {
            FileInputStream fis = openFileInput("items.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null){
                String[] parts = line.split("->");
                String image = parts[2];
                int id= getResources().getIdentifier(image, "drawable", getPackageName());
                itemsList.add(new Items(parts[0], parts[1], id, parts[3]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ItemsAdapter itemsAdapter = new ItemsAdapter(this,itemsList);
        recyclerView.setAdapter(itemsAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        btnAddItems = findViewById(R.id.btnAddItems);
        btnAddItems.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      switch (v.getId()){
          case R.id.btnAddItems:

              Intent intent=new Intent(DashboardActivity.this,AddItemActivity.class);
              startActivity(intent);
              break;
      }
    }
}
