package com.mideros.roompeliculas.controller;

import android.content.Context;

import androidx.room.Room;

import com.mideros.roompeliculas.database.PeliculaDao;
import com.mideros.roompeliculas.database.PeliculasDatabase;
import com.mideros.roompeliculas.model.Pelicula;

import java.util.List;

public class PeliculasController {

    private static PeliculasController controller;

    private PeliculaDao peliculaDao;

    private PeliculasController(Context context){
        Context appContext = context.getApplicationContext();
        PeliculasDatabase database = Room.databaseBuilder(appContext, PeliculasDatabase.class, "pelicula")
                .allowMainThreadQueries().build();
        peliculaDao= database.getPeliculaDao();
    }

    public static PeliculasController get (Context context)
    {
        if (controller == null){
            controller = new PeliculasController(context);
        }
        return controller;
    }

    public List<Pelicula> getPeliculas()
    {
        return peliculaDao.getPeliculas();
    }

    public Pelicula getPelicula(String id)
    {
        return peliculaDao.getPelicula(id);
    }

    public void createPelicula(Pelicula p)
    {
        peliculaDao.addPelicula(p);
    }

    public void deletePelicula(Pelicula p)
    {
        peliculaDao.deletePelicula(p);
    }

    public void updatePelicula(Pelicula p)
    {
        peliculaDao.updatePelicula(p);
    }
}
