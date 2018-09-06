package com.example.bas.livssyklus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;

public class Spill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spill);

        final SparseArray<String> keyValues = new SparseArray<>();
        final InputConnection inputConnection;

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                String number1 = "1";
                numberEntered.setText(number1 + "");
            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                String number2 = "2";
                numberEntered.setText(number2 + "");
            }
        });
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                String number3 = "3";
                numberEntered.setText(number3 + "");
            }
        });
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                String number4 = "4";
                numberEntered.setText(number4 + "");
            }
        });
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                String number5 = "5";
                numberEntered.setText(number5 + "");
            }
        });
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                String number6 = "6";
                numberEntered.setText(number6 + "");
            }
        });
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                String number7 = "7";
                numberEntered.setText(number7 + "");
            }
        });
        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                String number8 = "8";
                numberEntered.setText(number8 + "");
            }
        });
        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                String number9 = "9";
                //int textInt = Integer.valueOf(numberEntered.getText().toString());
              //  numberEntered.setText(String.valueOf(textInt+""+number9));
                numberEntered.setText(number9);
            }
        });
        Button button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                keyValues.put(R.id.button0,"0");
               // String number0 = "0";
               // numberEntered.setText(number0);
                //int textInt = Integer.valueOf(numberEntered.getText().toString());
                //numberEntered.setText(String.valueOf(textInt+""+number0));
            }
        });

        Button backButton = (Button) findViewById(R.id.backButton);
        Button enterButton = (Button) findViewById(R.id.enterButton);

        keyValues.put(R.id.button1,"1");
        keyValues.put(R.id.button2,"2");
        keyValues.put(R.id.button3,"3");
        keyValues.put(R.id.button4,"4");
        keyValues.put(R.id.button5,"5");
        keyValues.put(R.id.button6,"6");
        keyValues.put(R.id.button7,"7");
        keyValues.put(R.id.button8,"8");
        keyValues.put(R.id.button9,"9");


    }
}
