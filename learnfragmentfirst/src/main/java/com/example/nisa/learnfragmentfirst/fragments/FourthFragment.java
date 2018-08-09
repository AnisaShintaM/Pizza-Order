package com.example.nisa.learnfragmentfirst.fragments;


import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nisa.learnfragmentfirst.R;
import com.example.nisa.learnfragmentfirst.utility.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class FourthFragment extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {


    EditText nameET, addressET;
    //datepicker
    TextView birthdayTV;
    ImageView dateIV;
    Button submitBTN;
    OnSubmitButtonListener listener;
    //datepicker
    DatePickerDialog datePickerDialog;

    public FourthFragment() {
        // Required empty public constructor
    }

    public static FourthFragment newInstance(String name, String address, String birthday) {
        FourthFragment fourthFragment = new FourthFragment();

        Bundle bundle = new Bundle();
        bundle.putString("nama", name);
        bundle.putString("address", address);
        bundle.putString("birthday", birthday);
        fourthFragment.setArguments(bundle);

        return fourthFragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fourth, container, false);


        nameET = view.findViewById(R.id.nama_edittext);
        addressET = view.findViewById(R.id.alamat_edittext);
        //datepicker
        birthdayTV = view.findViewById(R.id.date_textview);
        dateIV = view.findViewById(R.id.date_imageview);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");

        submitBTN = view.findViewById(R.id.submit_button);
        if (getArguments() != null) {
            nameET.setText(getArguments().getString("nama", ""));
            addressET.setText(getArguments().getString("address", ""));
            birthdayTV.setText(getArguments().getString("birthday", ""));
        }

        //datepicker
        int year = 2000;
        int month = 0;
        int day = 1;
        String selectedDate = birthdayTV.getText().toString();

        if (!selectedDate.equalsIgnoreCase("")) {
            c.setTime(DateUtils.dateToString("dd MMMM yyyy", selectedDate));
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
        }

        datePickerDialog = new DatePickerDialog(getActivity(), this, year, month, day);

        submitBTN.setOnClickListener(this);

        //datepicker
        dateIV.setOnClickListener(this);
        return view;


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_button:
                listener.onSubmitButton(nameET.getText().toString(), addressET.getText().toString(), birthdayTV.getText().toString());
                getActivity().getSupportFragmentManager().popBackStack();
                break;

            //datepicker
            case R.id.date_imageview:
                datePickerDialog.show();
                break;
        }
    }

    //datepicker
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + " " + (month + 1) + " " + year;
        birthdayTV.setText(DateUtils.formatDate("dd MM yyyy", "dd MMMM yyyy", date));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSubmitButtonListener) {
            listener = (OnSubmitButtonListener) context;
        } else {
            throw new RuntimeException(context.toString() + " activity harus implement interface OnSubmitButtonListener");
        }
    }

    public interface OnSubmitButtonListener {
        void onSubmitButton(String name, String address, String birthday);
    }
}
