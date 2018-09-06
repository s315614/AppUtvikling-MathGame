package com.example.bas.livssyklus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Spill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spill);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                int number1 = 1;
                numberEntered.setText(number1 + "");
            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                int number2 = 2;
                numberEntered.setText(number2 + "");
            }
        });
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                int number3 = 3;
                numberEntered.setText(number3 + "");
            }
        });
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                int number4 = 4;
                numberEntered.setText(number4 + "");
            }
        });
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                int number5 = 5;
                numberEntered.setText(number5 + "");
            }
        });
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                int number6 = 6;
                numberEntered.setText(number6 + "");
            }
        });
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                int number7 = 7;
                numberEntered.setText(number7 + "");
            }
        });
        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                int number8 = 8;
                numberEntered.setText(number8 + "");
            }
        });
        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                int number9 = 9;
                int textInt = Integer.valueOf(numberEntered.getText().toString());
                numberEntered.setText(String.valueOf(textInt+""+number9));
                //numberEntered.setText(number9 + "");
            }
        });
        Button button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEntered = (EditText) findViewById(R.id.numberEntered);
                int number0 = 0;
                int textInt = Integer.valueOf(numberEntered.getText().toString());
                numberEntered.setText(String.valueOf(textInt+""+number0));
            }
        });

        Button backButton = (Button) findViewById(R.id.backButton);
        Button enterButton = (Button) findViewById(R.id.enterButton);
    }
}
