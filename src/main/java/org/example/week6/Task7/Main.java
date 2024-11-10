package org.example.week6.Task7;

public class Main {
    public static void main(String[] args) {
        NightSky nightSky = new NightSky(0.1, 40, 10);
        nightSky.print();
        System.out.println("Number of stars: " + nightSky.starsInLastPrint());
        System.out.println();
    }
}
