package com.example.bas.livssyklus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

public class Aktivitet2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoved2);

        TextView tekst = (TextView)findViewById(R.id.aktivitet2tekst);
        tekst.setText(getIntent().getStringExtra("Frahoved"));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.aktivitet2:
                Intent i = new Intent(this, Aktivitet2.class);
                EditText
                        et = (EditText)findViewById(R.id.aktivitet2tekst);
                String tekst = et.getText().toString();
                i.putExtra("Frahoved", tekst);
                startActivity(i);
                break;
                default:
                    return super.onOptionsItemSelected(item);
        }return true;
    }
}
