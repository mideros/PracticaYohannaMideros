package com.mideros.roompeliculas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText et_email, et_password;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle(R.string.app_login);

        et_email= findViewById(R.id.et_email);
        et_password=findViewById(R.id.et_password);

        prefs = getSharedPreferences("MyPreferences",MODE_PRIVATE);
        getSupportActionBar().setTitle(R.string.app_login);
    }

    public void loginMovie(View view) {

            if (checkFields()) {
                goMainActivity();
            }
        }

    public boolean checkFields() {
        boolean fieldsOk = true;

        if ("".equals(et_email.getText().toString())) {
            fieldsOk = false;
            et_email.setError(getString(R.string.errorEmpyEmail));
            Toast.makeText(this, getString(R.string.errorEmpyLogin), Toast.LENGTH_SHORT).show();
        }
        if ("".equals(et_password.getText().toString())) {
            fieldsOk = false;
            et_password.setError(getString(R.string.errorEmpyPassword));
            Toast.makeText(this, getString(R.string.errorEmpyLogin), Toast.LENGTH_SHORT).show();
        }
        savePreferences();
        return fieldsOk;
    }


    private void goMainActivity() {
        Intent intent = new Intent(login.this, MainActivity.class);
        startActivity(intent);
    }


    public void savePreferences() {
        String email= et_email.getText().toString();
        String password=et_password.getText().toString();
        SharedPreferences.Editor edit=prefs.edit();
        edit.putString("email", email); // edit.putString("valor", nombre.getText().toString()); //tambien se puede hacer de esta manera
        edit.putString("password", password);
        edit.commit();

    }

    public void openUrlMovie(View view) {
        String text= "https://www.abc.es/play/cine7peliculas/";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(text));
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
