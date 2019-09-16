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
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "year")
    private int year;
    @ColumnInfo(name = "punctuation")
    private int punctuation;
    @ColumnInfo(name = "image")
    private String image;

    public Pelicula() {
        id = UUID.randomUUID().toString();
    }

    public Pelicula(String title, String description, int year, int punctuation, String image) {

        id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.year = year;
        this.punctuation = punctuation;
        this.image = image;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(int punctuation) {
        this.punctuation = punctuation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

