package com.mideros.roompeliculas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mideros.roompeliculas.controller.PeliculaController;
import com.mideros.roompeliculas.model.Pelicula;


public class DetailActivity extends AppCompatActivity {

    TextView tv_title, tv_description, tv_year, tv_punctuation, tv_image;
    PeliculaController controller;
    Pelicula pelicula;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String id = getIntent().getStringExtra("idPersona");
        controller = PeliculaController.get(this);
        pelicula = controller.getPelicula(id);

        /*Inicialitzar els TextView*/
        tv_title = findViewById(R.id.tv_title);
        tv_description = findViewById(R.id.tv_description);
        tv_year = findViewById(R.id.tv_year);
        tv_punctuation = findViewById(R.id.tv_punctuation);
        tv_image = findViewById(R.id.tv_image);

        showPelicula();


    }

    private void showPelicula()
    {
        tv_title.setText(pelicula.getTitle());
        tv_description.setText(pelicula.getDescription());
        tv_year.setText(String.valueOf(pelicula.getYear()));
        tv_punctuation.setText(String.valueOf(pelicula.getPunctuation()));
        tv_image.setText(pelicula.getImage());

    }

    public void deleteMovie(View view) {
        controller.deletePelicula(pelicula);
        finish();
    }

}
