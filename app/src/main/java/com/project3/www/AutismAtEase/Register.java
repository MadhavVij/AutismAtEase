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
import android.widget.Toast;

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
        if (validate()) {
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


        } else {
            Toast.makeText(getApplicationContext(), "Please provide correct information",
                    Toast.LENGTH_SHORT).show();
        }


    }


    public boolean validate() {
        if (fname.getText().toString().matches("")) {
            fname.setError("First name cannot be empty");
            return false;
        }
        if (lname.getText().toString().matches("")) {
            lname.setError("Last name cannot be empty");
            return false;
        }
        if (age.getText().toString().matches("")) {
            age.setError("Not a valid age");
            return false;
        }
        if (!email.getText().toString().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
            email.setError("Not a valid Email");
            return false;
        }

        if (!password.getText().toString().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=_,.])(?=\\S+$).{8,}$v ")) {
            password.setError("Alphanumeric and special characters required");
            return false;
        }
        return true;
    }

}
