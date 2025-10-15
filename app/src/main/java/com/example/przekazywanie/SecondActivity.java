package com.example.przekazywanie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    public TextView tekst;
    public TextView tekst2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        // W SecondActivity.java, w metodzie onCreate()

// Pobranie intencji, która uruchomiła tę Aktywność
        Intent intent = getIntent();
        tekst = findViewById(R.id.textView);
        tekst2 = findViewById(R.id.textView2);
// Odczytanie danych
        String msg = intent.getStringExtra(MainActivity.EXTRA_ACTIVITY_MSG);

        String wynik = intent.getStringExtra(MainActivity.EXTRA_ACTIVITY_MSG);
        tekst.setText(msg);

    }
}