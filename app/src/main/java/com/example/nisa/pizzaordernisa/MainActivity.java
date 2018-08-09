package com.example.nisa.pizzaordernisa;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nisa.pizzaordernisa.utilitiy.Constant;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    ImageButton imageButtonSilang;
    EditText namaET;
    String firstString;
    CheckBox basicCB, standarCB, doubleCB;
    RadioGroup basicRG, standarRG, doubleRG;
    RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8, rb9;
    String pizzaBasic = "";
    String pizzaStand = "";
    String pizzaDouble = "";
    Button submitBtn;
    Button orderBtn;
    ImageButton silangBtn;
    String selectedItem1, selectedItem2, selectedItem3;
    TextView tvHasil;

    Switch aSwitch;
    String switchUp;

    String menus = "";
    ArrayList<String> listMenu = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButtonSilang = findViewById(R.id.buttonSilang);
        namaET = findViewById(R.id.editTextNama);

        silangBtn = findViewById(R.id.buttonSilang);
        submitBtn = findViewById(R.id.buttonSubmit);
        orderBtn = findViewById(R.id.buttonorder);

        basicCB = findViewById(R.id.checkboxbasic);
        standarCB = findViewById(R.id.checkboxstandar);
        doubleCB = findViewById(R.id.checkboxdouble);

        basicRG = findViewById(R.id.radiogroupbasic);
        standarRG = findViewById(R.id.radiogroupstandar);
        doubleRG = findViewById(R.id.radiogroupdouble);

        rb1 = findViewById(R.id.radiobuttonsmallbasic);
        rb2 = findViewById(R.id.radiobuttonmediumbasic);
        rb3 = findViewById(R.id.radiobuttonlargebasic);
        rb4 = findViewById(R.id.radiobuttonsmallstandar);
        rb5 = findViewById(R.id.radiobuttonmediumstandar);
        rb6 = findViewById(R.id.radiobuttonlargestandar);
        rb7 = findViewById(R.id.radiobuttonsmalldouble);
        rb8 = findViewById(R.id.radiobuttonmediumdouble);
        rb9 = findViewById(R.id.radiobuttonlargedouble);

        aSwitch = findViewById(R.id.switchupsize);

        basicRG.setOnCheckedChangeListener(this);
        standarRG.setOnCheckedChangeListener(this);
        doubleRG.setOnCheckedChangeListener(this);
        ((RadioButton) findViewById(R.id.radiobuttonsmallbasic)).setChecked(true);

        basicCB.setOnCheckedChangeListener(this);
        standarCB.setOnCheckedChangeListener(this);
        doubleCB.setOnCheckedChangeListener(this);

        aSwitch.setOnCheckedChangeListener(this);

        silangBtn.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        orderBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {
            case R.id.buttonSilang:
                namaET.setText("");
                basicCB.setEnabled(false);
                standarCB.setEnabled(false);
                doubleCB.setEnabled(false);
                rb1.setEnabled(false);
                rb2.setEnabled(false);
                rb3.setEnabled(false);
                rb4.setEnabled(false);
                rb5.setEnabled(false);
                rb6.setEnabled(false);
                rb7.setEnabled(false);
                rb8.setEnabled(false);
                rb9.setEnabled(false);
                break;

            case R.id.buttonSubmit:
                firstString = namaET.getText().toString();
                if (TextUtils.isEmpty(firstString)) {
                    Toast.makeText(this, "Mohon isi Nama", Toast.LENGTH_SHORT).show();
                } else {
                    basicCB.setEnabled(true);
                    standarCB.setEnabled(true);
                    doubleCB.setEnabled(true);
                }

                aSwitch.setEnabled(true);
                orderBtn.setEnabled(true);
                break;
            case R.id.buttonorder:
                firstString = namaET.getText().toString();

                if (!TextUtils.isEmpty(firstString)) {
                    menus = "";
                    for (int i = 0; i < listMenu.size(); i++) {
                        menus = menus + " " + listMenu.get(i);
                    }
                    //tvHasil.setText("Welcome " +firstString+ " "+"\nOrder :"+" "+listMenu+ " "+"\nUkuran :"+" "+selectedItem);
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                    alertDialog.setTitle("Confirm").setCancelable(false).setMessage("Are u sure?")
                            .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String result = "Welcome " + firstString + " " + "\nOrder :" + " " + listMenu + " " + "\nUkuran :" + " " + selectedItem1 + selectedItem2 + selectedItem3 + " " + "\nEkstra?" + " " + switchUp;

                                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                                    intent.putExtra(Constant.KEY_RESULT, result);
                                    startActivity(intent);
                                }
                            })
                            .setNegativeButton("NO", null).show();
                }


                break;
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();
        switch (id) {
            case R.id.checkboxbasic:
                if (isChecked) {
                    listMenu.add("Basic Pizza");
                    rb1.setEnabled(true);
                    rb2.setEnabled(true);
                    rb3.setEnabled(true);
                } else {
                    listMenu.remove("Basic Pizza");

                }
                break;

            case R.id.checkboxstandar:
                if (isChecked) {
                    listMenu.add("Standart Pizza");
                    rb4.setEnabled(true);
                    rb5.setEnabled(true);
                    rb6.setEnabled(true);

                } else {
                    listMenu.remove("Standart Pizza");

                }
                break;
            case R.id.checkboxdouble:
                if (isChecked) {
                    listMenu.add("Double Pizza");
                    rb7.setEnabled(true);
                    rb8.setEnabled(true);
                    rb9.setEnabled(true);
                } else {
                    listMenu.remove("Double Pizza");

                }
                break;

            case R.id.switchupsize:
                switchUp = "" + isChecked;
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radiobuttonsmallbasic:
                selectedItem1 = "Small ";
                break;
            case R.id.radiobuttonmediumbasic:
                selectedItem1 = "Medium ";
                break;
            case R.id.radiobuttonlargebasic:
                selectedItem1 = "LARGE ";
                break;
            case R.id.radiobuttonsmallstandar:
                selectedItem2 = "SMALL ";
                break;
            case R.id.radiobuttonmediumstandar:
                selectedItem2 = "Medium ";
                break;
            case R.id.radiobuttonlargestandar:
                selectedItem2 = "LARGE ";
                break;
            case R.id.radiobuttonsmalldouble:
                selectedItem3 = "SMALL ";
                break;
            case R.id.radiobuttonmediumdouble:
                selectedItem3 = "Medium ";
                break;
            case R.id.radiobuttonlargedouble:
                selectedItem3 = "LARGE ";
                break;

        }
    }
}
