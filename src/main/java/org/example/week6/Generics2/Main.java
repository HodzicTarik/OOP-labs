package org.example.week6.Generics2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static <T> List<T> reverseList(List<T> list) {
        List<T> reversedList = new ArrayList<>(list);
        Collections.reverse(reversedList);
        return reversedList;
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5);
        List<String> stringList = List.of("apple", "banana", "cherry");

        List<Integer> reversedIntList = reverseList(intList);
        List<String> reversedStringList = reverseList(stringList);

        System.out.println("Original Integer list: " + intList);
        System.out.println("Reversed Integer list: " + reversedIntList);

        System.out.println("Original String list: " + stringList);
        System.out.println("Reversed String list: " + reversedStringList);
    }
}