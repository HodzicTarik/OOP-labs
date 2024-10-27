package org.example.week4.Task3;

/* Napravio sam klasu za Task 3 i Task 4 kako ne bih nadovezivao na Task 1,
jer je malo neuredan pa se ovde bolje vidi */

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Bosnia", 21);
        p1.setAge(40);
        p1.setCountry("France");
        System.out.println("Age: " + p1.getAge());
        System.out.println("Country: " + p1.getCountry());
        Person p2 = new Person("Morocco", 32);
        p2.setAge(15);
        System.out.println("-----------------");
        System.out.println("Age: " + p2.getAge());
        System.out.println("Country: " + p2.getCountry());

    }
}
