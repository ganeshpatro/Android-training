package com.example.gani.androidtraining.BroadCastReceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by ganeshpatro on 25/05/16.
 */
public class InternetStateChangeReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();


        if (isConnected) {
            Toast.makeText(context, "Internet Available",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Ohhhh.....   Internet Gone !!!!",Toast.LENGTH_SHORT).show();
        }

    }
}
