package com.example.c4q.dogapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.c4q.dogapp.model.DogImage;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

/**
 * Created by c4q on 2/25/18.
 */

public class DogsViewHolder extends RecyclerView.ViewHolder {

    ImageView dogThumbnail;


    public DogsViewHolder(View itemView) {
        super(itemView);

        dogThumbnail = itemView.findViewById(R.id.dog_thumbnail);
    }

    public void onBind(DogImage dogs) {
        Picasso.with(itemView.getContext())
                .load(dogs.getMessage().get(0))
                .into(dogThumbnail);
    }

}
