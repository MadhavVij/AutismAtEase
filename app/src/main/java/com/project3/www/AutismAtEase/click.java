package com.project3.www.AutismAtEase;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.Arrays;
import java.util.Objects;

public class click extends AppCompatActivity {
    private ImageButton clicker;
    @NonNull
    private Boolean status = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        clicker = findViewById(R.id.clicker);
        final Drawable drawable = clicker.getDrawable();
        final Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        clicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Objects.requireNonNull(vibe).vibrate(100);


                Log.d(AppSettings.tagAS, "onClick: " + Arrays.toString(drawable.getState()));
                Log.d(AppSettings.tagAS, "HUHUHU " + Arrays.toString(getResources().getDrawable(R.drawable.unclicked).getState()));


                if (status)
                {
                    clicker.setImageResource(R.drawable.clicked);
                    status = false;
                }else {
                    clicker.setImageResource(R.drawable.unclicked);
                    status = true;
                }



            }
        });
    }
}
