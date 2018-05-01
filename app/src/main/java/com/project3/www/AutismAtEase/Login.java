package com.project3.www.AutismAtEase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private Button btnLogin;
    private EditText email;
    private EditText password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        email = findViewById(R.id.uname);
        password = findViewById(R.id.pass);

        mAuth = FirebaseAuth.getInstance();

        Intent intent = new Intent(this, MainActivity.class);
        startService(intent);
    }

    public void onclick(View view) {
        final Intent i = new Intent(this, MainActivity.class);
        mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.e(AppSettings.tagMV, "signIn: Success!");

                            // update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            //updateUI(user);

                            startActivityForResult(i, 1);
                        } else {
                            Log.e(AppSettings.tagMV, "signIn: Fail!", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed!", Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        if (!task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Authentication failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

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
