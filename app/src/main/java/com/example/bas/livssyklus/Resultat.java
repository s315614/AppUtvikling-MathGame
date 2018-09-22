package com.example.bas.livssyklus;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Resultat extends AppCompatActivity {

    GifImage gifImageView;
    TextView riktig, galt;
    Button restart, mainMenu;
    SharedPreferences prefs;
    String language;

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

        setContentView(R.layout.activity_resultat);

        gifImageView = (GifImage) findViewById(R.id.GifImageView);
        gifImageView.setGifImageResource(R.drawable.giphy);

        riktig = (TextView)findViewById(R.id.riktig);
        galt = (TextView)findViewById(R.id.galt);
        restart = (Button)findViewById(R.id.restartBtn);
        mainMenu = (Button)findViewById(R.id.mainMenuBtn);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSpill = new Intent(getApplicationContext(), Spill.class);
                startActivity(goToSpill);
                finish();

            }
        });

        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToMainMenu = new Intent(getApplicationContext(), Hoved.class);
                startActivity(goToMainMenu);
                finish();
            }
        });

        displayScore(riktig,galt);
    }

    //Override metode som tilkaller en AlertDialog når man trykker på tilbakeknappen(onBackPressed())
    //På AlertDialog så kommer det opp to alternativsknapper(positiv/negativ)
    //Om man trykker på negativ så fjerner man AlertDialog og ingenting annet skjer
    //Dersom man trykker på positiv så blir en ny Intent Activity opprettet og blir startet
    //Navigasjon ved trykk
    @Override
    public void onBackPressed() {
        //Toast.makeText(getApplication(),"Hello",Toast.LENGTH_LONG).show();
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        String exit = getResources().getString(R.string.exit);
        String exitTekst = getResources().getString(R.string.exit_tekst_result);
        String avslutt = getResources().getString(R.string.avslutt);
        String avbryt = getResources().getString(R.string.avbryt);

        builder.setTitle(exit);
        builder.setMessage(exitTekst);

        builder.setPositiveButton(avslutt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
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


    public void displayScore(TextView riktigText, TextView galtText){
        SharedPreferences prefs = getSharedPreferences("Resultat",MODE_PRIVATE);
        int riktig = prefs.getInt("antallRiktig",0);
        riktigText.setText(String.valueOf(riktig));
        int galt = prefs.getInt("antallGalt", 0);
        galtText.setText(String.valueOf(galt));
    }

}
