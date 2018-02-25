package com.example.c4q.dogapp.network;

import com.example.c4q.dogapp.model.DogImage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by c4q on 2/25/18.
 */

public interface DogService {

    @GET("breed/{name}/images")
    Call<DogImage> getDogImage(@Path("name") String dogName);


}
