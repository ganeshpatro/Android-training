package com.example.gani.androidtraining.Fagment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gani.androidtraining.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentsHomeActivityFragment extends Fragment {

    public FragmentsHomeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragments_home, container, false);
    }
}
