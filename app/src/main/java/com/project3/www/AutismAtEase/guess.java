package com.project3.www.AutismAtEase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class guess extends AppCompatActivity {

    private TextView sad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

    }

    public void happy(View view) {
        sad = (TextView) findViewById(R.id.textView4);
        sad.setText("HAPPY!");

    }

    public void sad(View view) {
        sad = (TextView) findViewById(R.id.textView4);
        sad.setText("SAD!");
    }
    public void angry(View view) {
        sad = (TextView) findViewById(R.id.textView4);
        sad.setText("ANGRY!");
    }
    public void excited(View view) {
        sad = (TextView) findViewById(R.id.textView4);
        sad.setText("EXCITED!");
    }
}
