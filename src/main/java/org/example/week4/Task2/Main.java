package org.example.week4.Task2;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("Black", FillType.FILLED, 5);
        Rectangle rectangle = new Rectangle("White", FillType.NOT_FILLED, 3, 5);

        circle.displayInfo();
        System.out.println();
        rectangle.displayInfo();
    }
}
