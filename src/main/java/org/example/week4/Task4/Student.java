package org.example.week4.Task4;

import java.util.ArrayList;

public class Student {
    private int ID;
    private ArrayList<Integer> grades;

    Student(int ID){
        this.ID = ID;
        this.grades = new ArrayList<>();
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public void setGrade(int grade){
        addGrade(grade);
    }

    public int getID(){
        return ID;
    }

    public ArrayList<Integer> getGrade(){
        return grades;
    }

    public void addGrade(int grade){
        if(grade < 1 || grade > 5){
            throw new IllegalArgumentException("Grades must be between 1 and 5.");
        } else{
            grades.add(grade);
        }
    }

}


