package com.mideros.roompeliculas.controller;

import android.content.Context;

import androidx.room.Room;

import com.mideros.roompeliculas.database.PeliculaDao;
import com.mideros.roompeliculas.database.PeliculaDatabase;
import com.mideros.roompeliculas.model.Pelicula;

import java.util.List;

public class PeliculaController {

    private static PeliculaController controller;
    private PeliculaDao peliculaDao;

    private PeliculaController(Context context) {
        Context appContext = context.getApplicationContext();
        PeliculaDatabase database = Room.databaseBuilder(appContext, PeliculaDatabase.class, "pelicula").allowMainThreadQueries().build();
        peliculaDao = database.getPeliculaDao();
    }

    public static PeliculaController get(Context context) {
        if (controller == null) {
            controller = new PeliculaController(context);
        }
        return controller;
    }

    public List<Pelicula> getPeliculas() {
        return peliculaDao.getPeliculas();
    }

    public Pelicula getPelicula(String id) {
        return peliculaDao.getPelicula(id);
    }

    public void addPelicula(Pelicula pelicula) {
        peliculaDao.addPelicula(pelicula);
    }

    public void updatePelicula(Pelicula pelicula) {
        peliculaDao.updatePelicula(pelicula);
    }

    public void deletePelicula(Pelicula pelicula) {
        peliculaDao.deletePelicula(pelicula);
    }
}