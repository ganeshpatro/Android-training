package com.example.gani.androidtraining.Models;

/**
 * Created by ganeshpatro on 24/05/16.
 */
public class AlbumModel {
    private String name;
    private int numberOfSongs;
    private int thumbanil;

    public AlbumModel(String name, int numberOfSongs, int thumbanil) {
        this.name = name;
        this.numberOfSongs = numberOfSongs;
        this.thumbanil = thumbanil;
    }


    //Getters
    public String getName() {
        return name;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public int getThumbanil() {
        return thumbanil;
    }


    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public void setThumbanil(int thumbanil) {
        this.thumbanil = thumbanil;
    }


}
