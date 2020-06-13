package com.mecherycorp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Home.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button Income_Bt, Expence_Bt;
    TextView Income_Total,Expence_Total, Balance_Total;

    public  String Total;



    private OnFragmentInteractionListener mListener;

    public Home() {


        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
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
       View view = inflater.inflate(R.layout.fragment_home, container, false);

        Expence_Bt = view.findViewById(R.id.Expence_Bt);

        Income_Bt = view.findViewById(R.id.Income_Bt);

        Income_Bt.setOnClickListener(this);

        Expence_Bt.setOnClickListener(this);

        Income_Total = view.findViewById(R.id.Income_Total);

        dbReading bgtask = new dbReading();
        bgtask.execute();

        Expence_Total = view.findViewById(R.id.Expence_Total);
        Balance_Total = view.findViewById(R.id.Balance_Total);

        Income_Total.setOnClickListener(this);




        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Income_Bt:
                mListener.onFragmentInteraction(0);
                break;

            case R.id.Expence_Bt:
                mListener.onFragmentInteraction(1);
                break;
            case R.id.Income_Total:
                mListener.onFragmentInteraction(2);
                break;

        }

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(int Selection);
    }



    public class dbReading extends AsyncTask<String,String, HomePageResult> {




        @Override
        protected HomePageResult doInBackground(String... Param) {


            IncomeDBhelper incomeDBhelper;
            ExpenceDBhelper expenceDBhelper;
            Cursor cursor;
            SQLiteDatabase db;
            HomePageResult result = new HomePageResult();




                    incomeDBhelper = new IncomeDBhelper(getActivity());


                    db = incomeDBhelper.getReadableDatabase();

                    cursor = incomeDBhelper.ReadIncome(db);

                    int Incometotal = 0;

                    while (cursor.moveToNext()) {

                        Incometotal = Incometotal + cursor.getInt(cursor.getColumnIndex(ContractIncome.IncomeEntry.Amount));

                    }

            result.setIncomeTotal(Incometotal);




                    expenceDBhelper = new ExpenceDBhelper(getActivity());
                    db = expenceDBhelper.getReadableDatabase();

                    cursor = expenceDBhelper.ReadExpence(db);

                    int Expencetotal = 0;

                    while(cursor.moveToNext())
                    {

                        Expencetotal = Expencetotal + cursor.getInt(cursor.getColumnIndex(ContractIncome.IncomeEntry.Amount));

                    }

                    result.setExpenseTotal(Expencetotal);

                    result.setTotalBalance(Incometotal-Expencetotal);



            return result;
        }

        @Override
        protected void onPostExecute(HomePageResult s) {

            Income_Total.setText(Integer.toString(s.getIncomeTotal()));
            Expence_Total.setText(Integer.toString(s.getExpenseTotal()));

            Balance_Total.setText(Integer.toString(s.getTotalBalance()));
        }
    }
}
