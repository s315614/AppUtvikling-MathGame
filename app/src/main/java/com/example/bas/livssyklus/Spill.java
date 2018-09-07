package com.example.bas.livssyklus;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Spill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spill);


        final TextView inputText = (TextView)findViewById(R.id.inputTxt);
        final TextView outputText = (TextView)findViewById(R.id.outputTxt);


        int x =  (int)randomNumber(1,25);

        Resources res = getResources();
        String[] questions;
        questions = res.getStringArray(R.array.questions);
        outputText.setText(questions[x]);


        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "1");

            }
        });

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "2");

            }
        });

        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "3");

            }
        });

        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "4");

            }
        });

        Button button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "5");

            }
        });

        Button button6 = (Button)findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "6");

            }
        });


        Button button7 = (Button)findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "7");

            }
        });

        Button button8 = (Button)findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "8");

            }
        });

        Button button9 = (Button)findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "9");

            }
        });

        Button button0 = (Button)findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "0");

            }
        });


        Button buttonSlett = (Button)findViewById(R.id.buttonSlett);
        buttonSlett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // inputText.setText("");
                String backspace = null;
                if (inputText.getText().length() > 0){
                    StringBuilder strB = new StringBuilder(inputText.getText());
                    strB.deleteCharAt(inputText.getText().length()-1);
                    backspace = strB.toString();
                    inputText.setText(backspace);
                }
            }
        });

        Button buttonSvar = (Button)findViewById(R.id.buttonSvar);
        buttonSvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText("");
                int x =  (int)randomNumber(1,25);

                Resources res = getResources();
                String[] questions;
                questions = res.getStringArray(R.array.questions);

                outputText.setText(questions[x]);
            }
        });



    }
    public static int randomNumber(int min, int max){
       Random rand = new Random();
       return rand.nextInt((max - min) +1)+min;
    }

}
