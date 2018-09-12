package com.example.bas.livssyklus;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Preferenser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferenser);

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
}
