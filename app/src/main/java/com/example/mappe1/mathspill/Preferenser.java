package com.example.mappe1.mathspill;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mappe1.mathspill.R;

import java.util.Locale;


public class Preferenser extends AppCompatActivity {

    TextView languageId, norskLanguage,tyskLanguage, preferenseTekst;
    Button easyKnapp, mediumKnapp, hardKnapp;
    Switch switch1;
    String languageToLoad;
    SharedPreferences prefs, sharedPreferences;
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

        setContentView(R.layout.activity_preferenser);

        easyKnapp = (Button)findViewById(R.id.easyKnapp);
        easyKnapp.setText(R.string.easyKnapp);
        mediumKnapp = (Button)findViewById(R.id.mediumKnapp);
        mediumKnapp.setText(R.string.mediumKnapp);
        hardKnapp =(Button)findViewById(R.id.hardKnapp);
        hardKnapp.setText(R.string.hardKnapp);
        languageId =(TextView)findViewById(R.id.languageId);
        norskLanguage= (TextView)findViewById(R.id.norskLanguage);
        tyskLanguage = (TextView)findViewById(R.id.tyskLanguage);
        preferenseTekst = (TextView)findViewById(R.id.preferenseTekst);

        switch1 = (Switch)findViewById(R.id.switch1);
        Boolean value = true;

        sharedPreferences = getSharedPreferences("isChecked", 0);
        value = sharedPreferences.getBoolean("isChecked", value);
        switch1.setChecked(value);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    languageToLoad  = "no";
                    sharedPreferences.edit().putBoolean("isChecked", true).apply();
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("lan",languageToLoad);
                    editor.commit();

                    Locale locale = new Locale(languageToLoad);
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.locale = locale;
                    getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());


                    Intent intent = new Intent(Preferenser.this, Preferenser.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();

                }else{
                    languageToLoad  = "de";
                    sharedPreferences.edit().putBoolean("isChecked", false).apply();
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("lan",languageToLoad);
                    editor.commit();


                    Locale locale = new Locale(languageToLoad);
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.locale = locale;
                    getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());


                    Intent intent = new Intent(Preferenser.this, Preferenser.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();

                }



            }

        });


        Button easyKnapp = (Button) findViewById(R.id.easyKnapp);
        easyKnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("Modus", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("Mode",5);
                editor.commit();

                int verdi = prefs.getInt("Mode",0);
                Toast.makeText(Preferenser.this, String.valueOf(verdi),Toast.LENGTH_LONG).show();
            }
        });

        Button mediumKnapp = (Button) findViewById(R.id.mediumKnapp);
        mediumKnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("Modus", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("Mode",10);
                editor.commit();

                int verdi = prefs.getInt("Mode",0);
                Toast.makeText(Preferenser.this, String.valueOf(verdi),Toast.LENGTH_LONG).show();
            }
        });

        Button hardKnapp = (Button) findViewById(R.id.hardKnapp);
        hardKnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("Modus", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("Mode",25);
                editor.commit();

                int verdi = prefs.getInt("Mode",0);
                Toast.makeText(Preferenser.this, String.valueOf(verdi),Toast.LENGTH_LONG).show();
            }
        });
    }



    //Metode for å oppbevare nåværende tilstand, når man går i f.eks landscape modus
    //Dersom man går i landscape modus så blir alle våre ønskende dataer puttet inn i en (Bundle) outState med spesielle (String)key
    //Bruker onSaveInstanceState for å oppbevare Bundle
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("languageId", languageId.getText().toString());
        outState.putString("norskLanguage", norskLanguage.getText().toString());
        outState.putString("tyskLanguage", tyskLanguage.getText().toString());
        outState.putString("preferenseTekst", preferenseTekst.getText().toString());
        outState.putString("easyKnapp", easyKnapp.getText().toString());
        outState.putString("mediumKnapp", mediumKnapp.getText().toString());
        outState.putString("hardKnapp", hardKnapp.getText().toString());

        super.onSaveInstanceState(outState);
    }

    //Override metode for å henter tilstander, når man går tilbake til stående modus
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        languageId.setText(savedInstanceState.getString("languageId"));
        norskLanguage.setText(savedInstanceState.getString("norskLanguage"));
        tyskLanguage.setText(savedInstanceState.getString("tyskLanguage"));
        preferenseTekst.setText(savedInstanceState.getString("preferenseTekst"));
        easyKnapp.setText(savedInstanceState.getString("easyKnapp"));
        mediumKnapp.setText(savedInstanceState.getString("mediumKnapp"));
        hardKnapp.setText(savedInstanceState.getString("hardKnapp"));


    }

    //Override metode som navigerer tilbake til Hovedsiden
    @Override
    public void onBackPressed(){

        Intent goToMain = new Intent(getApplicationContext(), Hoved.class);
        startActivity(goToMain);
        finish();

    }








}
