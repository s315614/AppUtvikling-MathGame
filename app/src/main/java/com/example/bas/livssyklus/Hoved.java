package com.example.bas.livssyklus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Hoved extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

}
