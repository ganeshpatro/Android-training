package com.example.gani.androidtraining.RecyclerView;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.gani.androidtraining.Models.MovieModel;
import com.example.gani.androidtraining.R;

import java.util.ArrayList;

/**
 * Created by ganeshpatro on 31/03/16.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private ArrayList<MovieModel> movieArrayList;

    //View Holder class
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitle, textViewYear, textViewGenre,textViewRating;
        public NetworkImageView networkImageView;

        public MyViewHolder(View view) {
            super(view);
            textViewTitle = (TextView)view.findViewById(R.id.textViewTitle);
            textViewYear = (TextView)view.findViewById(R.id.textViewYear);
            textViewRating = (TextView)view.findViewById(R.id.textViewRating);
            textViewGenre = (TextView)view.findViewById(R.id.textViewGenre);
            networkImageView = (NetworkImageView)view.findViewById(R.id.imageViewThumbanil);
        }

    }

    //Adapter initialisation
    public MoviesAdapter(ArrayList<MovieModel> movieModelArrayList) {
        this.movieArrayList = movieModelArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_recycler_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MovieModel movieModel = movieArrayList.get(position);
        holder.networkImageView.setBackgroundColor(R.color.red);
        holder.textViewTitle.setText(movieModel.getTitle());
        holder.textViewRating.setText("Rating " + String.valueOf(movieModel.getRating()));
        holder.textViewYear.setText(String.valueOf(movieModel.getYear()));
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }
}
