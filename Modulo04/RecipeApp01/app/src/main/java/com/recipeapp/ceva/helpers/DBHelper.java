package com.recipeapp.ceva.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.recipeapp.ceva.SQLConstants;

/**
 * Clase que nos ayuda crear la BD
 */
public class DBHelper extends SQLiteOpenHelper
{
    public static final int DB_VERSION = 1;

    public DBHelper(Context context)
    {
        super(context, SQLConstants.DB, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLConstants.SQL_CREATE_TABLE_RECETAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQLConstants.SQL_DROP_TABLE);
        onCreate(db);
    }
}
