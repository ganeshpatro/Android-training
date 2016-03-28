package com.example.gani.androidtraining.BroadCastReceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.example.gani.androidtraining.Service.DemoAudioService;

/**
 * Created by ganeshpatro on 28/03/16.
 */
public class MyReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Received a broadcast message :- " + intent.getAction(),Toast.LENGTH_SHORT).show();

        if (intent.getAction().equalsIgnoreCase("com.gani.mybroadcast")){
            Intent newIntentAudioService = new Intent(context, DemoAudioService.class);
            context.startService(newIntentAudioService);
        } else {
            Bundle extras = intent.getExtras();
            if (extras !=null) {
                String state = extras.getString(TelephonyManager.EXTRA_STATE);
                Toast.makeText(context,"Extra State is =  " + state,Toast.LENGTH_SHORT).show();
                if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING)) {
                    String phoneNumber = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                    Toast.makeText(context,"Incoming number is " + phoneNumber,Toast.LENGTH_LONG).show();
                }
            }
        }


    }
}
