package com.example.recyclerviewapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HistoricalEventViewHolder extends RecyclerView.ViewHolder {
    private ImageView imgView;
    private TextView eventNameView;
    private TextView eventDescriptionView;
    public HistoricalEventViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imgView = itemView.findViewById(R.id.imageView);
        this.eventNameView =
                itemView.findViewById(R.id.textViewEventName);
        this.eventDescriptionView = itemView.findViewById(R.id.textViewEventDescription);
    }
    public ImageView getImgView() {
        return imgView;
    }
    public TextView getEventNameView() {
        return eventNameView;
    }
    public TextView getEventDescriptionView() {
        return eventDescriptionView;
    }
}