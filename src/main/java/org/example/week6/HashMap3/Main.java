package org.example.week6.HashMap3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       /* Dictionary dictionary = new Dictionary();
        dictionary.add("apina", "monkey");
        dictionary.add("banaani", "banana");
        dictionary.add("cembalo", "harpsichord");

        System.out.println(dictionary.translate("apina")); // Output: monkey
        System.out.println(dictionary.translate("porkkana")); // Output: Word porkkana is not in dictionary

        System.out.println(dictionary.amountOfWords()); // Output: 3


        ArrayList<String> translations = dictionary.translationList();
        for (String translation : translations) {
            System.out.println(translation);
        }*/

        Dictionary dictionary = new Dictionary();
        Scanner reader = new Scanner(System.in);
        TextUserInterface ui = new TextUserInterface(reader, dictionary);
        ui.start();

    }
}
