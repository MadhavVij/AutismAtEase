package com.project3.www.AutismAtEase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    private Contact currentContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initSpinner();

        btnRegister = findViewById(R.id.btnRgn);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        gender = findViewById(R.id.gender);
        age = findViewById(R.id.age);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        currentContact = new Contact();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRegister();
            }
        });
    }


    private void initSpinner() {
        Spinner dropdown = findViewById(R.id.gender);
        String[] items = new String[]{"Female", "Male", "Other"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
    }

    private void onRegister() {
        Log.d(AppSettings.tagMV, "onRegister: ");
        currentContact.setfName(fname.getText().toString());
        currentContact.setlName(lname.getText().toString());
        currentContact.setGender(gender.getSelectedItem().toString());
        currentContact.setAge(age.getText().toString());
        currentContact.setEMail(email.getText().toString());
        currentContact.setPassword(password.getText().toString());

        boolean wasSuccessful = false;
        ContactDataSource ds = new ContactDataSource(Register.this);
        try {
            ds.open();

            if (currentContact.getContactID() == -1) {
                wasSuccessful = ds.insertContact(currentContact);
                int newId = ds.getLastContactId();

                currentContact.setContactID(newId);
            } else {
                wasSuccessful = ds.updateContact(currentContact);
            }
            ds.close();
        } catch (Exception e) {
            Log.e(AppSettings.tagMV, "onRegister: Success = " + wasSuccessful + "\nException: " + e);
        }

        Intent intent = new Intent("android.intent.action.MainActivity");
        startActivity(intent);


    }

}
