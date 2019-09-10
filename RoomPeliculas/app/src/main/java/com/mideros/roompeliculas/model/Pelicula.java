package com.mideros.roompeliculas.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.UUID;

@Entity(tableName = "pelicula")
public class Pelicula {

    @PrimaryKey
    @NonNull
    private String id;
    @ColumnInfo(name = "titulo")
    private String titulo;
    @ColumnInfo(name = "descripcion")
    private String descripcion;
    @ColumnInfo(name = "year")
    private Date year;
    @ColumnInfo(name = "puntuacion")
    private int puntuacion;
    @ColumnInfo(name = "imagen")
    private String imagen;

    public Pelicula() {

        id = UUID.randomUUID().toString();
    }

    public Pelicula(String titulo, String descripcion, Date year, int puntuacion, String imagen) {

        id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.year = year;
        this.puntuacion = puntuacion;
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
