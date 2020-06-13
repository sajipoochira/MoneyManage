package com.mecherycorp;

import android.app.DatePickerDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Income extends Fragment implements DatePickerDialog.OnDateSetListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText  Inc_Amount,  Inc_Desc;
    private Button Inc_Save, Inc_Date;
    private Spinner Inc_Catogery;

    private String mParam1;
    private String mParam2;


    public Income() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_income, container, false);
        Inc_Date = view.findViewById(R.id.Inc_Date);
        Inc_Save = view.findViewById(R.id.Inc_Save);
        Inc_Amount = view.findViewById(R.id.Inc_Amount);
        Inc_Desc = view.findViewById(R.id.Inc_Desc);
        Inc_Catogery = view.findViewById(R.id.Inc_Catogery);

        List<String> CatogeryList = new ArrayList<>();
        CatogeryList.add(0, "Choose Item");

        CatogeryList.add("One");
        CatogeryList.add("Two");

        ArrayAdapter<String> adaptor;

        adaptor = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item,CatogeryList);

        adaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Inc_Catogery.setAdapter(adaptor);

        Inc_Catogery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Inc_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



              //  String Date = "20-11-2018";
                 String Date = Inc_Date.getText().toString();

           //     Log.d("test", Date);
                String Amount = Inc_Amount.getText().toString();
                String Description = Inc_Desc.getText().toString();



           String Catogery = "test";
                //String Catogery = "Test";
                backgroundTask bgtask = new backgroundTask(getActivity());

                bgtask.execute("IncomeAdd",Date,Amount,Description,Catogery );

                Toast.makeText(getActivity(), "Successfully Added", Toast.LENGTH_LONG).show();

                Inc_Date.setText("");
                Inc_Amount.setText("");
                Inc_Desc.setText("");
              //  Inc_Catogery.setText("");


            }
        });


        Inc_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    public void showDatePickerDialog()
    {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        month = month+1;

        String date = dayOfMonth +"-"+ month +"-"+year;

        Inc_Date.setText(date);

    }



}
