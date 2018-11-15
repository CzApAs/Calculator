package com.example.calculator;

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

        ArrayList<String> history = (ArrayList<String>) getIntent().getSerializableExtra(MainActivity.EXTRA_LIST);
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setMovementMethod(new ScrollingMovementMethod());
        for(String storedString : history)
        {
            textView.append(storedString);
        }
    }
}
