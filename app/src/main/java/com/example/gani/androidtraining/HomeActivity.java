package com.example.gani.androidtraining;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

import com.example.gani.androidtraining.Fagment.FragmentsHomeActivity;
import com.example.gani.androidtraining.Service.ServiceDemoActivity;

import java.util.ArrayList;
import java.util.List;

import static android.R.layout.simple_list_item_1;

public class HomeActivity extends AppCompatActivity {

    private final String ACTIVITY = "Activity";
    private String CUSTOM_LIST_VIEW = "Custom List View + Json Parsing + Pagination";
    private final String FRAGMENTS = "Fragments Basic + Example";
    private final String SERVICES = "Service";
    private final String BROADCAST_RECIVER = "Broadcast receiver";

    private final String[] arrChapters = {ACTIVITY,CUSTOM_LIST_VIEW,FRAGMENTS,SERVICES,BROADCAST_RECIVER};

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//      //  setSupportActionBar(toolbar);
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//       // drawer.setDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);


        //Find the list view
        listView = (ListView) findViewById(R.id.listViewHome);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                simple_list_item_1, android.R.id.text1, arrChapters);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String strSelectedRow = arrChapters[i];
                switch (strSelectedRow) {
                    case FRAGMENTS:
                        Intent newActivity = new Intent(HomeActivity.this, FragmentsHomeActivity.class);
                        startActivity(newActivity);
                        break;

                    case SERVICES:
                        Intent newActivityService = new Intent(HomeActivity.this, ServiceDemoActivity.class);
                        startActivity(newActivityService);
                        break;

                    case BROADCAST_RECIVER:
                        Intent newActivityBroadCastService = new Intent(HomeActivity.this, ServiceDemoActivity.class);
                        startActivity(newActivityService);
                        break;
                }
            }
        });
    }


//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.dasboard, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }


}
