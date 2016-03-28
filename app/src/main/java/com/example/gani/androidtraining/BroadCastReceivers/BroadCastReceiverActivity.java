package com.example.gani.androidtraining.BroadCastReceivers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gani.androidtraining.R;

public class BroadCastReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_receiver);

        Button btnBroadCast = (Button)findViewById(R.id.buttonBroadCast);
        btnBroadCast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntentBroadCast = new Intent(BroadCastReceiverActivity.this,MyReceiver.class);
                newIntentBroadCast.setAction("com.gani.mybroadcast");
                sendBroadcast(newIntentBroadCast);
            }
        });
    }
}
