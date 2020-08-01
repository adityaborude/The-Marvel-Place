package com.example.themarvelplace.comic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.themarvelplace.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class ComicsAdapter extends RecyclerView.Adapter<ComicsAdapter.CardViewHolder> {

    ComicsList comics;
    private Context context;
    RequestOptions requestOptions;

    private void initGlide(){
        requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_foreground).override(500,700);
    }

    public ComicsAdapter(ComicsList comics, Context context) {
        this.comics = comics;
        this.context = context;
        initGlide();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        MaterialTextView textView;

        public CardViewHolder(@NonNull View view) {
            super(view);
            this.imageView = view.findViewById(R.id.char_card_image);
            this.textView = view.findViewById(R.id.char_card_name);
        }
    }

    @NonNull
    @Override
    public ComicsAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View characterCard = layoutInflater.inflate(R.layout.characters_item, parent, false);
        CardViewHolder viewHolder = new CardViewHolder(characterCard);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Glide.with(context)
                .asBitmap()
                .load(comics.getComicsData().getComics().get(position).getComicThumbnail().getThumbnail())
                .apply(requestOptions)
                .into(holder.imageView);
        holder.textView.setText(comics.getComicsData().getComics().get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return comics.getComicsData().getComics().size();
    }

    public void addToList(ArrayList<Comic> newComics) {
        comics.getComicsData().getComics().addAll(newComics);
    }
}
