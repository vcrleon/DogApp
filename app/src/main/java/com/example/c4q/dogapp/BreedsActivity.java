package com.example.c4q.dogapp;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c4q.dogapp.model.DogImage;
import com.example.c4q.dogapp.network.DogService;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BreedsActivity extends AppCompatActivity implements OnClickListener{

    private TextView welcomeView, terrierView, retrieverView, spanielView, poodleView;
    private ImageView terrierImage, retrieverImage, spanielImage, poodleImage;
    private CardView terrierCardView, retrieverCardView, spanielCardView, poodleCardView;

    Retrofit retrofit;
    DogService dogService;
    HashMap<String, String> dogURL = new HashMap<>();
    List<String> dogList = new ArrayList<>();
    Intent dogsIntent;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed);

        dogsIntent = new Intent(BreedsActivity.this, DogsActivity.class);
        gson = new Gson();

        setUpViews();
        connectDogAPI();
        viewClickBehavior();



        Picasso.with(getApplicationContext())
                .load("https://dog.ceo/api/img/poodle-standard/n02113799_2333.jpg")
                .into(poodleImage);


    }

    @Override
    public void onClick(View view) {
//        String terrier = "terrier";
//        String retriever = "retriever";
//        String spaniel = "spaniel";
//        String poodle = "poodle";
//
//        switch (view.getId()) {
//            case R.id.terrier_view:
//                Toast.makeText(BreedsActivity.this, "Terrier!", Toast.LENGTH_SHORT).show();
//                dogCall(terrier);
//                break;
//            case R.id.retriever_view:
//                connectDogAPI();
//                dogCall(retriever);
//                break;
//            case R.id.spaniel_view:
//                dogCall(spaniel);
//                break;
//            case R.id.poodle_view:
//                dogCall(poodle);
//                break;
//        }

    }


    public void connectDogAPI(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        dogService = retrofit.create(DogService.class);

    }

    public void dogCall(String dogName) {
        Call<DogImage> dog = dogService.getDogImage(dogName);
        dog.enqueue(new Callback<DogImage>() {
            @Override
            public void onResponse(Call<DogImage> call, Response<DogImage> response) {
                dogList.addAll(response.body().getMessage());
                Log.d("DogImage", response.body().getMessage().get(0));
            }

            @Override
            public void onFailure(Call<DogImage> call, Throwable t) {
                t.printStackTrace();

            }
        });

    }

    public void viewClickBehavior(){
        terrierCardView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String dogName = "terrier";
                Toast.makeText(BreedsActivity.this, "Terrier!", Toast.LENGTH_SHORT).show();
                dogCall(dogName);
                String dogToString = gson.toJson(dogList);
                dogsIntent.putExtra("Dog_Info",dogToString);
                startActivity(dogsIntent);

            }
        });

        retrieverCardView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String dogName = "retriever";
                Toast.makeText(BreedsActivity.this, "Retriever!", Toast.LENGTH_SHORT).show();
                dogCall(dogName);
                String dogToString = gson.toJson(dogList);
                dogsIntent.putExtra("Dog_Info",dogToString);
                startActivity(dogsIntent);
            }
        });

        spanielCardView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String dogName = "spaniel";
                Toast.makeText(BreedsActivity.this, "Spaniel!", Toast.LENGTH_SHORT).show();
                dogCall(dogName);
                String dogToString = gson.toJson(dogList);
                dogsIntent.putExtra("Dog_Info",dogToString);
                startActivity(dogsIntent);

            }
        });

        poodleCardView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String dogName = "poodle";
                Toast.makeText(BreedsActivity.this, "Poodle!", Toast.LENGTH_SHORT).show();
                dogCall(dogName);
                String dogToString = gson.toJson(dogList);
                dogsIntent.putExtra("Dog_Info",dogToString);
                startActivity(dogsIntent);
            }
        });

    }

    private void setUpViews() {
        welcomeView = findViewById(R.id.welcome_view);
        terrierView = findViewById(R.id.terrier_textview);
        retrieverView = findViewById(R.id.retriever_textview);
        spanielView = findViewById(R.id.spaniel_textview);
        poodleView = findViewById(R.id.poodle_textview);
        terrierImage = findViewById(R.id.terrier_imageview);
        retrieverImage = findViewById(R.id.retriever_imageview);
        spanielImage = findViewById(R.id.spaniel_imageview);
        poodleImage = findViewById(R.id.poodle_imageview);
        terrierCardView = findViewById(R.id.terrier_view);
        retrieverCardView = findViewById(R.id.retriever_view);
        spanielCardView = findViewById(R.id.spaniel_view);
        poodleCardView = findViewById(R.id.poodle_view);

        welcomeView.setText(R.string.welcome_question);
    }


}
