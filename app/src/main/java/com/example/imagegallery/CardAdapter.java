package com.example.imagegallery;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    private Context context;
    private List<Card> cards;
    public CardAdapter(@NonNull Context context, List<Card>cards) {
        this.context = context;
        this.cards = cards;
    }

    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Glide.with(context)
                .load(cards.get(position).getImgUrl())
                .placeholder(R.drawable.image)  // Placeholder while image is loading
                .error(R.drawable.img_error)
                .into(holder.imgView);
        holder.titleView.setText(cards.get(position).getTitle());

        // TODO: Implement logic of maintaining like count
        holder.likeView.setOnClickListener(view -> {
            holder.likeView.setImageResource(R.drawable.heart_filled);
        });
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView titleView;
        ImageButton likeView;
        public CardViewHolder(View view) {
            super(view);
            imgView = view.findViewById(R.id.imageView);
            titleView = view.findViewById(R.id.textViewTitle);
            likeView = view.findViewById(R.id.btnLike);
        }
    }
}
