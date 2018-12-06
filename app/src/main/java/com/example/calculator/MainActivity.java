package com.example.calculator;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_LIST = "com.example.calculator.HISTORY";

    ArrayList<String> equationHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equationHistory = new ArrayList<>();
    }

    @Override
    protected void onPause() {
        super.onPause();

        saveHistoryToDatabase();
    }

    protected void saveHistoryToDatabase()
    {
        HistoryDbHelper mDbHelper = new HistoryDbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        for(String storedString : equationHistory) {
            values.put(HistoryDatabaseContract.HistoryDatabase.COLUMN_NAME_STRING, storedString);
            // Insert the new row, returning the primary key value of the new row
            long newRowId = db.insert(HistoryDatabaseContract.HistoryDatabase.TABLE_NAME, null, values);
        }
        db.close();
        equationHistory.clear();
    }

    @Override
    protected void onResume() {
        super.onResume();

        loadHistoryFromDatabaseAndClearIt();
    }

    protected void loadHistoryFromDatabaseAndClearIt()
    {
        HistoryDbHelper mDbHelper = new HistoryDbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

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
            equationHistory.add(cursor.getString(cursor.getColumnIndexOrThrow(HistoryDatabaseContract.HistoryDatabase.COLUMN_NAME_STRING)));
        }
        cursor.close();
        db.delete(HistoryDatabaseContract.HistoryDatabase.TABLE_NAME,null,null);
        db.close();
    }


    public void buttonHistory(View view)
    {
        Intent intent = new Intent(this, DisplayHistoryActivity.class);
        intent.putExtra(EXTRA_LIST, equationHistory);
        startActivity(intent);
    }

    public void buttonClearHistory(View view)
    {
        equationHistory.clear();
        HistoryDbHelper mDbHelper = new HistoryDbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        db.delete(HistoryDatabaseContract.HistoryDatabase.TABLE_NAME,null,null);
        db.close();
}
    public void buttonEquals(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        String equation = textView.getText().toString();
        try
        {
            Expression expression = new ExpressionBuilder(equation).build();
            double evaluation = expression.evaluate();
            String result = Double.toString(evaluation);
            equationHistory.add("Equation: " + equation + "\n");
            equationHistory.add("Result: " + result + "\n");
            textView.setText(result);
        }
        catch(IllegalArgumentException exception)
        {
            textView.setText("");
        }
    }

    public void buttonOne(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.append("1");
    }
    public void buttonTwo(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.append("2");
    }
    public void buttonThree(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.append("3");
    }
    public void buttonFour(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.append("4");
    }
    public void buttonFive(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.append("5");
    }
    public void buttonSix(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.append("6");
    }
    public void buttonSeven(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.append("7");
    }
    public void buttonEight(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.append("8");
    }
    public void buttonNine(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.append("9");
    }
    public void buttonZero(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.append("0");
    }
    public void buttonDot(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.append(".");
    }
    public void buttonClear(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("");
    }
    public void buttonPlus(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.append("+");
    }
    public void buttonMinus(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.append("-");
    }
    public void buttonMultiply(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.append("*");
    }
    public void buttonDivide(View view)
    {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.append("/");
    }
}
