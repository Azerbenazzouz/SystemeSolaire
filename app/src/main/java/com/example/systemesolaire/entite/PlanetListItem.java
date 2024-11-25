package com.example.systemesolaire.entite;


import android.graphics.drawable.Drawable;
import android.util.Log;

public class PlanetListItem {
    private String nom;
    private int distanceASoleil;
    private int imageName;
    private String description;

    public PlanetListItem(int distanceASoleil, String nom, int imageName, String description) {
        this.distanceASoleil = distanceASoleil;
        this.nom = nom;
        this.imageName = imageName;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDistanceASoleil() {
        return distanceASoleil;
    }

    public void setDistanceASoleil(int distanceASoleil) {
        this.distanceASoleil = distanceASoleil;
    }

    public int getImageName() {
        return imageName;
    }

    public void setImageName(int imageName) {
        this.imageName = imageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
