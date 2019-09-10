package com.mideros.roompeliculas.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "note")
public class Pelicula {

    @PrimaryKey
    @NonNull
    private String id;
    @ColumnInfo(name = "content")
    private String titulo;
    private String descripcion;
    private Date year;
    private int puntuacion;
    private String imagen;
}
