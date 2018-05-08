package com.project3.www.AutismAtEase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class Register extends AppCompatActivity {
    private EditText fname;
    private EditText lname;
    private Spinner gender;
    private EditText age;
    private EditText email;
    private EditText password;
    private Contact currentContact;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initSpinner();

        Button btnRegister = findViewById(R.id.btnRgn);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        gender = findViewById(R.id.gender);
        age = findViewById(R.id.age);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();

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
            final Intent intent = new Intent("android.intent.action.MainActivity");

            mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.e(AppSettings.tagMV, "createAccount: Success!");

                                // update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                Log.d(AppSettings.tagMV, "onComplete: USER-> " + Objects.requireNonNull(user).getEmail());
                                sendEmailVerification();
                                //updateUI(user);
                            } else {
                                Log.e(AppSettings.tagMV, "createAccount: Fail!", task.getException());
                                Toast.makeText(getApplicationContext(), "Authentication failed!", Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }
                        }
                    });


            startActivity(intent);


        } else {
            Toast.makeText(getApplicationContext(), "Please provide correct information",
                    Toast.LENGTH_SHORT).show();
        }


    }

    private void sendEmailVerification() {

        final FirebaseUser user = mAuth.getCurrentUser();
        Objects.requireNonNull(user).sendEmailVerification()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Verification email sent to " + user.getEmail(), Toast.LENGTH_SHORT).show();
                        } else {
                            Log.e(AppSettings.tagMV, "sendEmailVerification failed!", task.getException());
                            Toast.makeText(getApplicationContext(), "Failed to send verification email.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    private boolean validate() {
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

        if (!password.getText().toString().matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=_,.])(?=\\S+$).{8,}$")) {
            password.setError("Alphanumeric and special characters required");
            return false;
        }
        return true;
    }

}
