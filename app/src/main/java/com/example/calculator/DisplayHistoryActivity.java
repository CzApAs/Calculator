package com.example.calculator;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_history);

        ArrayList<String> equationHistory = (ArrayList<String>) getIntent().getSerializableExtra(MainActivity.EXTRA_LIST);
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText("");
        for(String storedString : equationHistory)
        {
            textView.append(storedString);
        }
    }

  /*  @Override
    protected void onPause() {
        super.onPause();
        HistoryDbHelper mDbHelper = new HistoryDbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        for(String storedString : equationHistory)
        {
            values.put(HistoryDatabaseContract.HistoryDatabase.COLUMN_NAME_STRING, storedString);
        }
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(HistoryDatabaseContract.HistoryDatabase.TABLE_NAME, null, values);

        db.close();
    }

    @Override
    protected void onResume() {
        super.onResume();

        HistoryDbHelper mDbHelper = new HistoryDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

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
            String historyRecord = cursor.getString(cursor.getColumnIndex(HistoryDatabaseContract.HistoryDatabase.COLUMN_NAME_STRING));
            equationHistory.add(historyRecord);
        }
        cursor.close();
        db.close();
    } */
}
