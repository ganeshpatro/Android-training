package com.example.gani.androidtraining.RecyclerView;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.gani.androidtraining.API.MoviesAPI;
import com.example.gani.androidtraining.API.NetworkManager;
import com.example.gani.androidtraining.Protocols.APIResponseCallBack;
import com.example.gani.androidtraining.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class RecyclerViewDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);

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
