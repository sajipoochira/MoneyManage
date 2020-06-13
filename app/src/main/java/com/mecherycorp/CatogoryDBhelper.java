package com.mecherycorp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CatogoryDBhelper extends SQLiteOpenHelper {
    public static final String Database_Name = "MoneyManage_DB";
    public static final int Database_version = 1;
    public static final String Create_table = "create table "+ ContractCatogery.CatogeryEntry.Table_Name+"("+ ContractCatogery.CatogeryEntry.CatogeryId+" number ,"+ ContractCatogery.CatogeryEntry.CatogeryName +" text, "+ ContractCatogery.CatogeryEntry.Description +" text);";

    public CatogoryDBhelper(Context context) {
        super(context, Database_Name,null, Database_version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void AddCatogery(String CatogeryName, int CatogeryID, String Description,SQLiteDatabase db  )
    {
        ContentValues values = new ContentValues();
        values.put(ContractCatogery.CatogeryEntry.CatogeryId, CatogeryID);
        values.put(ContractCatogery.CatogeryEntry.CatogeryName, CatogeryName);
        values.put(ContractCatogery.CatogeryEntry.Description, Description);

        db.insert(ContractCatogery.CatogeryEntry.Table_Name, null, values);


    }

    public Cursor ReadCatogery(SQLiteDatabase db  )
    {
        String[] projections = {ContractCatogery.CatogeryEntry.CatogeryName, ContractCatogery.CatogeryEntry.CatogeryId, ContractCatogery.CatogeryEntry.Description};

        Cursor cursor = db.query(ContractCatogery.CatogeryEntry.Table_Name, projections, null, null, null, null, null);

        return cursor;



    }



}
