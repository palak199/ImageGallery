package com.example.imagegallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    List<Card> cards;
    RecyclerView recyclerView;
    CardAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        cards = new ArrayList<>();
        adapter = new CardAdapter(this, cards);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        fetchCardsData();

    }
    private void fetchCardsData() {

        Random random = new Random();

        // TODO: add pagination
        for (int i = 0; i < 10; i++) {
            int randomId = random.nextInt(100); // Generate a random ID (0-99)

            ApiService api = ApiClient.getClient().create(ApiService.class);
            Call<ImgResponse> call = api.getImageURL(randomId);
            call.enqueue(new Callback<ImgResponse>() {
                @Override
                public void onResponse(Call<ImgResponse> call, Response<ImgResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            String imageUrl = response.body().getImgUrl();
                            String author = response.body().getTitle();
                            int width = response.body().getWidth();
                            int height = response.body().getHeight();
                            cards.add(new Card(author, imageUrl, width, height));
                            adapter.notifyItemInserted(cards.size()-1);
                        }
                    } else {
                        Log.e(TAG, response.code() + " " + response.message());
                    }
                }

                @Override
                public void onFailure(Call<ImgResponse> call, Throwable t) {
                    Log.e(TAG, t.getMessage());
                }
            });
        }
    }
}