package com.example.systemesolaire.view.components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.systemesolaire.R;
import com.example.systemesolaire.entite.PlanetListItem;

import java.util.List;

public class PlanetListAdapter extends RecyclerView.Adapter<PlanetItem> {

    Context context;
    List<PlanetListItem> items;

    private final RecycleViewOnItemClick recycleViewOnItemClick;

    public PlanetListAdapter(Context context, List<PlanetListItem> items, RecycleViewOnItemClick recycleViewOnItemClick) {
        this.context = context;
        this.items = items;
        this.recycleViewOnItemClick = recycleViewOnItemClick;
    }

    @NonNull
    @Override
    public PlanetItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PlanetItem(LayoutInflater.from(context).inflate(R.layout.planet_item, parent, false), recycleViewOnItemClick);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PlanetItem holder, int position) {
        PlanetListItem item = items.get(position);
        holder.nom.setText(item.getNom());
        holder.distance.setText("Distance au Soleil : " + item.getDistanceASoleil() + " km");
        holder.image.setImageResource(item.getImageName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
