package org.example.week6.Generics1;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static <T extends Number> List<Double> sumEvenAndOdd(List<T> numbers) {
        double evenSum = 0;
        double oddSum = 0;

        for (T number : numbers) {
            if (number.intValue() % 2 == 0) {
                evenSum += number.doubleValue();
            } else {
                oddSum += number.doubleValue();
            }
        }

        return Arrays.asList(evenSum, oddSum);
    }

    public static void main(String[] args) {
        List<Integer> intNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Double> doubleNumbers = Arrays.asList(1.5, 2.5, 3.5, 4.5, 5.0, 6.0);

        List<Double> intSums = sumEvenAndOdd(intNumbers);
        List<Double> doubleSums = sumEvenAndOdd(doubleNumbers);

        System.out.println("Integer list - Even sum: " + intSums.get(0) + ", Odd sum: " + intSums.get(1));
        System.out.println("Double list - Even sum: " + doubleSums.get(0) + ", Odd sum: " + doubleSums.get(1));
    }
}
