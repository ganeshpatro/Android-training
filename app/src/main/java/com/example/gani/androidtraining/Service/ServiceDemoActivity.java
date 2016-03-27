package com.example.gani.androidtraining.Service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gani.androidtraining.R;

public class ServiceDemoActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnStartService, btnStopService, btnNextpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);

        //instantiate buttons
        btnStartService = (Button) findViewById(R.id.buttonStartService);
        btnStopService = (Button) findViewById(R.id.buttonStopService);
        btnNextpage = (Button) findViewById(R.id.buttonNextPage);

        //Set OnClickListeners
        btnStartService.setOnClickListener(this);
        btnStopService.setOnClickListener(this);
        btnNextpage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonStartService :
                Intent newIntent = new Intent(this,DemoAudioService.class);
                startService(newIntent);
                break;

            case R.id.buttonStopService :
                Intent newIntentToStop = new Intent(this,DemoAudioService.class);
                stopService(newIntentToStop);
                break;

            case R.id.buttonNextPage :
                Intent newIntentNextPage = new Intent(this,ServiceDemoNextPageActivity.class);
                startActivity(newIntentNextPage);
                break;
        }
    }
}
