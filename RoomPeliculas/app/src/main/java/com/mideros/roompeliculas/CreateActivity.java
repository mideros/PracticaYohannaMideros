package com.mideros.roompeliculas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mideros.roompeliculas.controller.PeliculaController;
import com.mideros.roompeliculas.model.Pelicula;

public class CreateActivity extends AppCompatActivity {

    EditText et_title, et_description, et_year, et_punctuation, et_image;
    PeliculaController controller;
    Pelicula pelicula;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        getSupportActionBar().setTitle(R.string.app_create);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_title = findViewById(R.id.et_title);
        et_description = findViewById(R.id.et_description);
        et_year = findViewById(R.id.et_year);
        et_punctuation = findViewById(R.id.et_punctuation);
        et_image = findViewById(R.id.et_image);

        controller = PeliculaController.get(this);


        id = getIntent().getStringExtra("idPelicula");
        if (id != null)
        {
            pelicula = controller.getPelicula(id);

            showPelicula();
        }
    }

    private void showPelicula() {
        et_title.setText(pelicula.getTitle());
        et_description.setText(pelicula.getDescription());
        et_year.setText(String.valueOf(pelicula.getYear()));
        et_punctuation.setText(String.valueOf(pelicula.getPunctuation()));
        et_image.setText(pelicula.getImage());

    }
    public void createMovie(View view) {

        String title = et_title.getText().toString();
        String description = et_description.getText().toString();
        String year = et_year.getText().toString();
        String punctuation = et_punctuation.getText().toString();
        String image = et_image.getText().toString();


        if (checkFields(title, description, year,punctuation, image)) {

            if (id != null) {

                pelicula.setTitle(title);
                pelicula.setDescription(description);
                pelicula.setYear(Integer.parseInt(year));
                pelicula.setPunctuation(Integer.parseInt(punctuation));
                pelicula.setImage(image);

                controller.updatePelicula(pelicula);

            } else {
                Pelicula p = new Pelicula(title, description, Integer.parseInt(year),Integer.parseInt(punctuation), image);
                controller.addPelicula(p);

            }
            finish();
        }
    }

    private boolean checkFields(String title, String description, String year, String punctuation,String image){
        boolean fieldsOk =true;

        if("".equals(et_title.getText().toString())){
            fieldsOk=false;
            et_title.setError(getString(R.string.errorEmpyTitle));
        }
        if("".equals(et_description.getText().toString()))
        {
            fieldsOk=false;
            et_description.setError(getString(R.string.errorEmpyDescription));
        }
        if("".equals(et_year.getText().toString()))
        {
            fieldsOk=false;
            et_year.setError(getString(R.string.errorEmpyYear));
        }
        if(("".equals(et_punctuation.getText().toString())))
        {
            fieldsOk=false;
            et_punctuation.setError(getString(R.string.errorEmpyPunctuationCamp));

        } else {
            int p = Integer.parseInt(et_punctuation.getText().toString());
            if (p < 5) {
                et_punctuation.setError(getString(R.string.errorEmpyPunctuation));
                fieldsOk = false;
            }
        }
        if("".equals(et_image.getText().toString()))
        {
            fieldsOk=false;
            et_image.setError(getString(R.string.errorEmpyImage));
        }
        return fieldsOk;
    }
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}