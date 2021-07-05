package com.michael.challenge1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class YourHero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_hero);

        String hero = getIntent().getStringExtra("hero");
        TextView toolsHero = findViewById(R.id.tools_hero);
        toolsHero.setText(hero);

        String name = getIntent().getStringExtra("name");
        TextView toolsName = findViewById(R.id.tools_name);
        toolsName.setText(name);

        Button btnReturn = findViewById(R.id.btn_return);
        btnReturn.setOnClickListener(view -> {
            Intent toPrev = new Intent(YourHero.this, MainActivity.class);
            Toast.makeText(YourHero.this, "I found your secrets!", Toast.LENGTH_SHORT).show();
            startActivity(toPrev);
        });

        Button btnHeroList = findViewById(R.id.btn_heroList);
        btnHeroList.setOnClickListener(view -> {
            Intent toHeroList = new Intent(YourHero.this, HeroList.class);
            Toast.makeText(YourHero.this, "Please Wait!", Toast.LENGTH_SHORT).show();
            startActivity(toHeroList);
        });
    }
}