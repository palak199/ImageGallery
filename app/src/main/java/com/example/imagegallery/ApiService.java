package com.example.imagegallery;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

// API service where we define endpoints. Here we need random id
public interface ApiService {

    @GET("id/{id}/info")
    Call<ImgResponse> getImageURL(@Path("id") int id);
}
