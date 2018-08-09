package com.example.nisa.learnfragmentfirst;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.nisa.learnfragmentfirst.fragments.BaseFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BaseFragment baseFragment = new BaseFragment();
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, baseFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
