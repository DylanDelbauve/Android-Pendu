package com.dylan.pendu;

import android.content.Context;
import android.content.res.Resources;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Dylan
 */
public class Dictionary implements IDictionary {

    private ArrayList<String> words = new ArrayList<>();

    public Dictionary(Context context) {
        String fileContent = "";
        try {
            Resources res = context.getResources();
            InputStream in_s = res.openRawResource(R.raw.wordsList);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            fileContent = new String(b);
        } catch (Exception e) { }
        words.addAll(Arrays.asList(fileContent.split("\n")));
    }

    /**
     * Donne un mot avec le nombre de lettres données
     * @param letters
     *          Le nombre de lettre
     * @return
     *          Le mot
     */
    @Override
    public String findWordWith(int letters) {
        ArrayList<String> choice = new ArrayList<>();
        for (String s: words) {
            if (s.length() == letters+1) {
                choice.add(s);
            }
        }
        return choice.get(new Random().nextInt(choice.size()));
    }

    /**
     * Permet de savoir si oui ou non un mot existe dans la base de connaissance
     * @param word
     *          Le mot dont il faut définir l'existance
     * @return
     *          un booléen
     */
    @Override
    public boolean content(String word) {
        return false;
    }

    @Override
    public String getWordDef(String word) {
        return null;
    }

    /**
     * Permet de connaître la taille du dictionnaire (nombre de mots)
     *
     * @return
     *      La taille du dictionnaire
     */
    public int getSizeDictionary() {
        return words.size();
    }
}
