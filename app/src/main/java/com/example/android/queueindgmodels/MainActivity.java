package com.example.android.queueindgmodels;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView d1;
    TextView dk;
    TextView m1;
    TextView mk;
    TextView mmc;
    TextView mmck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        d1 = findViewById(R.id.d1);
        dk = findViewById(R.id.dk);
        m1 = findViewById(R.id.m1);
        mk = findViewById(R.id.mk);
        mmc = findViewById(R.id.mmc);
        mmck = findViewById(R.id.mmck);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InD1.class);
                startActivity(intent);
            }
        });
        dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InDk.class);
                startActivity(intent);
            }
        });


        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InM1.class);
                startActivity(intent);
            }
        });
        mk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InMk.class);
                startActivity(intent);
            }
        });
        mmc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InMMC.class);
                startActivity(intent);
            }
        });
        mmck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InMMcK.class);
                startActivity(intent);
            }
        });
    }
}