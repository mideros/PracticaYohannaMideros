package com.mideros.roompeliculas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mideros.roompeliculas.model.Movie;


import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter<Movie> {
    int layoutResourceId;
    Context context;
    ArrayList<Movie> data;
    public MovieAdapter(Context context, int layoutResourceId, ArrayList<Movie> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);


        TextView tv_title = (TextView)row.findViewById(R.id.tv_mTitle);
        tv_title.setText(data.get(position).getTitle());

        return row;
    }
}
