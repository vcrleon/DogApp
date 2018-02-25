package com.example.c4q.dogapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.c4q.dogapp.model.DogImage;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DogsActivity extends AppCompatActivity {
    RecyclerView dogRV;
    DogsAdapter dogsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogs);

//        dogRV = findViewById(R.id.dogs_rv);
//
//        String dogInfo = getIntent().getStringExtra("Dog_Info");
//        //de-serializing -- changing the String back to an object
//        Gson gson = new Gson();
//        DogImage dog = gson.fromJson(dogInfo, DogImage.class);
//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
//        dogRV.setLayoutManager(gridLayoutManager);
//        dogsAdapter = new DogsAdapter();
//        dogRV.setAdapter(dogsAdapter);

    }

}
