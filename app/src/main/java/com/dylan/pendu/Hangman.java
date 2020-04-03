package com.dylan.pendu;

import android.content.Context;

public class Hangman {

    private String word;
    private boolean[] found;
    private Dictionary dictionary;

    private int mistakes = 0;
    private final int MAX_MISTAKES = 6;
    private int play = 0;

    /**
     * Constructeur de la classe pendu
     * @param context
     * @param letters
     *          le nombre de lettre
     */
    public Hangman(Context context, int letters) {
        dictionary = new Dictionary(context);
        mistakes = 0;
        word = dictionary.findWordWith(letters);
        System.out.println(word);
        found = new boolean[word.length()];
    }

    /**
     * Test la lettre sur le mot
     * @param testedLetter
     *          la lettre à tester sur le mot
     */
    public void tryLetter(String testedLetter) {
        boolean validate = false;
        play++;
        for (int i = 0; i < word.length(); i++) {
            if (word.substring(i, i+1).equals(testedLetter)) {
                found[i] = true;
                validate = true;
            }
        }
        if (!validate) mistakes++;
    }

    /**
     * Donne le nombre d'erreurs
     * @return
     *          le nombre d'erreur
     */
    public int getMistakes() {
        return mistakes;
    }

    /**
     * Determine le mot à trouver
     * @return
     *          le mot à trouver avec des "_" pour les lettres encore manquantes
     */
    public String getWord() {
        String res = "";
        for (int i = 0; i < word.length()-1; i++) {
            if (found[i]) res += word.substring(i, i+1);
            else res = res +="_";
            res +=" ";
        }
        return res;
    }

    /**
     * Donne le mot a trouver
     * @return
     *          Le mot à trouver
     *
     */
    public String getFullWord() {
        return word;
    }

    /**
     * Donne le nombre de coups
     * @return
     *          Le nombre de coups
     */
    public int getPlay() {
        return play;
    }

    /**
     * Determine si le mot est trouvé
     * @return
     *          un booleén
     */
    public boolean win() {
        for (int i = 0; i < found.length; i++) {
            if (!found[i]) return false;
        }
        return true;
    }

    /**
     * Retourne que la partie est perdu lorsque le nombre d'erreurs max est atteint
     *
     * @return
     *          un booleén
     */
    public boolean lost() {
        return mistakes >= MAX_MISTAKES;
    }

}
