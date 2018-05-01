package com.project3.www.AutismAtEase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends Activity {
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = findViewById(R.id.final_result);

        Bundle d = getIntent().getExtras();

        if (d == null) {
            return;
        }

        result.setText(d.getString("op"));


    }


    public void back(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivityForResult(i, 1);
    }
}
