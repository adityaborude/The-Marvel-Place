package com.example.themarvelplace.character;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.themarvelplace.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.CardViewHolder> {

    CharactersList charactersList;
    private Context context;
    RequestOptions requestOptions;


    private void initGlide(){
        requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_foreground).override(500,650);
    }

    public CharactersAdapter(CharactersList charactersList, Context context) {
        this.charactersList = charactersList;
        this.context = context;
        initGlide();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        MaterialTextView textView;
        MaterialTextView description;

        public CardViewHolder(@NonNull View view) {
            super(view);
            this.imageView = view.findViewById(R.id.char_card_image);
            this.textView = view.findViewById(R.id.char_card_name);
            this.description = view.findViewById(R.id.char_card_desc);
        }
    }

    @NonNull
    @Override
    public CharactersAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View characterCard = layoutInflater.inflate(R.layout.characters_item, parent, false);
        CardViewHolder viewHolder = new CardViewHolder(characterCard);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.textView.setText(charactersList.getCharactersData().getCharacters().get(position).getName());
        Glide.with(context)
                .asBitmap()
                .load(charactersList.getCharactersData().getCharacters().get(position).getCharacterThumbnail().getThumbnail())
                .apply(requestOptions)
                .into(holder.imageView);
        holder.description.setText(charactersList.getCharactersData().getCharacters().get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return charactersList.getCharactersData().getCharacters().size();
    }

    public void addToList(ArrayList<Character> newCharacters) {
        charactersList.getCharactersData().getCharacters().addAll(newCharacters);
    }
}
