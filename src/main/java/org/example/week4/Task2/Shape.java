package org.example.week4.Task2;

public class Shape {
    private String color;
    private FillType filled;

    Shape(String color, FillType filled) {
        this.color=color;
        this.filled=filled;
    }

    public void setColor(String color) {
        this.color=color;
    }

    public void setFillType(FillType filled) {
        this.filled=filled;
    }

    public String getColor() {
        return color;
    }

    public FillType getFillType() {
        return filled;
    }

    public void displayInfo(){
        System.out.println("Color: "+getColor());
        System.out.println("Filled: "+getFillType());
    }
}
