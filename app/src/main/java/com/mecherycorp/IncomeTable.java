package com.mecherycorp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class IncomeTable extends Fragment {

    RecyclerView IncomTableview ;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdaptor adapter;
    ReadIncometask loadRecyclerView;


    public IncomeTable() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_income_table, container, false);

        IncomTableview = view.findViewById(R.id.Table_view);
        layoutManager = new LinearLayoutManager(getActivity());
        IncomTableview.setLayoutManager(layoutManager);

        loadRecyclerView = new ReadIncometask();



        loadRecyclerView.execute();






        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    public class ReadIncometask extends AsyncTask<Void,List,List<IncomeData>>
    {
        ArrayList<IncomeData> list = new ArrayList<>();
        IncomeData incomeData;




        @Override
        protected List doInBackground(Void... voids) {
            IncomeDBhelper incomeDBhelper;

            Cursor cursor;
            SQLiteDatabase db;
            list = new ArrayList<>();

            incomeDBhelper = new IncomeDBhelper(getActivity());


            db = incomeDBhelper.getReadableDatabase();

            cursor = incomeDBhelper.ReadIncome(db);




            while (cursor.moveToNext()) {

                incomeData = new IncomeData(cursor.getString(cursor.getColumnIndex(ContractIncome.IncomeEntry.Date)),cursor.getInt(cursor.getColumnIndex(ContractIncome.IncomeEntry.Amount)),cursor.getString(cursor.getColumnIndex(ContractIncome.IncomeEntry.Description)),cursor.getString(cursor.getColumnIndex(ContractIncome.IncomeEntry.Catogery)));

                list.add(incomeData);

            }

            return list;

        }




        @Override
        protected void onPostExecute(List<IncomeData> list) {


            adapter = new RecyclerAdaptor(list);

            IncomTableview.setAdapter(adapter);


        }
    }


}
