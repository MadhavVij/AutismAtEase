package com.project3.www.AutismAtEase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Register extends AppCompatActivity {
    private Button btnRegister;
    private EditText fname;
    private EditText lname;
    private Spinner gender;
    private EditText age;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initSpinner();

        btnRegister = (Button) findViewById(R.id.btnRgn);
        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        gender = (Spinner) findViewById(R.id.gender);
        age = (EditText) findViewById(R.id.age);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRegister();
            }
        });
    }


    private void initSpinner(){
        Spinner dropdown = findViewById(R.id.gender);
        String[] items = new String[]{"Female", "Male", "Other"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    private void onRegister(){
        Log.d(AppSettings.tagMV, "onRegister: ");
    }

}
