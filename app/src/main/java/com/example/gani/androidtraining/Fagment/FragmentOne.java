package com.example.gani.androidtraining.Fagment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gani.androidtraining.R;

/**
 * Created by ganeshpatro on 25/03/16.
 */
public class FragmentOne extends Fragment {

    ListView listView;
    ArrayAdapter<String> arrayAdapter;

    String[] arrStrings = {"Ganesh Patro .. The Happyboy","Mobile Team","Virag Bro","Alok D"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_one,container,false);

        //Set Up list view
        listView = (ListView) view.findViewById(R.id.listViewInFragment);

        //Make Array Adapter
        arrayAdapter = new ArrayAdapter<String>(getActivity(),R.layout.list_row,R.id.txtViewRow,arrStrings);

        //Set Adapter
        listView.setAdapter(arrayAdapter);

        return view;
    }
}
