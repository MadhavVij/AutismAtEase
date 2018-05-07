package com.project3.www.AutismAtEase;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout main_view = findViewById(R.id.mainview);

        switch (item.getItemId()) {
            case R.id.menu_red:
                main_view.setBackgroundColor(Color.RED);

            case R.id.menu_blue:
                main_view.setBackgroundColor(Color.BLUE);

            case R.id.menu_green:
                main_view.setBackgroundColor(Color.GREEN);


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Log.d(AppSettings.tagAS, "onNavigationItemSelected: OUT");
        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Log.d(AppSettings.tagAS, "onNavigationItemSelected: Question");
            Intent i = new Intent(this, QuizActivity.class);
           startActivityForResult(i, 1);
          finish();

        } else if (id == R.id.nav_slideshow) {
            Intent i = new Intent(this, Help.class);
            startActivityForResult(i, 1);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
            signOut();
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void clicker(View view) {
        Intent i = new Intent(this, click.class);
        startActivityForResult(i, 1);
    }

    public void tracer(View view) {
        Intent ij = new Intent(this, trace.class);
        startActivityForResult(ij, 1);
    }


    public void guessme(View view) {
        Intent i = new Intent(this, guess.class);
        startActivityForResult(i, 1);
    }

    private void signOut() {
        mAuth.signOut();
        finish();
    }

}
