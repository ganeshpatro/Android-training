package com.example.gani.androidtraining.Fagment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.gani.androidtraining.HomeActivity;
import com.example.gani.androidtraining.R;

public class FragmentsHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_container);

        Button btnClickMe = (Button)findViewById(R.id.btnClickMe);
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newHomeIntent = new Intent(FragmentsHomeActivity.this,FragmentsHomeAddReplaceActivity.class);
                startActivity(newHomeIntent);
            }
        });

    }

}
