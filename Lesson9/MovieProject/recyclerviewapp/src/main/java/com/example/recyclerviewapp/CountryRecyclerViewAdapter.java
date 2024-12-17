package com.example.recyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryRecyclerViewAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    private List<Country> countries;
    private Context context;
    public CountryRecyclerViewAdapter(List<Country> countries) {
        this.countries = countries;
    }
    @Override
    public CountryViewHolder onCreateViewHolder(final ViewGroup parent, int
            viewType) {
        // Inflate view from recyclerview_item_layout.xml
        context = parent.getContext();
        View recyclerViewItem =
                LayoutInflater.from(context).inflate(R.layout.country_item_view, parent,
                        false);
        return new CountryViewHolder(recyclerViewItem);
    }
    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        // Set country in countries via position
        Country country = this.countries.get(position);
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(country.getFlagName() ,
                "drawable", pkgName);
        // Bind data to viewholder
        holder.getFlagView().setImageResource(resID);
        holder.getCountryNameView().setText(country.getCountryName());
        holder.getPopulationView().setText("Description: " +
                country.getPopulation());
    }
    @Override
    public int getItemCount() {
        return this.countries.size();
    }
}