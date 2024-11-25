package com.example.systemesolaire.controller;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;

import com.example.systemesolaire.R;
import com.example.systemesolaire.entite.PlanetListItem;

import java.util.ArrayList;
import java.util.List;

public class PlanetController {
    private String[] noms;
    private float[] distances;
    private TypedArray imagesArray;
    private String[] description;
    List<PlanetListItem> items = new ArrayList<>();

    public PlanetController(Resources res) {
        noms = res.getStringArray(R.array.noms);
        String[] distancesStr = res.getStringArray(R.array.distances);
        distances = new float[distancesStr.length];
        for (int i = 0; i < distancesStr.length; i++) {
            distances[i] = Float.parseFloat(distancesStr[i]);
        }
        imagesArray = res.obtainTypedArray(R.array.images);
        description = res.getStringArray(R.array.description);

        for (int i = 0; i < noms.length; i++) {
            int imageId = imagesArray.getResourceId(i, -1);
            Log.i("Image ID", "Image ID: " + imageId);
            items.add(new PlanetListItem(distances[i], noms[i], imageId, description[i]));
        }
        imagesArray.recycle();
    }

    public List<PlanetListItem> getItems() {
        return items;
    }

    public PlanetListItem getItem(int position) {
        Log.i("get Item Id", position + "");
        return items.get(position);
    }
}
