package com.example.bas.livssyklus;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Spill extends AppCompatActivity {

    TextView riktigText, galtText, stageText, inputText, outputText;
    int stage;
    int galt;
    int riktig;
    ArrayList<Integer> list = new ArrayList<>();
    MediaPlayer mpCorrect, mpWrong;
    Dialog wrongDialog, correctDialog;
    SharedPreferences prefs;
    String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = getSharedPreferences("Resultat",MODE_PRIVATE);
        language = prefs.getString("lan","");

        Toast.makeText(this,language,Toast.LENGTH_LONG).show();

        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());

        setContentView(R.layout.activity_spill);

        inputText = (TextView) findViewById(R.id.inputTxt);
        outputText = (TextView) findViewById(R.id.outputTxt);
        mpCorrect = MediaPlayer.create(this, R.raw.soundright);
        mpWrong = MediaPlayer.create(this, R.raw.soundwrong);
        correctDialog = displayCorrectDialog();
        wrongDialog = displayWrongDialog();

        Resources res = getResources();
        final String[] questions  = res.getStringArray(R.array.questions);
        final String[] answers  = res.getStringArray(R.array.answers);
        final SharedPreferences prefs = getSharedPreferences("Modus", MODE_PRIVATE);
        final int mode = prefs.getInt("Mode", 5);

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
        riktigText = (TextView)findViewById(R.id.riktigText);
        galtText = (TextView)findViewById(R.id.galtText);
        stageText = (TextView)findViewById(R.id.stageTxt);
        stageText.setText(String.valueOf("Stage 1/"+String.valueOf(mode)));
        stage = 1;


        buttonSvar.setOnClickListener(new View.OnClickListener() {
            int a;

            @Override
            public void onClick(View v) {


                if(validationSuccess(inputText)){
                    if(stage < mode){
                        a = generateRandomInt(list);
                        boolean check = checkQuestion(inputText, answers, list, riktigText,galtText);
                        if(check){
                            riktig +=1;
                            audioPlaying(mpCorrect);
                            correctDialog.show();

                            new CountDownTimer(2000, 1000) {

                                @Override
                                public void onTick(long millisUntilFinished){};

                                @Override
                                public void onFinish() {
                                    correctDialog.dismiss();

                                }
                            }.start();


                        }else{
                            galt+=1;
                            audioPlaying(mpWrong);
                            wrongDialog.show();


                            new CountDownTimer(2000, 1000) {
                                Dialog d = displayWrongDialog();
                                @Override
                                public void onTick(long millisUntilFinished){};

                                @Override
                                public void onFinish() {

                                    wrongDialog.dismiss();

                                }
                            }.start();
                        }

                        questionUpdate(outputText, questions,a, inputText);
                        stage +=1;
                        stageText.setText(String.valueOf("Stage "+stage+ "/"+String.valueOf(mode)));

                    }

                    else if(stage==mode){
                        int a = generateRandomInt(list);
                        boolean check = checkQuestion(inputText, answers, list, riktigText,galtText);
                        if(check){
                            riktig+=1;
                            audioPlaying(mpCorrect);
                        }else{
                            galt+=1;
                            audioPlaying(mpWrong);
                        }
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

    //Override metode som tilkaller en AlertDialog når man trykker på tilbakeknappen(onBackPressed())
    //På AlertDialog så kommer det opp to alternativsknapper(positiv/negativ)
    //Om man trykker på negativ så fjerner man AlertDialog og ingenting annet skjer
    //Dersom man trykker på positiv så blir en ny Intent Activity opprettet og blir startet
    //Navigasjon ved trykk
    @Override
    public void onBackPressed() {
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

    //Metode for å oppbevare nåværende tilstand, når man går i f.eks landscape modus
    //Dersom man går i landscape modus så blir alle våre ønskende dataer puttet inn i en (Bundle) outState med spesielle (String)key
    //Bruker onSaveInstanceState for å oppbevare Bundle
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("inputText", inputText.getText().toString());
        outState.putString("outputText", outputText.getText().toString());
        outState.putString("stageText", stageText.getText().toString());
        outState.putString("riktigText", riktigText.getText().toString());
        outState.putString("galtText",galtText.getText().toString());
        outState.putInt("Stage", stage);
        outState.putInt("Galt",galt);
        outState.putInt("Riktig", riktig);
        outState.putIntegerArrayList("List",list);
        if(correctDialog !=null){
            correctDialog.dismiss();
        }

        if(wrongDialog !=null){
            wrongDialog.dismiss();

        }

        super.onSaveInstanceState(outState);
    }

    //Metode for å oppbevare nåværende tilstand, når man går i f.eks landscape modus
    //Dersom man går i landscape modus så blir alle våre ønskende dataer puttet inn i en (Bundle) outState
    //Bruker onSaveInstanceState for å oppbevare Bundle
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        inputText.setText(savedInstanceState.getString("inputText"));
        outputText.setText(savedInstanceState.getString("outputText"));
        stageText.setText(savedInstanceState.getString("stageText"));
        riktigText.setText(savedInstanceState.getString("riktigText"));
        galtText.setText(savedInstanceState.getString("galtText"));
        stage = savedInstanceState.getInt("Stage");
        galt = savedInstanceState.getInt("Galt");
        riktig = savedInstanceState.getInt("Riktig");
        list = savedInstanceState.getIntegerArrayList("List");
    }


    //Metode som lagrer to dataer ved hjelp av SharedPreferences
    //Det blir puttet inn to av type (int) variabler i Sharedpreferences editor
    public void lagreDataene(int riktig, int galt){
        SharedPreferences prefs = getApplication().getSharedPreferences("Resultat",MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("antallRiktig", riktig);
        editor.putInt("antallGalt", galt);
        editor.commit();

    }

    //Metode som tar for seg brukervalidering
    //Sjekker dermed om TextView har ingen verdi(blank)
    //Returnerer (boolean) true eller false;
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

    //Metode som endrer/oppdaterer et TextView med et nytt String-array objekt ved bruk av et (int)indeks og en (String[]) array
    //Oppdaterer TextView og gjør om et annet TextView til blank
    public void questionUpdate(TextView text, String[] array, int value, TextView input) {
        text.setText(String.valueOf(array[value]));
        input.setText(String.valueOf(""));

    }

    //Metode som først generere et tall, deretter så sjekker om det tallet eksisterer i det Arraylist man oppgir
    //Tar i bruk andre metoder som generateRandomInt() og existBefore()
    //Dersom tallet allerede finnes så blir det generert et nytt tall og gjentar prosessen
    //Om tallet ikke finnes i Arraylist, så blir tallet lagt inn i Arraylist
    //Returnerer (int) dette tallet
    public int generateRandomInt(ArrayList<Integer> list) {
        int value = generateRandomInt();
        while(existBefore(list, value)){
            value = generateRandomInt();
        }
        list.add(value);
        return value;
    }

    //Metode som sjekker om et nummer allerede finnes i en arraylist
    //Returnerer (boolean) true eller false
    public boolean existBefore(ArrayList<Integer> list, int number) {
        if(list.contains(number))return true;
        return false;
    }

    //Metode som generere et tall i mellom 0 og 25
    //Returnerer (int) dette tallet
    public int generateRandomInt() {
        Random r = new Random();
        int value = r.nextInt((25 - 0) + 1) + 0;
        return value;
    }

    //Metode som genererer et tall og legger det i en Arraylist
    //I tilegg så blir dette tallet brukt som en indeks i et String array med spørsmålene
    //Skriver ut et spørsmål til et TextView
    public void generateAtStart(ArrayList<Integer>list, String[] array, TextView text){
        int tall = generateRandomInt();
        list.add(tall);
        text.setText(String.valueOf(array[tall]));
    }

    public void audioPlaying(MediaPlayer music){
        if(music.isPlaying()){
            music.seekTo(0);
        }else{
            music.start();
        }
    }



    public Dialog displayCorrectDialog(){
        Dialog d = new Dialog(this){
            @Override
            public boolean onTouchEvent(MotionEvent event) {
                dismiss();
                return true;
            }
        };
        d.setContentView(R.layout.dialog_correct);
        //d.setCanceledOnTouchOutside(false);
        //d.setCancelable(false);
        //d.show();


        return  d;
    }

    public Dialog displayWrongDialog(){
        Dialog d = new Dialog(this){
            @Override
            public boolean onTouchEvent(MotionEvent event) {
                dismiss();
                return true;
            }
        };
        d.setContentView(R.layout.dialog_wrong);
        //d.setCanceledOnTouchOutside(false);
        //d.setCancelable(false);
        //d.show();
        return  d;
    }

}

