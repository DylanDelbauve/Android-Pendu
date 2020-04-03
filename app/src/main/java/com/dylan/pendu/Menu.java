package com.dylan.pendu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        findViewById(R.id.easy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(3);
            }
        });
        findViewById(R.id.medium).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(5);
            }
        });
        findViewById(R.id.hard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(8);
            }
        });
    }

    /**
     *  Lance le jeu
     * @param letters
     *          Le nombre de lettre à trouver
     */
    public void start(int letters) {
        Intent intent = new Intent(this, Game.class);
        intent.putExtra("letters", letters);
        startActivity(intent);
    }
}
