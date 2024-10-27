package org.example.week4.Task2;

public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(String color, FillType filled, double width, double height) {
        super(color,filled);
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + getArea());
    }

    public double getArea(){
        return width * height;
    }
}