package com.mideros.roompeliculas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle(R.string.app_login);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
