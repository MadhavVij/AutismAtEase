package com.project3.www.AutismAtEase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Hands extends AppCompatActivity {
    private ImageView gifImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hands);
        gifImg = findViewById(R.id.handing);
        Glide.with(this).load("https://assets-auto.rbl.ms/0669933148b7f5709948994e3f7baf100b5d8ffcb1a746901c8ca1bb5876c860").into(gifImg);
    }
}
