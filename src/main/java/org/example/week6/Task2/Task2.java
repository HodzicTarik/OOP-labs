package org.example.week6.Task2;

public class Task2 {
    public static void main(String[] args) {
        int[] values = {6, 5, 8, 6, 11};
        System.out.println("Index of smallest: " + indexOfSmallest(values));
    }

    public static int indexOfSmallest(int[] array) {
        int smallestIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[smallestIndex]) {
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

}
