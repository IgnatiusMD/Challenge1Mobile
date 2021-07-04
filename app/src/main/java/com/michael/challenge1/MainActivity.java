package com.michael.challenge1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNext = findViewById(R.id.btn_next);
        TextView etName = findViewById(R.id.et_name);
        TextView etHero = findViewById(R.id.et_hero);

        btnNext.setOnClickListener(view -> {

            // Explicit Intent
            Intent intent = new Intent(MainActivity.this, YourHero.class);
            intent.putExtra("name", etName.getText().toString());
            intent.putExtra("hero", etHero.getText().toString());
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Please Wait", Toast.LENGTH_SHORT).show();
        });
    }
}