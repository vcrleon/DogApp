package com.example.c4q.dogapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c4q.dogapp.model.DogImage;

import java.util.List;

/**
 * Created by c4q on 2/25/18.
 */

public class DogsAdapter extends RecyclerView.Adapter<DogsViewHolder> {
    List<DogImage> dogImageList;

    @Override
    public DogsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dogs_itemview, parent, false);
        return new DogsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DogsViewHolder holder, int position) {
        DogImage dogs = dogImageList.get(position);
        holder.onBind(dogs);

    }

    @Override
    public int getItemCount() {
        return dogImageList.size();
    }
}
