package com.dylan.pendu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Game extends AppCompatActivity {

    Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
    Hangman hangman;
    TextView hangmanText;
    TextView wordText;

    /***
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        Intent intent = getIntent();
        int letters = intent.getIntExtra("letters", 0);

        hangman = new Hangman(this, letters);

        wordText = findViewById(R.id.word);
        wordText.setText(hangman.getWord());

        hangmanText = findViewById(R.id.hangmanText);
        showHangman();

    }

    /**
     * Affiche la victoire
     */
    private void win() {
        Toast.makeText(this, "Gagné en "+hangman.getPlay()+" !", Toast.LENGTH_LONG).show();
        finish();
    }

    /**
     * affiche la défaite
     */
    private void lost() {
        Toast.makeText(this, "Perdu, le mot était "+hangman.getFullWord(), Toast.LENGTH_LONG).show();
        finish();
    }

    /**
     * Listener des boutons
     * @param view
     */
    public void click(View view) {
        hangman.tryLetter( ((TextView)view).getText().toString() );
        if (hangman.win()) win();
        if (hangman.lost()) lost();

        showHangman();
        wordText.setText(hangman.getWord());

        view.setEnabled(false);
    }

    /**
     * Affiche le pendu selon le nombre d'erreurs
     */
    public void showHangman() {
        hangmanText.setText(hangmandraw[hangman.getMistakes()]);
    }

    public String[] hangmandraw = new String[] {
            "  --------------\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "   /|\\\n" +
                    "  / | \\\n" +
                    " /  |  \\\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~",
            "  --------------\n" +
                    "    |        |\n" +
                    "    |        |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "   /|\\\n" +
                    "  / | \\\n" +
                    " /  |  \\\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~",
            "  --------------\n" +
                    "    |        |\n" +
                    "    |        |\n" +
                    "    |       / \\\n" +
                    "    |       \\_/\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "   /|\\\n" +
                    "  / | \\\n" +
                    " /  |  \\\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~",
            "  --------------\n" +
                    "    |        |\n" +
                    "    |        |\n" +
                    "    |       / \\\n" +
                    "    |       \\_/\n" +
                    "              |\n" +
                    "    |         |\n" +
                    "    |         |\n" +
                    "    |\n" +
                    "   /|\\\n" +
                    "  / | \\\n" +
                    " /  |  \\\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~",
            "  --------------\n" +
                    "    |        |\n" +
                    "    |        |\n" +
                    "    |       / \\\n" +
                    "    |       \\_/\n" +
                    "    |      __|__\n" +
                    "    |         |\n" +
                    "    |         |\n" +
                    "    |\n" +
                    "   /|\\\n" +
                    "  / | \\\n" +
                    " /  |  \\\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~",
            "  --------------\n" +
                    "    |        |\n" +
                    "    |        |\n" +
                    "    |       / \\\n" +
                    "    |       \\_/\n" +
                    "    |      __|__\n" +
                    "    |         |\n" +
                    "    |         |\n" +
                    "    |        / \\ \n" +
                    "   /|\\\n" +
                    "  / | \\\n" +
                    " /  |  \\\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~",
            ""
    };
}
