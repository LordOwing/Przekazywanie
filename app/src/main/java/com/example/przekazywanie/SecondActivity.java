package com.example.przekazywanie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    public TextView tekst;
    public TextView tekst2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        tekst = findViewById(R.id.textView);
        tekst2 = findViewById(R.id.textView2);

        if (intent.hasExtra(MainActivity.EXTRA_LICZBA_1) && intent.hasExtra(MainActivity.EXTRA_LICZBA_2)) {
            String wiadomosc = intent.getStringExtra(MainActivity.EXTRA_WIADOMOSC);
            double liczba1 = intent.getDoubleExtra(MainActivity.EXTRA_LICZBA_1, 0);
            double liczba2 = intent.getDoubleExtra(MainActivity.EXTRA_LICZBA_2, 0);
            double suma = liczba1 + liczba2;

            String wynik = "Wynik dodawania: " + suma;

            tekst.setText(wiadomosc);
            tekst2.setText(wynik);
        }
        else if (intent.hasExtra(MainActivity.EXTRA_IMIE) && intent.hasExtra(MainActivity.EXTRA_WIEK)) {
            String imie = intent.getStringExtra(MainActivity.EXTRA_IMIE);
            int wiek = intent.getIntExtra(MainActivity.EXTRA_WIEK, 0);

            String info = "Imię: " + imie + ", Wiek: " + wiek;
            tekst.setText("Dane osobowe:");
            tekst2.setText(info);
        }
        else if (intent.hasExtra(MainActivity.EXTRA_PREMIUM)) {
            boolean premium = intent.getBooleanExtra(MainActivity.EXTRA_PREMIUM, false);

            String tekstPremium = premium ?
                    "Ustawienia premium: Włączone" :
                    "Ustawienia premium: Wyłączone";

            tekst.setText("Status konta:");
            tekst2.setText(tekstPremium);
        }
    }
}