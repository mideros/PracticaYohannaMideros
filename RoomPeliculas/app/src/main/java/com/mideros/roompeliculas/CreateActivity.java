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
    Button btn_create;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        et_title = findViewById(R.id.et_title);
        et_description = findViewById(R.id.et_description);
        et_year = findViewById(R.id.et_year);
        et_punctuation = findViewById(R.id.et_punctuation);
        et_image = findViewById(R.id.et_image);
        btn_create = findViewById(R.id.btn_create);

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

        btn_create.setText("Modificar");
    }
    public void createMovie(View view) {
        String title = et_title.getText().toString();
        String description = et_description.getText().toString();
        String year = et_year.getText().toString();
        String punctuation = et_punctuation.getText().toString();
        String image = et_image.getText().toString();


        if (checkFields(title, description, Integer.parseInt(year),Integer.parseInt(punctuation), image)) {
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


    private boolean checkFields(String title, String description, int year, int punctuation,String image){
        boolean fieldsOk =true;

        if("".equals(title)){
            fieldsOk=false;
            et_title.setError(getString(R.string.errorEmpyTitle));
        }
        if("".equals(description))
        {
            fieldsOk=false;
            et_description.setError(getString(R.string.errorEmpyDescription));
        }
        if("".equals(year))
        {
            fieldsOk=false;
            et_year.setError(getString(R.string.errorEmpyYear));
        }
        if("".equals(punctuation)||punctuation>5)
        {
            fieldsOk=false;
            et_punctuation.setError(getString(R.string.errorEmpyPunctuation));
        }
        if("".equals(image))
        {
            fieldsOk=false;
            et_image.setError(getString(R.string.errorEmpyImage));
        }
        return fieldsOk;
    }

}