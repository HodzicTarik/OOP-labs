package org.example.week6.HashMap3;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> translations;

    public Dictionary() {
        this.translations = new HashMap<>();
    }

    public void add(String word, String translation) {
        translations.put(word, translation);
    }

    public String translate(String word) {
        return translations.getOrDefault(word, "Word " + word + " is not in dictionary");
    }

    public int amountOfWords() {
        return translations.size();
    }

    public ArrayList<String> translationList() {
        ArrayList<String> list = new ArrayList<>();
        for (String word : translations.keySet()) {
            list.add(word + " = " + translations.get(word));
        }
        return list;
    }
}
