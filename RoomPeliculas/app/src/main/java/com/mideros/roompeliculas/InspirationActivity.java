package com.mideros.roompeliculas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mideros.roompeliculas.model.Movie;
import com.mideros.roompeliculas.retrofit.MyService;
import com.mideros.roompeliculas.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InspirationActivity extends AppCompatActivity {

    ArrayList<Movie> movies;
    ListView listview;
    MovieAdapter mAdapter;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspiration);

        getSupportActionBar().setTitle(R.string.app_listapi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listview = findViewById(R.id.listview);
        progressBar = findViewById(R.id.progressbar);
        movies = new ArrayList<Movie>();
        mAdapter = new MovieAdapter(this, R.layout.movie_row, movies);

        listview.setAdapter(mAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        retrofitProcess();
    }

    public void retrofitProcess() {

        progressBar.setVisibility(View.VISIBLE);

        MyService service = RetrofitClientInstance.getRetrofitInstance().create(MyService.class);
        Call<List<Movie>> call = service.listMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {

                if(response.body()!=null){
                    movies.clear();
                    movies.addAll(response.body());
                    mAdapter.notifyDataSetChanged();

                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),R.string.errorConnection,Toast.LENGTH_LONG).show();
            }
        });

    }

    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}






