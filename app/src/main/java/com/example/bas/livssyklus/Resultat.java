package com.example.bas.livssyklus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultat extends AppCompatActivity {

    TextView riktig, galt;

    Button restart, mainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        GifImage gifImageView = (GifImage) findViewById(R.id.GifImageView);
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


    public void displayScore(TextView riktigText, TextView galtText){
        SharedPreferences prefs = getSharedPreferences("Resultat",MODE_PRIVATE);
        int riktig = prefs.getInt("antallRiktig",0);
        riktigText.setText(String.valueOf(riktig));
        int galt = prefs.getInt("antallGalt", 0);
        galtText.setText(String.valueOf(galt));
    }

}
