package com.example.bas.livssyklus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class Hoved extends AppCompatActivity {

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

        setContentView(R.layout.activity_hoved);

        Button spillKnapp = (Button)findViewById(R.id.spillKnapp);
        spillKnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something here
                Intent startSpill = new Intent(getApplicationContext(), Spill.class);
                startActivity(startSpill);
                finish();

            }
        });

        Button preferenseKnapp = (Button)findViewById(R.id.preferanserKnapp);
        preferenseKnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something here
                Intent goTilPrefereser = new Intent(getApplicationContext(), Preferenser.class);
                startActivity(goTilPrefereser);
            }
        });

        Button statistikkKnapp = (Button)findViewById(R.id.statistikkKnapp);
        statistikkKnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something here
                Intent visStatistikk = new Intent(getApplicationContext(), Statistikk.class);
                startActivity(visStatistikk);
            }
        });

    }
    @Override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }


}
