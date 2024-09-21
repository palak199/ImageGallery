package com.example.imagegallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Card> cards;
    RecyclerView recyclerView;

    CardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        cards = new ArrayList<>();
        fetchCardsData();
        adapter = new CardAdapter(this, cards);
        recyclerView.setAdapter(adapter);
    }

    // TODO: get this data from API
    private void fetchCardsData() {
        cards.add(new Card("https://w0.peakpx.com/wallpaper/326/773/HD-wallpaper-dr-ambedkar-illustration-indian-jurist-indian-economist.jpg", "Title 3"));
        cards.add(new Card("https://images.pexels.com/photos/1188083/pexels-photo-1188083.png?cs=srgb&dl=sea-dawn-nature-1188083.jpg&fm=jpg", "Title 2"));
        cards.add(new Card("https://tse1.mm.bing.net/th?id=OIP.vpUUrAb6H7eMCIM4TRzpcAHaFj&pid=Api&P=0&h=220", "Title 4"));
    }


}