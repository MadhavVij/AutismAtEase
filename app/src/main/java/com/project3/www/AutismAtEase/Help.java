package com.project3.www.AutismAtEase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Button btnSymptom = findViewById(R.id.btnSymptoms);
        Button btnTreatment = findViewById(R.id.btnTreatment);

        btnSymptom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSymptomClick();
            }
        });

        btnTreatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onTreatmentClick();
            }
        });
    }

    private void onSymptomClick() {
        Intent i = new Intent("android.intent.action.Symptoms");
        startActivity(i);
    }

    private void onTreatmentClick() {
        Intent i = new Intent("android.intent.action.Treatment");
        startActivity(i);
    }
}
