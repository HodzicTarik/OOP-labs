package org.example.week2;
import java.util.*;


public class Main {
    public static void printing(){
        System.out.println("In the beginning there were the swamp, the hoe and Java.");
    }

    public static void drawStarsPiramid(int x){
        for(int i=1; i<=x; i++){
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();

        }
    }

    public static void invertStarsPiramid(int x){
        for(int i=x; i>=1; i--){
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    public static void drawNumbersPiramid(int x){
        for (int i=1;i<=x; i++){
            for (int j=1;j<=i;j++){
                System.out.print(j+ " ");
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] args) {
       /* // Task 1
        String correctPassword = "asdfgh";
        String password = "";
        while (!password.equals(correctPassword)){
            Scanner pass = new Scanner(System.in);
            System.out.print("Enter a password: ");
            password = pass.nextLine();
        }
        System.out.println("Right !!!");

        // Task 2
        double result;
        double no1;
        double no2;
        double no3;
        Scanner numbers = new Scanner(System.in);
        System.out.println("Enter a first number: ");
        no1 = numbers.nextDouble();
        System.out.println("Enter a second number: ");
        no2 = numbers.nextDouble();
        System.out.println("Enter a third number: ");
        no3 = numbers.nextDouble();
        System.out.println("Result: " + (no1 + no2 + no3));

        // Task 3
        System.out.println("Enter a number! It stops when you enter 0");
        double result = 0;
        double number = 1;
        Scanner no = new Scanner(System.in);
        while (number != 0) {
            number = no.nextDouble();
            result = result + number;
        }
        System.out.println("Result: " + result);

        // Task 4

        int number1;
        int number2;
        int number3;
        Scanner range = new Scanner(System.in);
        System.out.println("Enter first number: ");
        number1 = range.nextInt();
        System.out.println("Enter second number: ");
        number2 = range.nextInt();
        number3 = number1 + 1;
        while(number3 < number2){
            System.out.print(number3 + " ");
            number3++;
        }

        // Task 5
        System.out.println("Enter a power of number: ");
        int power;
        int result;
        Scanner onPower = new Scanner(System.in);
        power = onPower.nextInt();
        result = (int)Math.pow(2.00, power);
    }
        System.out.println("2 powered by " + power + " is " + result);

        // Task 6

        int number;
        System.out.println("Enter number: ");
        Scanner no = new Scanner(System.in);
        number = no.nextInt();
        for(int i = 0; i<number; i++){
            printing();
    }

        // Task 7

        int number;
        Scanner no = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        number = no.nextInt();
        drawStarsPiramid(number);

        // Task 8

        int number;
        Scanner no = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        number = no.nextInt();
        invertStarsPiramid(number);

        // Task 9

        int number;
        System.out.println("Enter a number: ");
        Scanner no = new Scanner(System.in);
        number = no.nextInt();
        drawNumbersPiramid(number);*/

        // Task 10

        int randomNumber = 68;
        int guessNumber;
        int counter = 1;
        Scanner guess = new Scanner(System.in);
        System.out.println("Guess the number between 0-100: ");
        while(true){
            guessNumber = guess.nextInt();
            if (guessNumber < 0 || guessNumber > 100){
                System.out.println("Out of range");
                break;
            }
            if (guessNumber < randomNumber){
                System.out.println("Higher! - This is your " + counter + " guess");
                counter++;
            }
            else if (guessNumber > randomNumber){
                System.out.println("Lower! - This is your " + counter + " guess");
                counter++;
            }

            else {
                System.out.println("Congratulations! You made " + counter + " guesses.");
                break;
            }
        }
    }
}
