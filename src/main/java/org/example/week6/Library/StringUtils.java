package org.example.week6.Library;

public class StringUtils {
    public static boolean included(String word, String searched) {
        if (word == null || searched == null) {
            return false;
        }
        word = word.trim().toUpperCase();
        searched = searched.trim().toUpperCase();
        return word.contains(searched);
    }
}
