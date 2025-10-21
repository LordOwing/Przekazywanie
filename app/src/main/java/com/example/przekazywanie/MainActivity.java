package com.example.przekazywanie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_LICZBA_1 = "com.example.myapp.LICZBA_1";
    public static final String EXTRA_LICZBA_2 = "com.example.myapp.LICZBA_2";
    public static final String EXTRA_WIADOMOSC = "com.example.myapp.WIADOMOSC";
    public static final String EXTRA_IMIE = "com.example.myapp.IMIE";
    public static final String EXTRA_WIEK = "com.example.myapp.WIEK";
    public static final String EXTRA_PREMIUM = "com.example.myapp.PREMIUM";

    public Button przyciskDodaj, przyciskDane, przyciskZapiszPremium;
    public EditText poleLiczba1, poleLiczba2, poleImie, poleWiek;
    public Switch przelacznikPremium;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        poleLiczba1 = findViewById(R.id.liczba1);
        poleLiczba2 = findViewById(R.id.liczba2);
        przyciskDodaj = findViewById(R.id.guzik);

        poleImie = findViewById(R.id.editTextImie);
        poleWiek = findViewById(R.id.editTextWiek);
        przyciskDane = findViewById(R.id.przyciskDane);

        przelacznikPremium = findViewById(R.id.przelacznikPremium);
        przyciskZapiszPremium = findViewById(R.id.przyciskZapiszPremium);

        przyciskDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (poleLiczba1.getText().toString().isEmpty() || poleLiczba2.getText().toString().isEmpty()) {
                    return;
                }

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(EXTRA_WIADOMOSC, "Dane zostały przesłane pomyślnie!");
                intent.putExtra(EXTRA_LICZBA_1, Double.parseDouble(poleLiczba1.getText().toString()));
                intent.putExtra(EXTRA_LICZBA_2, Double.parseDouble(poleLiczba2.getText().toString()));
                startActivity(intent);
            }
        });

        przyciskDane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imie = poleImie.getText().toString();
                String wiekText = poleWiek.getText().toString();

                if (!imie.isEmpty() && !wiekText.isEmpty()) {
                    int wiek = Integer.parseInt(wiekText);

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra(EXTRA_IMIE, imie);
                    intent.putExtra(EXTRA_WIEK, wiek);
                    startActivity(intent);
                }
            }
        });

        przyciskZapiszPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean premium = przelacznikPremium.isChecked();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(EXTRA_PREMIUM, premium);
                startActivity(intent);
            }
        });
    }
}