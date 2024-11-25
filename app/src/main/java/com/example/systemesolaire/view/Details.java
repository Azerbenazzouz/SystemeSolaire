package com.example.systemesolaire.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.systemesolaire.R;
import com.example.systemesolaire.controller.PlanetController;
import com.example.systemesolaire.entite.PlanetListItem;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int id = getIntent().getIntExtra("id", -1);
        if (id == -1) {
            Intent intent = new Intent(this, SystemeSolaireList.class);
            startActivity(intent);
            finish();
        }

        PlanetController planetController = new PlanetController(getResources());
        PlanetListItem planet = planetController.getItem(id);

        TextView name = findViewById(R.id.detail_planet_name);
        TextView distance = findViewById(R.id.detail_distance);
        TextView description = findViewById(R.id.detail_description);
        ImageView image = findViewById(R.id.detail_image);

        name.setText(planet.getNom());
        String distanceText = "Distance au Soleil : " + planet.getDistanceASoleil() + " km";
        distance.setText(distanceText);
        description.setText(planet.getDescription());
        image.setImageResource(planet.getImageName());

    }
}