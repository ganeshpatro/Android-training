package com.example.gani.androidtraining.API;

import android.app.ProgressDialog;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.gani.androidtraining.Protocols.APIResponseCallBack;

import org.json.JSONArray;

/**
 * Created by ganeshpatro on 30/03/16.
 */
public class MoviesAPI {

    public  void getMovies(APIResponseCallBack apiResponseCallBack) {

        final APIResponseCallBack callBackLocal = apiResponseCallBack;

        //Here i am making network call
        String strTagRequest = "TAG_REQUEST";
        String strUrl = "http://api.androidhive.info/json/movies.json";

        //Start making the request
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(strUrl,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("TAG", "\n" +
                                " \n" +
                                " \n" +
                                " \n" +
                                " \n" +
                                " \n" +
                                " \n" +
                                " \n" + response.toString()+"\n" +
                                " \n" +
                                " \n" +
                                " \n" +
                                " \n" +
                                " \n");
                        //Call Success
                        callBackLocal.onSuccessCompletion(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("TAG", "Error: " + error.getMessage());
                // hide the progress dialog
                callBackLocal.onErrorCompletion();
            }
        });

        //Finally Adding request to request queue
        NetworkManager.getInstance().addToRequestQueue(jsonArrayRequest, strTagRequest);
    }


}
