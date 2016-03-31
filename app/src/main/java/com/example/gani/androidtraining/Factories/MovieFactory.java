package com.example.gani.androidtraining.Factories;

import com.example.gani.androidtraining.Models.MovieModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ganeshpatro on 30/03/16.
 */
public class MovieFactory {

    public static ArrayList<MovieModel> getMovies(JSONArray jsonArray) {
        ArrayList<MovieModel> arrayListMovies = new ArrayList<MovieModel>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                arrayListMovies.add(parseMovieObject(jsonArray.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return arrayListMovies;
    }

    public static MovieModel parseMovieObject(JSONObject jsonObject) {

        MovieModel movie = null;

        try {
            String strTitle = jsonObject.getString("title");
            String strUrlThumbanil = jsonObject.getString("image");
            Number numberRating = (Number) jsonObject.get("rating");
            int year = jsonObject.getInt("releaseYear");

            //Genre is Json Array
            JSONArray jsonArrayGenre = jsonObject.getJSONArray("genre");

            ArrayList<String> stringArrayListGenre = new ArrayList<String>();
            for (int i = 0; i < jsonArrayGenre.length() ; i++) {
                stringArrayListGenre.add((String)jsonArrayGenre.get(i));
            }

            //Create movie object and add into array
            movie = new MovieModel(strTitle,strUrlThumbanil,year,numberRating.doubleValue(),stringArrayListGenre);
            return movie;

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return movie;
    }

}



