package com.project3.www.AutismAtEase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Jump extends AppCompatActivity {
    private ImageView gifImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);
        gifImg = findViewById(R.id.jumping);
        Glide.with(this).load("https://media.giphy.com/media/9tMWpwrcGWJdm/giphy.gif").into(gifImg);
    }
}
