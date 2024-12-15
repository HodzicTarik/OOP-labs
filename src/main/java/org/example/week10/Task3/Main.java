package org.example.week10.Task3;

import java.io.*;
import java.nio.file.*;
import java.util.*;

class Events {

    public void generateFile(String filename, int numberOfRecords) throws IOException {
        Random random = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < numberOfRecords; i++) {
                int number = random.nextInt(1000);
                writer.write("Number: " + number);
                writer.newLine();
            }
        }
    }

    public void printFile(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public ArrayList<String> readFile(String filename) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        lines.addAll(Files.readAllLines(Paths.get(filename)));
        return lines;
    }
}

public class Main {
    public static void main(String[] args) {
        Events events = new Events();
        String filename = "data.txt";

        try {
            events.generateFile(filename, 10);
            System.out.println("Content of the file:");
            events.printFile(filename);

            ArrayList<String> records = events.readFile(filename);
            System.out.println("\nRetrieved records:");
            for (String record : records) {
                System.out.println(record);
            }
        } catch (IOException e) {
            System.out.println("Error occurred.");
        }
    }
}