package org.example.week6.Task1;

public class Task1 {
    public static void main(String[] args) {
        int[] values = {6, 5, 8, 6, 11};
        System.out.println("smallest: " + smallest(values));
    }

    public static int smallest(int[] array) {
        int smallest = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }

        return smallest;
    }
}


