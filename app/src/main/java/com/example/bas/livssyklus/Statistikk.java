package com.example.bas.livssyklus;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Statistikk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistikk);

        TextView riktigText = (TextView)findViewById(R.id.riktig);
        TextView galtText = (TextView)findViewById(R.id.galt);

        displayScore(riktigText,galtText);

    }

    public void displayScore(TextView riktigText, TextView galtText){
        SharedPreferences prefs = getSharedPreferences("Resultat",MODE_PRIVATE);
        int riktig = prefs.getInt("antallRiktig",0);
        riktigText.setText(String.valueOf(riktig));
        int galt = prefs.getInt("antallGalt", 0);
        galtText.setText(String.valueOf(galt));
    }



}
