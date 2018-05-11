package com.project3.www.AutismAtEase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Dance extends AppCompatActivity {
    private ImageView gifImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dance);
        gifImg = findViewById(R.id.dancing);
        Glide.with(this).load("http://dukelong.com/wp-content/uploads/2017/12/giphy-22.gif").into(gifImg);
    }
}
