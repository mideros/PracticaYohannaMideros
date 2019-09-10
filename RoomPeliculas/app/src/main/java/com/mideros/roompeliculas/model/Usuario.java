package com.mideros.roompeliculas.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "usuario")
public class Usuario {
    @PrimaryKey
    @NonNull
    private String id;
    @ColumnInfo(name = "email")
    private String email;

    public Usuario() {
        id = UUID.randomUUID().toString();
    }

    public Usuario(String email) {
        id = UUID.randomUUID().toString();
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
