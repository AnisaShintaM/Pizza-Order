package com.example.nisa.learnfragmentfirst.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nisa.learnfragmentfirst.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment implements View.OnClickListener {
    Button firstButton, secondButton, thirdButton;


    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_base, container, false);

        firstButton = view.findViewById(R.id.button_firstfragment);
        secondButton = view.findViewById(R.id.button_secondfragment);
        thirdButton = view.findViewById(R.id.button_thirdfragment);

        firstButton.setOnClickListener(this);
        secondButton.setOnClickListener(this);
        thirdButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.button_firstfragment:
                fragment = new FirstFragment();
                break;

            case R.id.button_secondfragment:
                fragment = new SecondFragment();
                break;

            case R.id.button_thirdfragment:
                fragment = new ThirdFragment();
                break;
        }

        transaction.add(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
