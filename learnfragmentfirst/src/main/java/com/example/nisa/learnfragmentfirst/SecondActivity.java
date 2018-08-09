package com.example.nisa.learnfragmentfirst;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nisa.learnfragmentfirst.fragments.FourthFragment;
import com.example.nisa.learnfragmentfirst.fragments.InputBottomSheetFragment;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener, FourthFragment.OnSubmitButtonListener, InputBottomSheetFragment.OnSubmitButtonListener {

    TextView nameTV, addressTV, birthDayTV;
    Button inputButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameTV = findViewById(R.id.nama_textview);
        addressTV = findViewById(R.id.alamat_textview);
        birthDayTV = findViewById(R.id.tanggallahir_textview);
        inputButton = findViewById(R.id.input_button);
        inputButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.input_button:
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                FourthFragment fourthFragment = FourthFragment.newInstance(nameTV.getText().toString(), addressTV.getText().toString(), birthDayTV.getText().toString());
                transaction.replace(android.R.id.content, fourthFragment);
                transaction.addToBackStack(null);

                transaction.commit();
                break;
        }
    }

    @Override
    public void onSubmitButton(String name, String address, String birthday) {
        nameTV.setText(name);
        addressTV.setText(address);
        birthDayTV.setText(birthday);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.input_main_menu:

                InputBottomSheetFragment inputBottomSheetFragment = InputBottomSheetFragment.newInstance(nameTV.getText().toString(), addressTV.getText().toString(), birthDayTV.getText().toString());
                inputBottomSheetFragment.show(getSupportFragmentManager(), "input bottom sheet");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
