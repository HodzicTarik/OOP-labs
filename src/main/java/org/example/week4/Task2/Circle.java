package org.example.week4.Task2;

public class Circle extends Shape {
    private double radius;
    private static final double PI = 3.14159265359;

    Circle(String color, FillType filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Radius: " + radius);
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    public double calculateCircumference(double PI, double radius){
        return 2 * PI * radius;
    }

    public double calculateCircumference(double radius){
        return 2 * PI * radius;
    }
}

