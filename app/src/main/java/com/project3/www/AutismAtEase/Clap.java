package com.project3.www.AutismAtEase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Clap extends AppCompatActivity {
    private ImageView gifImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clap);
        gifImg = findViewById(R.id.claping);
        Glide.with(this).load("https://media.giphy.com/media/BqVl9yc94lXvq/giphy.gif").into(gifImg);
    }
}
