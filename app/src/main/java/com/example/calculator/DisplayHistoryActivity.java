package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayHistoryActivity extends AppCompatActivity {
    ArrayList<String> equationHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_history);

        displayEquationHistory();
    }

    protected void displayEquationHistory()
    {
        extractHistoryFromIntent();
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText("");
        for(String storedString : equationHistory)
        {
            textView.append(storedString);
        }
    }

    protected void extractHistoryFromIntent()
    {
        equationHistory = (ArrayList<String>) getIntent().getSerializableExtra(MainActivity.EXTRA_LIST);
    }
    
}
