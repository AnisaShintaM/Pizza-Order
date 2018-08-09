package com.example.nisa.testfragment.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nisa.testfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OutputFragment extends Fragment {


    public OutputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_output, container, false);
    }

}
