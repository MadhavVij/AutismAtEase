package com.project3.www.AutismAtEase;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class click extends AppCompatActivity {
    private ImageButton clicker;
    private Boolean status = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        clicker = (ImageButton) findViewById(R.id.clicker);
        final Drawable drawable = clicker.getDrawable();
        final Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        clicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibe.vibrate(100);



                Log.d(AppSettings.tagAS, "onClick: "+drawable.getState());
                Log.d(AppSettings.tagAS, "HUHUHU "+getResources().getDrawable(R.drawable.unclicked).getState());


                if(status == true)
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
