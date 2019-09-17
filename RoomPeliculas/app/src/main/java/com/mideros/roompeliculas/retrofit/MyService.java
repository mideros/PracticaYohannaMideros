package com.mideros.roompeliculas.retrofit;

import com.mideros.roompeliculas.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyService {
    @GET("films/")
    Call<List<Movie>> listMovies();
}
