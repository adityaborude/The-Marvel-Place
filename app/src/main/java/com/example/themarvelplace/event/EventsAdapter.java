package com.example.themarvelplace.event;

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

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.CardViewHolder> {

    EventsList eventsList;
    private Context context;
    RequestOptions requestOptions;

    private void initGlide(){
        requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_foreground).override(500,700);
    }

    public EventsAdapter(EventsList eventsList, Context context) {
        this.eventsList = eventsList;
        this.context = context;
        initGlide();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        MaterialTextView textView;
        MaterialTextView textView2;

        public CardViewHolder(@NonNull View view) {
            super(view);
            this.imageView = view.findViewById(R.id.char_card_image);
            this.textView = view.findViewById(R.id.char_card_name);
            this.textView2 = view.findViewById(R.id.char_card_desc);
        }
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View characterCard = layoutInflater.inflate(R.layout.characters_item, parent, false);
        EventsAdapter.CardViewHolder viewHolder = new EventsAdapter.CardViewHolder(characterCard);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Glide.with(context)
                .asBitmap()
                .load(eventsList.getEventsData().getEvents().get(position).getEventThumbnail())
                .apply(requestOptions)
                .into(holder.imageView);
        holder.textView.setText(eventsList.getEventsData().getEvents().get(position).getTitle());
        holder.textView2.setText(eventsList.getEventsData().getEvents().get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return eventsList.getEventsData().getEvents().size();
    }

}
