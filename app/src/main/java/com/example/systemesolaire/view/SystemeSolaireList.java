package com.example.systemesolaire.view;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.systemesolaire.R;
import com.example.systemesolaire.controller.PlanetController;
import com.example.systemesolaire.entite.PlanetListItem;
import com.example.systemesolaire.view.components.PlanetListAdapter;
import com.example.systemesolaire.view.components.RecycleViewOnItemClick;

import java.util.ArrayList;
import java.util.List;

public class SystemeSolaireList extends AppCompatActivity implements RecycleViewOnItemClick {

    private PlanetController planetController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_systeme_solaire_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        planetController = new PlanetController(getResources());

        List<PlanetListItem> items = planetController.getItems();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PlanetListAdapter(this, items, this));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(SystemeSolaireList.this, Details.class);
        intent.putExtra("id", position);
        startActivity(intent);
        Log.i("onItemClick",position+"");

    }

    @Override
    public void onItemLongClick(int position) {

    }
}