package com.mideros.roompeliculas;

import android.app.Activity;
import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mideros.roompeliculas.model.Pelicula;

import java.util.ArrayList;

public class PeliculaAdapter extends ArrayAdapter<Pelicula> {
    int layoutResourceId;
    Context context;
    ArrayList<Pelicula> data;
    public PeliculaAdapter(Context context, int layoutResourceId, ArrayList<Pelicula> data) {
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


        TextView tv_title = (TextView)row.findViewById(R.id.tv_title);
        TextView tv_punctuacion= (TextView)row.findViewById(R.id.tv_punctuacion);


        tv_title.setText(data.get(position).getTitle());


        tv_punctuacion.setText(String.valueOf(data.get(position).getPunctuation()));
        int punctuation = data.get(position).getPunctuation();

        if(punctuation<=1)
        {
            tv_punctuacion.setTextColor(context.getResources().getColor(R.color.colorRedB));
        }else if( punctuation==4 || punctuation==5)
        {
            tv_punctuacion.setTextColor(context.getResources().getColor(R.color.colorGreenB));
        }else if(punctuation==2 || punctuation==3){
            tv_punctuacion.setTextColor(context.getResources().getColor(R.color.colorBlack));
        }






        return row;
    }
}
