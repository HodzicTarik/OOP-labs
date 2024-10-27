package org.example.week4.Task3;

public class Person {
    private String country;
    private int age;

    Person(String country, int age) {
        this.country = country;
        setAge(age);
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAge(int age){
        if (age<6 || age > 80)
            throw new IllegalArgumentException("Age must be between 6 and 80");
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }
}

