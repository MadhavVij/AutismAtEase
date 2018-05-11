package com.project3.www.AutismAtEase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Instructions extends AppCompatActivity {

    private ImageButton btnBrush;
    private ImageButton btnToilet;
    private ImageButton btnHandWash;
    private ImageButton btnRoutine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        btnBrush = findViewById(R.id.btnBrush);
        btnToilet = findViewById(R.id.btnToilet);
        btnHandWash = findViewById(R.id.btnWashHand);
        btnRoutine = findViewById(R.id.btnRoutine);


        btnBrush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBrush();
            }
        });

        btnToilet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onToilet();
            }
        });

        btnHandWash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onHandWash();
            }
        });

        btnRoutine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRoutine();
            }
        });


    }


    private void onBrush() {
        Intent i = new Intent(this, Brush.class);
        startActivityForResult(i, 1);
    }

    private void onToilet() {
        Intent i = new Intent(this, Toilet.class);
        startActivityForResult(i, 1);
    }

    private void onHandWash() {
        Intent i = new Intent(this, HandWash.class);
        startActivityForResult(i, 1);
    }

    private void onRoutine() {
        Intent i = new Intent(this, Routine.class);
        startActivityForResult(i, 1);
    }
}
