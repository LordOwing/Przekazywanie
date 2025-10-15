package com.example.przekazywanie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // W MainActivity.java
    public static final String EXTRA_NUM_2 = "com.example.myapp.NUM_1";
    public static final String EXTRA_NUM_1 = "com.example.myapp.NUM_1";
    public static final String EXTRA_ACTIVITY_MSG = "com.example.myapp.ACTIVITY_MSG";
    public Button btt;
    public TextView Liczba1;
    public TextView Liczba2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Liczba1 = findViewById(R.id.liczba1);
        Liczba2 = findViewById(R.id.liczba2);
        btt = findViewById(R.id.guzik);
        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(EXTRA_ACTIVITY_MSG, "Dane zostały przesłane pomyślnie!");
                intent.putExtra(EXTRA_NUM_1,Double.parseDouble(Liczba1.getText().toString()) );
                intent.putExtra(EXTRA_NUM_2, Double.parseDouble(Liczba2.getText().toString()));
                startActivity(intent);
            }
        });





    }
}