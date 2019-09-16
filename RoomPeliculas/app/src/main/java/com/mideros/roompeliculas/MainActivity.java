package com.mideros.roompeliculas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mideros.roompeliculas.controller.PeliculaController;
import com.mideros.roompeliculas.model.Pelicula;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<Pelicula> peliculas;
    ListView listview;
    PeliculaAdapter adapter;
    PeliculaController controller;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview =findViewById(R.id.listview);


        peliculas =new ArrayList<Pelicula>();
        adapter =new PeliculaAdapter(this, R.layout.row, peliculas);

        listview.setAdapter(adapter); // le decimos a este listview cual es su adapter
        controller= PeliculaController.get(this); // inicializa el controler

        prefs = getSharedPreferences("MyPreferences",MODE_PRIVATE);

        String email = prefs.getString("email", null);
        String password = prefs.getString("password",null);

        if((email==null)&&(password==null)){
            login();
        }

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                intent.putExtra("idPersona", peliculas.get(i).getId());
                startActivity(intent);
            }
        });
    }

    public void login()
    {
        Intent intent = new Intent(MainActivity.this, login.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showPeliculas();
    }
    private void showPeliculas() {
        peliculas.clear();
        peliculas.addAll(controller.getPeliculas());
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(intent);
                return (true);
        }
        return (super.onOptionsItemSelected(item));
    }

}