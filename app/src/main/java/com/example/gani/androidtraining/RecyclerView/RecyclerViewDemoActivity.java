package com.example.gani.androidtraining.RecyclerView;

import android.app.ProgressDialog;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.gani.androidtraining.API.MoviesAPI;
import com.example.gani.androidtraining.API.NetworkManager;
import com.example.gani.androidtraining.Models.MovieModel;
import com.example.gani.androidtraining.Protocols.APIResponseCallBack;
import com.example.gani.androidtraining.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class RecyclerViewDemoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MoviesAdapter moviesAdapter;
    ArrayList<MovieModel> movieArrayList = new ArrayList<MovieModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        moviesAdapter = new MoviesAdapter(movieArrayList);

        //New
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(moviesAdapter);

        //Make Data
        prepareDataForList();

    }

    private void prepareDataForList() {
        //Start Progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching Data ..... ");
        progressDialog.show();

        MoviesAPI moviesAPI = new MoviesAPI();
        moviesAPI.getMovies(new APIResponseCallBack() {
            @Override
            public void onSuccessCompletion(Object object) {
                progressDialog.hide();
                movieArrayList = (ArrayList<MovieModel>)object;
//                moviesAdapter.notifyDataSetChanged();
                moviesAdapter = new MoviesAdapter(movieArrayList);
                recyclerView.setAdapter(moviesAdapter);
                Log.d("TAG", "\n" +
                        " \n" +
                        " \n" +
                        " \n" +
                        " \n" +
                        " \n" +
                        " \n" +
                        " \n" + object.toString()+"\n" +
                        " \n" +
                        " \n" +
                        " \n" +
                        " \n" +
                        " \n");
            }

            @Override
            public void onErrorCompletion() {
                progressDialog.hide();
            }
        });

    }


}
