package com.example.bas.livssyklus;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Spill extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spill);

        final TextView inputText = (TextView) findViewById(R.id.inputTxt);
        final TextView outputText = (TextView) findViewById(R.id.outputTxt);

        Resources res = getResources();
        final String[] questions  = res.getStringArray(R.array.questions);
        final String[] answers  = res.getStringArray(R.array.answers);
        final ArrayList<Integer> list = new ArrayList<>();
        final SharedPreferences prefs = getSharedPreferences("Modus", MODE_PRIVATE);
        final int mode = prefs.getInt("Mode", 25);

        generateAtStart(list,questions,outputText);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "1");

            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "2");

            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "3");

            }
        });

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "4");

            }
        });

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "5");

            }
        });

        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "6");

            }
        });


        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "7");

            }
        });

        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "8");

            }
        });

        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "9");

            }
        });

        Button button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText() + "0");
            }
        });

        Button buttonSlett = (Button) findViewById(R.id.buttonSlett);
        buttonSlett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = String.valueOf(inputText.getText());
                int length = str.length();
                if (length > 0) inputText.setText(str.substring(0, length - 1));

            }
        });


        Button buttonSvar = (Button) findViewById(R.id.buttonSvar);
        final TextView riktigText = (TextView)findViewById(R.id.riktigText);
        final TextView galtText = (TextView)findViewById(R.id.galtText);
        final TextView stageText = (TextView)findViewById(R.id.stageTxt);
        stageText.setText(String.valueOf("Stage 1/"+String.valueOf(mode)));

        buttonSvar.setOnClickListener(new View.OnClickListener() {

            int stage = 1;
            int riktig = 0;
            int galt = 0;

            @Override
            public void onClick(View v) {

                if(validationSuccess(inputText)){
                    if(stage < mode){
                        int a = generateRandomInt(list);
                        boolean check = checkQuestion(inputText, answers, list, riktigText,galtText);
                        if(check){
                            riktig+=1;
                        }else galt+=1;

                        questionUpdate(outputText, questions,a, inputText);
                        //Toast.makeText(Spill.this,String.valueOf("Riktig: "+ riktig+" Galt: "+galt),Toast.LENGTH_LONG).show();
                        //Toast.makeText(Spill.this,String.valueOf(String.valueOf(mode)),Toast.LENGTH_LONG).show();
                        stage +=1;
                        stageText.setText(String.valueOf("Stage "+stage+ "/"+String.valueOf(mode)));

                    }

                    else if(stage==mode){
                        int a = generateRandomInt(list);
                        boolean check = checkQuestion(inputText, answers, list, riktigText,galtText);
                        if(check){
                            riktig+=1;
                        }else galt+=1;
                        list.remove(list.size()-1);
                        lagreDataene(riktig,galt);
                        Intent goToResultat = new Intent(getApplicationContext(), Resultat.class);
                        startActivity(goToResultat);
                        finish();

                    }

                    else{
                        Toast.makeText(Spill.this,String.valueOf("Ferdig!"),Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(Spill.this, "You have to answear!", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        //Toast.makeText(getApplication(),"Hello",Toast.LENGTH_LONG).show();
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        String exit = getResources().getString(R.string.exit);
        String exitTekst = getResources().getString(R.string.exit_tekst);
        String avslutt = getResources().getString(R.string.avslutt);
        String avbryt = getResources().getString(R.string.avbryt);

        builder.setTitle(exit);
        builder.setMessage(exitTekst);


        builder.setPositiveButton(avslutt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent goToMain = new Intent(getApplicationContext(), Hoved.class);
                startActivity(goToMain);
                finish();
            }

        });
        builder.setNegativeButton(avbryt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.show();
    }

    public void lagreDataene(int riktig, int galt){
        SharedPreferences prefs = getApplication().getSharedPreferences("Resultat",MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("antallRiktig", riktig);
        editor.putInt("antallGalt", galt);
        editor.commit();

    }

    public boolean validationSuccess(TextView text){
        boolean check;
        if(text.getText().toString() != "") {
            check = true;
        }else{
            check = false;
        }
        return check;
    }


    public boolean checkQuestion(TextView input, String[] svarliste, ArrayList<Integer> list, TextView riktigText, TextView galtText){
        boolean check;
        int svar = Integer.parseInt(String.valueOf(input.getText()));
        int sjekkSvar = Integer.parseInt(svarliste[list.get(list.size()-2)]);

        if(svar == sjekkSvar){
            check = true;
            riktigText.setText(String.valueOf(Integer.parseInt(String.valueOf(riktigText.getText()))+1));

        }else{
            check = false;
            galtText.setText(String.valueOf(Integer.parseInt(String.valueOf(galtText.getText()))+1));

        }
        return check;
    }

    public void questionUpdate(TextView text, String[] array, int value, TextView input) {
        text.setText(String.valueOf(array[value]));
        input.setText(String.valueOf(""));

    }

    public int generateRandomInt(ArrayList<Integer> list) {
        int value = generateRandomInt();
        while(existBefore(list, value)){
            value = generateRandomInt();
        }
        list.add(value);
        return value;
    }

    public boolean existBefore(ArrayList<Integer> list, int number) {
        if(list.contains(number))return true;
        return false;
    }

    public int generateRandomInt() {
        Random r = new Random();
        int value = r.nextInt((25 - 0) + 1) + 0;
        return value;
    }

    public void generateAtStart(ArrayList<Integer>list, String[] array, TextView text){
        int tall = generateRandomInt();
        list.add(tall);
        text.setText(String.valueOf(array[tall]));
    }


}

