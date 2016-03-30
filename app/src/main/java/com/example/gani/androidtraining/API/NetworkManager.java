package com.example.gani.androidtraining.API;

import android.app.Application;
import android.app.DownloadManager;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.gani.androidtraining.Protocols.APIResponseCallBack;
import com.example.gani.androidtraining.RequestData.BaseRequestData;

import org.json.JSONArray;

/**
 * Created by ganeshpatro on 30/03/16.
 */
public class NetworkManager extends Application{

    public static final String TAG = NetworkManager.class.getSimpleName();

    //Request Queue
    private RequestQueue mRequestQueue;
    private static NetworkManager mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    //Get Singleton Instance
    public static NetworkManager getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        //Set the tag and if this is empty, then set default TAG
        req.setTag(TextUtils.isEmpty(tag)?TAG:tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    public void sendRequest(BaseRequestData baseRequestData, APIResponseCallBack callBack){

    }

    /* *******************************  Now Call Volley's request methods  *************************************** */

    private void sendJsonObjectRequest() {

    }

    private void sendJsonArrayRequest(BaseRequestData baseRequestData, APIResponseCallBack callBack) {
       final APIResponseCallBack apiResponseCallBackLocal = callBack;
        //Here i am making network call
        String strTagRequest = baseRequestData.getStrTagRequest();
        String strUrl = baseRequestData.getStrTagRequest();

       // String strUrl = "http://api.androidhive.info/json/movies.json";
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
                        apiResponseCallBackLocal.onSuccessCompletion(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("TAG", "Error: " + error.getMessage());
                // hide the progress dialog
                apiResponseCallBackLocal.onErrorCompletion();
            }
        });

        //Finally Adding request to request queue
        NetworkManager.getInstance().addToRequestQueue(jsonArrayRequest, strTagRequest);
    }

}
