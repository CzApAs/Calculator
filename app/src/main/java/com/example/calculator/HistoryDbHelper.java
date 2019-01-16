package com.example.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;

public class HistoryDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";


    public HistoryDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(HistoryDatabaseContract.HistoryDatabase.SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(HistoryDatabaseContract.HistoryDatabase.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void clearDatabase()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(HistoryDatabaseContract.HistoryDatabase.TABLE_NAME,null,null);
        db.close();
    }

    public void insertList(ArrayList<String> stringList)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        for(String storedString : stringList) {
            values.put(HistoryDatabaseContract.HistoryDatabase.COLUMN_NAME_STRING, storedString);
            // Insert the new row, returning the primary key value of the new row
            long newRowId = db.insert(HistoryDatabaseContract.HistoryDatabase.TABLE_NAME, null, values);
        }
        db.close();
    }

    public ArrayList<String> getList()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<String> listToReturn = new ArrayList<>();

        String[] projection = {
                BaseColumns._ID,
                HistoryDatabaseContract.HistoryDatabase.COLUMN_NAME_STRING,
        };

        Cursor cursor = db.query(
                HistoryDatabaseContract.HistoryDatabase.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );

        while(cursor.moveToNext()) {
            listToReturn.add(cursor.getString(cursor.getColumnIndexOrThrow(HistoryDatabaseContract.HistoryDatabase.COLUMN_NAME_STRING)));
        }
        cursor.close();
        db.close();

        return listToReturn;
    }


}
