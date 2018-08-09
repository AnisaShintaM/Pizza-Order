package com.example.nisa.pizzaordernisa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.nisa.pizzaordernisa.utilitiy.Constant;

public class ResultActivity extends AppCompatActivity {

    TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultTV = findViewById(R.id.tvHasil);
        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            resultTV.setText(bundle.getString(Constant.KEY_RESULT, ""));
        }
    }
}
