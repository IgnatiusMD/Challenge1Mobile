package com.michael.challenge1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class HeroList extends AppCompatActivity {

    ArrayList<HeroModel> heroModelArrayList = new ArrayList<>();
    RecyclerView rvHeroes;
    HeroAdapter heroAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_list);

        HeroModel Gatotkaca = new HeroModel("GatotKaca", R.drawable.gatotkaca, "Kamyaka Forest");
        HeroModel Estes = new HeroModel("Estes", R.drawable.estes, "Moonlit Forest");
        HeroModel Granger = new HeroModel("Granger", R.drawable.granger, "Imperial Sanctuary");
        HeroModel Karrie = new HeroModel("Karrie", R.drawable.karrie, "Alaghat");
        HeroModel Ling = new HeroModel("Ling", R.drawable.ling, "Dragon Altar");
        HeroModel PopolKupa = new HeroModel("Popol and Kupa", R.drawable.popolkupa, "Northern Vale");

        heroModelArrayList.add(Gatotkaca);
        heroModelArrayList.add(Estes);
        heroModelArrayList.add(Granger);
        heroModelArrayList.add(Karrie);
        heroModelArrayList.add(Ling);
        heroModelArrayList.add(PopolKupa);

        heroAdapter = new HeroAdapter(this, heroModelArrayList);

        rvHeroes = findViewById(R.id.rv_heroes);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvHeroes.setLayoutManager(linearLayoutManager);
        rvHeroes.setAdapter(heroAdapter);

        Button btnReturnMenu = findViewById(R.id.btn_returnToMainMenu);
        btnReturnMenu.setOnClickListener(view -> {
            Intent toMainMenu = new Intent(HeroList.this, MainActivity.class);
            Toast.makeText(HeroList.this, "See you Later!", Toast.LENGTH_SHORT).show();
            startActivity(toMainMenu);
        });
    }
}