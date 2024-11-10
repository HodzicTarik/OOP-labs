package org.example.week6.Task7;

import java.util.Random;

public class NightSky {
    private double density;
    private int width;
    private int height;
    private int starsInLastPrint;
    private Random random;

    public NightSky(double density, int width, int height) {
        this.density = density;
        this.width = width;
        this.height = height;
        this.random = new Random();
        this.starsInLastPrint = 0;
    }

    public void print() {
        this.starsInLastPrint = 0;
        for (int i = 0; i < height; i++) {
            printLine();
        }
    }

    private void printLine() {
        for (int j = 0; j < width; j++) {
            if (random.nextDouble() <= density) {
                System.out.print("*");
                starsInLastPrint++;
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public int starsInLastPrint() {
        return starsInLastPrint;
    }
}
