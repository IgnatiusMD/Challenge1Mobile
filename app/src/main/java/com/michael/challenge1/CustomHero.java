package com.michael.challenge1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CustomHero extends AppCompatActivity {

    TextView tvCustomHeroName, tvCustomHeroSource, tvCustomSearchHero;
    EditText etCustomHeroName, etCustomHeroSource, etCustomSearchHero;
    Button btnInsert, btnSearch;

    HeroesDB heroesDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_hero);

        heroesDB = new HeroesDB(this);

        etCustomHeroName = findViewById(R.id.et_customHeroName);
        etCustomHeroSource = findViewById(R.id.et_customHeroSource);
        etCustomSearchHero = findViewById(R.id.et_customSearchHero);
        tvCustomHeroName = findViewById(R.id.tv_sample_heroName);
        tvCustomHeroSource = findViewById(R.id.tv_sample_heroSource);
        tvCustomSearchHero = findViewById(R.id.tv_customSearchHero);
        btnInsert = findViewById(R.id.btn_insert);
        btnSearch = findViewById(R.id.btn_search);

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(view -> {
            Intent returnBack = new Intent(CustomHero.this, MainActivity.class);
            Toast.makeText(CustomHero.this, "Returning", Toast.LENGTH_SHORT).show();
            startActivity(returnBack);
        });
    }

    public void insertHero(View view){
        if (validateBtnInsert()){
            Hero hero = new Hero(
                    etCustomHeroName.getText().toString(),
                    etCustomHeroSource.getText().toString()
            );
            heroesDB.insertHeroes(hero);
        }
        etCustomHeroName.setText("");
        etCustomHeroSource.setText("");
        etCustomSearchHero.setText("");
    }

    public void searchHero(View view){
        Hero hero = heroesDB.getHeroByName(etCustomSearchHero.getText().toString());
        tvCustomHeroName.setText(hero.getHeroName());
        tvCustomHeroSource.setText(hero.getHeroSource());
        etCustomHeroName.setText("");
        etCustomHeroSource.setText("");
        etCustomSearchHero.setText("");
    }

    private boolean validateBtnInsert() {
        if (etCustomHeroName.getText().toString().isEmpty()
                || etCustomHeroSource.getText().toString().isEmpty()){
            etCustomHeroName.setError("Hero name must be filled!");
            etCustomHeroSource.setError("Hero source must be filled!");
            return false;
        }
        return true;
    }

}