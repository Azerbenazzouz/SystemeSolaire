package com.example.systemesolaire.view.components;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.systemesolaire.R;

public class PlanetItem extends RecyclerView.ViewHolder {

    TextView nom , distance;
    ImageView image;

    public PlanetItem(@NonNull View itemView, RecycleViewOnItemClick recycleViewOnItemClick) {
        super(itemView);
        nom = itemView.findViewById(R.id.nom);
        distance = itemView.findViewById(R.id.distance);
        image = itemView.findViewById(R.id.image);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(recycleViewOnItemClick != null){
                    int position = getAdapterPosition();

                    if (recycleViewOnItemClick != null && position != RecyclerView.NO_POSITION) {
                        recycleViewOnItemClick.onItemClick(position);
                    }
                }
            }
        });
    }

//    (ImageView)findViewById(R.id.image).
}
