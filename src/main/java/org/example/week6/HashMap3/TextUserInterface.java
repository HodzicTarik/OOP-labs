package org.example.week6.HashMap3;

import java.util.Scanner;

public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        System.out.println("Statement\n\tquit - quit the text user interface\n\ttranslate - asks a word and prints its translation\n\tadd - adds a word pair to the dictionary");

        while (true) {
            System.out.print("\nStatement: ");
            String command = reader.nextLine();

            if (command.equals("quit")) {
                System.out.println("Cheers");
                break;
            } else if (command.equals("add")) {
                add();
            } else if (command.equals("translate")) {
                translate();
            } else {
                System.out.println("Unknown statement");
            }
        }
    }

    private void add() {
        System.out.print("In Finnish: ");
        String word = reader.nextLine();
        System.out.print("Translation: ");
        String translation = reader.nextLine();
        dictionary.add(word, translation);
        System.out.println("Added " + word + " as " + translation);
    }

    private void translate() {
        System.out.print("Give a word: ");
        String word = reader.nextLine();
        System.out.println("Translation: " + dictionary.translate(word));
    }
}

