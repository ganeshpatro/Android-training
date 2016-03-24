package com.example.gani.androidtraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_list_item_1;

public class HomeActivity extends AppCompatActivity {

    private String ACTIVITY = "Activity";
    private String CUSTOM_LIST_VIEW = "Custom List View + Json Parsing + Pagination";
    private String ACTIVITY = "Activity";
    private String ACTIVITY = "Activity";
    private String ACTIVITY = "Activity";
    private String ACTIVITY = "Activity";


    private String[] arrChapters = {ACTIVITY,"","Fragments"};

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Find the list view
        listView = (ListView) findViewById(R.id.listViewHome);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                simple_list_item_1, android.R.id.text1, arrChapters);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }
}
