package com.example.bas.livssyklus;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Statistikk extends AppCompatActivity {

    SharedPreferences prefs;
    String language;
    TextView riktigText, galtText;
    Button slettKnapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = getSharedPreferences("Resultat",MODE_PRIVATE);
        language = prefs.getString("lan","");

        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());

        setContentView(R.layout.activity_statistikk);

        riktigText = (TextView)findViewById(R.id.riktig);
        galtText = (TextView)findViewById(R.id.galt);

        displayScore(riktigText,galtText);

        slettKnapp = (Button)findViewById(R.id.slettBtn);
        slettKnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lagreDataene();
                displayScore(riktigText,galtText);
            }
        });

    }

    //Metode som henter fram verdier som er lagret i Sharedpreferences
    //Verdiene vises fram på skjermbildet
    public void displayScore(TextView riktigText, TextView galtText){
        SharedPreferences prefs = getSharedPreferences("Resultat",MODE_PRIVATE);
        int riktig = prefs.getInt("antallRiktig",0);
        riktigText.setText(String.valueOf(riktig));
        int galt = prefs.getInt("antallGalt", 0);
        galtText.setText(String.valueOf(galt));
    }

    //Metode som lagrer to dataer ved hjelp av SharedPreferences
    //Det blir puttet inn to av type (int) variabler i Sharedpreferences editor
    public void lagreDataene(){
        SharedPreferences prefs = getApplication().getSharedPreferences("Resultat",MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("antallRiktig", 0);
        editor.putInt("antallGalt", 0);
        editor.commit();

    }



}
