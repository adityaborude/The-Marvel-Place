package com.example.themarvelplace.series;

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
import com.example.themarvelplace.event.EventsAdapter;
import com.google.android.material.textview.MaterialTextView;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.CardViewHolder> {

    SeriesList seriesList;
    private Context context;
    RequestOptions requestOptions;

    private void initGlide(){
        requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_foreground).override(500,700);
    }

    public SeriesAdapter(SeriesList seriesList, Context context) {
        this.seriesList = seriesList;
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
    public SeriesAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View characterCard = layoutInflater.inflate(R.layout.characters_item, parent, false);
        SeriesAdapter.CardViewHolder viewHolder = new SeriesAdapter.CardViewHolder(characterCard);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesAdapter.CardViewHolder holder, int position) {
        Glide.with(context)
                .asBitmap()
                .load(seriesList.getSeriesData().getSeries().get(position).getSeriesThumbnail())
                .apply(requestOptions)
                .into(holder.imageView);
        holder.textView.setText(seriesList.getSeriesData().getSeries().get(position).getTitle());
        holder.textView2.setText(seriesList.getSeriesData().getSeries().get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return seriesList.getSeriesData().getSeries().size();
    }
}
