package com.project3.www.AutismAtEase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class mimic extends AppCompatActivity {
    private ImageButton btnDance;
    private ImageButton btnClap;
    private ImageButton btnCrawl;
    private ImageButton btnHands;
    private ImageButton btnJump;
    private ImageButton btnLaugh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mimic);

        btnDance = findViewById(R.id.dance);
        btnClap = findViewById(R.id.clap);
        btnCrawl = findViewById(R.id.crawl);
        btnHands = findViewById(R.id.hands);
        btnJump = findViewById(R.id.jump);
        btnLaugh = findViewById(R.id.happy1);

        btnDance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDance();
            }
        });

        btnClap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClap();
            }
        });

        btnCrawl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCrawl();
            }
        });

        btnHands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onHands();
            }
        });


        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onJump();
            }
        });

        btnLaugh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLaugh();
            }
        });

    }

    private void onDance() {
        Intent i = new Intent(this, Dance.class);
        startActivityForResult(i, 1);
    }

    private void onClap() {
        Intent i = new Intent(this, Clap.class);
        startActivityForResult(i, 1);
    }

    private void onCrawl() {
        Intent i = new Intent(this, Crawl.class);
        startActivityForResult(i, 1);
    }

    private void onHands() {
        Intent i = new Intent(this, Hands.class);
        startActivityForResult(i, 1);
    }

    private void onJump() {
        Intent i = new Intent(this, Jump.class);
        startActivityForResult(i, 1);
    }

    private void onLaugh() {
        Intent i = new Intent(this, Laugh.class);
        startActivityForResult(i, 1);
    }

}
