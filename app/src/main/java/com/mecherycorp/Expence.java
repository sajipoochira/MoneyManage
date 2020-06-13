package com.mecherycorp;

import android.app.DatePickerDialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Expence.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Expence#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Expence extends Fragment implements DatePickerDialog.OnDateSetListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private EditText Exp_Amount,  Exp_Desc;
    private Button Exp_Save, Exp_Date, Exp_Catogery;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public Expence() {
        // Required empty public constructor
    }


    public static Expence newInstance(String param1, String param2) {
        Expence fragment = new Expence();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        View view = inflater.inflate(R.layout.fragment_expence, container, false);
        Exp_Date = view.findViewById(R.id.Exp_Date);
        Exp_Save = view.findViewById(R.id.Exp_Save);
        Exp_Amount = view.findViewById(R.id.Exp_Amount);
        Exp_Desc = view.findViewById(R.id.Exp_Desc);
        Exp_Catogery = view.findViewById(R.id.Exp_Catogery);

      Exp_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Date = Exp_Date.getText().toString();


                String Amount = Exp_Amount.getText().toString();
                String Description = Exp_Desc.getText().toString();
                String Catogery = Exp_Catogery.getText().toString();

                backgroundTask bgtask = new backgroundTask(getActivity());

                bgtask.execute("ExpenceAdd",Date,Amount,Description,Catogery );

                Toast.makeText(getActivity(), "Successfully Added", Toast.LENGTH_LONG).show();

                Exp_Date.setText("");
                Exp_Amount.setText("");
                Exp_Desc.setText("");
                Exp_Catogery.setText("");



            }
        });
        Exp_Date.setOnClickListener(new View.OnClickListener() {
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

        Exp_Date.setText(date);
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
