package com.project3.www.AutismAtEase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent = new Intent(this, MainActivity.class);
        startService(intent);
    }

    public void onclick(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivityForResult(i, 1);
    }

    public void newuser(View view) {
        Intent i = new Intent(this, Register.class);
        startActivityForResult(i, 1);
    }

    public void forgotpass(View view) {
        Intent i = new Intent(this, forgotpass.class);
        startActivityForResult(i, 1);
    }


}
