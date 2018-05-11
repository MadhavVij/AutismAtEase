package com.project3.www.AutismAtEase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Crawl extends AppCompatActivity {
    private ImageView gifImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crawl);
        gifImg = findViewById(R.id.crawling);
        Glide.with(this).load("https://thumbs.gfycat.com/UnsteadyFrightenedCoral-size_restricted.gif").into(gifImg);
    }
}
