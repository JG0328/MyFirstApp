package com.pucmm.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView txtName, txtInfo, txtLanguages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();

        txtName = findViewById(R.id.name_txt);
        txtInfo = findViewById(R.id.info_txt);
        txtLanguages = findViewById(R.id.languages_txt);

        txtName.setText("¡Hola!, Mi nombre es: " + intent.getExtras().getString("name") + " " + intent.getExtras().getString("lastName"));
        txtInfo.setText("Soy " + intent.getExtras().getString("gender") + ", y nací en fecha " + intent.getExtras().getString("date"));
        txtLanguages.setText(intent.getExtras().getBoolean("likes") ? "Me gusta programar. Mis lenguajes favoritos son " + intent.getExtras().getString("languages") : "No me gusta programar");
    }
}