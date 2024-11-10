package org.example.week6.Task4;

import java.util.Arrays;

import static org.example.week6.Task4.ArrayUtils.swap;

public class Task4 {
    public static void main(String[] args) {
        int[] values = {3, 2, 5, 4, 8};

        System.out.println(Arrays.toString(values));
        swap(values, 1, 0);
        System.out.println(Arrays.toString(values));
        swap(values, 0, 3);
        System.out.println(Arrays.toString(values));
    }
}

