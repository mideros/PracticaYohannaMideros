package com.mideros.roompeliculas.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.mideros.roompeliculas.model.Pelicula;

import java.util.List;

@Dao
public interface PeliculaDao {

    @Query("SELECT * FROM pelicula")
    List<Pelicula> getPeliculas();

    @Query("SELECT * FROM Pelicula WHERE id LIKE :uuid")
    Pelicula getPelicula(String uuid);
    @Insert
    void addPelicula(Pelicula p);
    @Delete
    void deletePelicula(Pelicula p);
    @Update
    void updatePelicula(Pelicula p);
}
