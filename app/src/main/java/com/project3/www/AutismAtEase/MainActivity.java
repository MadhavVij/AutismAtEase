package com.project3.www.AutismAtEase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, Main2Activity.class);
        startService(intent);
    }

    public void onclick(View view) {
        Intent i = new Intent(this, Main2Activity.class);
            startActivityForResult(i, 1);
        }

    public void newuser(View view) {
        Log.d(AppSettings.tagAS, "newuser: ");
        Intent i = new Intent(this, Register.class);
        startActivityForResult(i, 1);
    }
    public void forgotpass(View view) {
        Intent i = new Intent(this, forgotpass.class);
        startActivityForResult(i, 1);
    }




}
