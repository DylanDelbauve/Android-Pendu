package com.dylan.pendu;

public interface IDictionary {

    String findWordWith(int letters);
    boolean content(String word);
    String getWordDef(String word);

    int getSizeDictionary();
}
