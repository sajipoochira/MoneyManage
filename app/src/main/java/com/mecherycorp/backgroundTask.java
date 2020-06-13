package com.mecherycorp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class backgroundTask extends AsyncTask<String,Void,Void> {

    Context ctx;
    String Total;

    backgroundTask(Context ctx)
    {

        this.ctx = ctx;

            }





    @Override
    protected Void doInBackground(String... Param) {

        String Date ;
        String Amount;
        String Description;
        String Catogery ;
        IncomeDBhelper incomeDBhelper;
        ExpenceDBhelper expenceDBhelper;
        Cursor cursor;
        SQLiteDatabase db;


        switch(Param[0])
        {
            case "IncomeAdd" :

                Date =Param[1];
                Amount = Param[2];
                Description = Param[3];
                Catogery = Param[4];


                incomeDBhelper = new IncomeDBhelper(ctx);

                db =  incomeDBhelper.getWritableDatabase();

                incomeDBhelper.AddIncome(Date,Integer.parseInt(Amount),Description,Catogery,db);



                break;
            case "ExpenceAdd" :

                Date =Param[1];
                Amount = Param[2];
                Description = Param[3];
                Catogery = Param[4];

                expenceDBhelper = new ExpenceDBhelper(ctx);

                db = expenceDBhelper.getWritableDatabase();

                expenceDBhelper.AddExpence(Date, Integer.parseInt(Amount), Description, Catogery, db);

                break;






        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }




}
