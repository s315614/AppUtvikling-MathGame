package com.example.bas.livssyklus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Preferenser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferenser);

        Button easyKnapp = (Button) findViewById(R.id.easyKnapp);
        easyKnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //edit here
            }
        });

        Button mediumKnapp = (Button) findViewById(R.id.mediumKnapp);
        mediumKnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //edit here
            }
        });

        Button hardKnapp = (Button) findViewById(R.id.hardKnapp);
        hardKnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //edit here
            }
        });
    }
}
