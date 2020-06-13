package com.mecherycorp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class IncomeDBhelper extends SQLiteOpenHelper {

    public static final String Database_Name = "MoneyManage_DB";
    public static final int Database_version = 1;
    public static final String Create_table = "create table "+ ContractIncome.IncomeEntry.Table_Name+"("+ ContractIncome.IncomeEntry.Date +" text, "+ ContractIncome.IncomeEntry.Amount + " number, "+ ContractIncome.IncomeEntry.Description+" text, "+ContractIncome.IncomeEntry.Catogery+" text);";


    public IncomeDBhelper(Context context)
    {
        super(context,Database_Name,null,Database_version);
        Log.d("Database", "Database created succesfully");

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Create_table);
        Log.d("Table", "Table created Succesfully");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }

    public void AddIncome(String date, int Amount, String Description, String Catogery,SQLiteDatabase db )
    {
        ContentValues content = new ContentValues();

        content.put(ContractIncome.IncomeEntry.Date, date);
        content.put(ContractIncome.IncomeEntry.Amount, Amount);
        content.put(ContractIncome.IncomeEntry.Description, Description);
        content.put(ContractIncome.IncomeEntry.Catogery, Catogery);

        db.insert(ContractIncome.IncomeEntry.Table_Name, null, content);
        Log.d("DataCreated","One raw inserted");



    }

    public Cursor ReadIncome(SQLiteDatabase db) {

        String[] projections = {ContractIncome.IncomeEntry.Date,ContractIncome.IncomeEntry.Amount,ContractIncome.IncomeEntry.Description,ContractIncome.IncomeEntry.Catogery} ;

        Cursor cursor = db.query(ContractIncome.IncomeEntry.Table_Name, projections, null, null, null, null, null);

        return cursor;

    }



}
