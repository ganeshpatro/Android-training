package com.example.gani.androidtraining.Service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gani.androidtraining.R;


public class ServiceDemoNextPageActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBindService, btnStartService, btnStopService;

    //Service reference
    DemoAudioService serviceReference;

    //Status
    Boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo_next_page);

        //instantiate buttons
        btnStartService = (Button) findViewById(R.id.buttonStartServiceBound);
        btnStopService = (Button) findViewById(R.id.buttonStopServiceBound);
        btnBindService = (Button) findViewById(R.id.buttonBindServiceBound);

        //Set OnClickListeners
        btnStartService.setOnClickListener(this);
        btnStopService.setOnClickListener(this);
        btnBindService.setOnClickListener(this);
    }

    protected ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            Toast.makeText(ServiceDemoNextPageActivity.this,"On Service Connected",Toast.LENGTH_LONG).show();

            //Cast into local binder
            DemoAudioService.MyLocalBinder mBinderLocal = (DemoAudioService.MyLocalBinder) binder;

            /* Here we got the Binder Interface from which we can get the bound service instance */
            serviceReference = mBinderLocal.getMyLocalSercice();
            status = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(ServiceDemoNextPageActivity.this,"On service gets dis-connected",Toast.LENGTH_LONG).show();
            status = false;
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonStartServiceBound :
                serviceReference.startAudio();
                break;

            case R.id.buttonStopServiceBound :
                serviceReference.stopAudio();
                break;

            case R.id.buttonBindServiceBound :
                Intent newIntentBindService = new Intent(this,DemoAudioService.class);
                bindService(newIntentBindService,mServiceConnection, Context.BIND_AUTO_CREATE);
                break;
        }
    }




}
