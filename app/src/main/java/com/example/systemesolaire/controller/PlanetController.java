package com.example.systemesolaire.controller;


import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.example.systemesolaire.R;
import com.example.systemesolaire.entite.PlanetListItem;

import java.util.ArrayList;
import java.util.List;

public class PlanetController {
    private String[] noms;
    private int[] distances;
    private int[] images;
    private TypedArray imagesArray;
    private String[] description;
    List<PlanetListItem> items = new ArrayList<PlanetListItem>();


    public PlanetController(Resources res) {
        noms = res.getStringArray(R.array.noms);
        distances = res.getIntArray(R.array.distances);
        images = res.getIntArray(R.array.images);
        description = res.getStringArray(R.array.description);
        imagesArray = res.obtainTypedArray(R.array.images);

        for (int i = 0; i < noms.length; i++) {
            int imageId2 = imagesArray.getResourceId(i, -1);
            int imageId = images[i];
            Log.i("Image ID", "1 : "+imageId + " 2 : "+ imageId2);
            items.add(new PlanetListItem(distances[i], noms[i], R.drawable.planet, description[i]));
        }
        imagesArray.recycle();
    }

    public List<PlanetListItem> getItems() {
        return items;
    }

    public PlanetListItem getItem(int position) {
        Log.i("get Item Id",position+"");
        return items.get(position);
    }
}


//public class PlanetController {
//    private String[] noms;
//    private int[] distances;
//    private TypedArray images; // Changement ici
//    private String[] description;
//    List<PlanetListItem> items = new ArrayList<>();
//
//    public PlanetController(Resources res) {
//        noms = res.getStringArray(R.array.noms);
//        distances = res.getIntArray(R.array.distances);
//        images = res.obtainTypedArray(R.array.images); // TypedArray pour récupérer les drawables
//        description = res.getStringArray(R.array.description);
//
//        for (int i = 0; i < noms.length; i++) {
//            // Utilisation de `images.getResourceId(i, -1)` pour récupérer l'ID de l'image
//            items.add(new PlanetListItem(distances[i], noms[i], images.getResourceId(i, -1), description[i]));
//        }
//
//        images.recycle(); // Libération des ressources du TypedArray
//    }
//
//    public List<PlanetListItem> getItems() {
//        return items;
//    }
//
//    public PlanetListItem getItem(int position) {
//        Log.i("get Item Id", position + "");
//        return items.get(position);
//    }
//}
