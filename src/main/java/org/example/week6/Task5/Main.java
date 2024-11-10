package org.example.week6.Task5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = {-3, 2, 3, 4, 7, 8, 12};
        Scanner reader = new Scanner(System.in);

        System.out.println("Values of the array: " + Arrays.toString(array));
        System.out.println();
        System.out.print("Enter searched number: ");
        int searchedValue = Integer.parseInt(reader.nextLine());
        System.out.println();

        boolean result = BinarySearch.search(array, searchedValue);

        if (result) {
            System.out.println("Value " + searchedValue + " is in the array.");
        } else {
            System.out.println("Value " + searchedValue + " is not in the array.");
        }
    }
}
