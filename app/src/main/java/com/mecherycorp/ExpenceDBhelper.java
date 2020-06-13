package com.mecherycorp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class ExpenceDBhelper extends SQLiteOpenHelper {
    public static final String Database_Name = "MoneyManage_DB";
    public static final int Database_version = 1;
    public static final String Create_table = "create table "+ ContractExpence.ExpenceEntry.Table_Name+"("+ ContractExpence.ExpenceEntry.Date+" text,"+ ContractExpence.ExpenceEntry.Amount +" number, "+ ContractExpence.ExpenceEntry.Description +" text,"+ ContractExpence.ExpenceEntry.Catogery +" text);";

    public ExpenceDBhelper(Context context) {
        super(context, Database_Name, null, Database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public void AddExpence(String date, int Amount, String Description, String Catogery,SQLiteDatabase db )
    {

        ContentValues content = new ContentValues();

        content.put(ContractExpence.ExpenceEntry.Date, date);
        content.put(ContractExpence.ExpenceEntry.Amount, Amount);
        content.put(ContractExpence.ExpenceEntry.Description, Description);
        content.put(ContractExpence.ExpenceEntry.Catogery, Catogery);

        db.insert(ContractExpence.ExpenceEntry.Table_Name, null, content);
        Log.d("DataCreated","One raw inserted");



    }
    public Cursor ReadExpence(SQLiteDatabase db){

        String[] projections = {ContractExpence.ExpenceEntry.Date,ContractExpence.ExpenceEntry.Amount,ContractExpence.ExpenceEntry.Description,ContractExpence.ExpenceEntry.Catogery} ;

        Cursor cursor = db.query(ContractExpence.ExpenceEntry.Table_Name, projections, null, null, null, null, null);




        return cursor;
    }

}
