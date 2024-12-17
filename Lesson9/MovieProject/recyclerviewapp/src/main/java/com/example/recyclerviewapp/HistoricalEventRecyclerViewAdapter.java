package com.example.recyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoricalEventRecyclerViewAdapter extends RecyclerView.Adapter<HistoricalEventViewHolder> {
    private List<HistoricalEvent> events;
    private Context context;
    public HistoricalEventRecyclerViewAdapter(List<HistoricalEvent> events) {
        this.events = events;
    }
    @Override
    public HistoricalEventViewHolder onCreateViewHolder(final ViewGroup parent, int
            viewType) {
        // Inflate view from recyclerview_item_layout.xml
        context = parent.getContext();
        View recyclerViewItem =
                LayoutInflater.from(context).inflate(R.layout.event_item_view, parent,
                        false);
        return new HistoricalEventViewHolder(recyclerViewItem);
    }
    @Override
    public void onBindViewHolder(HistoricalEventViewHolder holder, int position) {
        // Set country in countries via position
        HistoricalEvent event = this.events.get(position);
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(event.getImg(),
                "drawable", pkgName);
        // Bind data to viewholder
        holder.getImgView().setImageResource(resID);
        holder.getEventNameView().setText(event.getEventName());
        holder.getEventDescriptionView().setText("Description: " +
                event.getEventDescription());
    }
    @Override
    public int getItemCount() {
        return this.events.size();
    }
}
