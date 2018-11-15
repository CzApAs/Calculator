package com.example.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_LIST = "com.example.calculator.HISTORY";
    ArrayList<String> equationHistory = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
