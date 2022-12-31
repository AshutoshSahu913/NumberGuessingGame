package com.JAVA_TASK;

import java.util.Scanner;

public class NumberGuessingGame {
    public int copy_highScore = 0;
    public int lose_count = 0;
    Scanner sc = new Scanner(System.in);
    int score = 0;
    int r_number;
    int round = 0;
    int highScore = 0;

    public static void main(String[] args) {

        // random number Between 1 - 100
        System.out.println("------------------------------------------------------------------");
        System.out.println(" ----------- | WELCOME TO NUMBER GUESSING GAME | -----------");
        System.out.println("------------------------------------------------------------------");
        // choice method call
        NumberGuessingGame g = new NumberGuessingGame();
        g.choose();
        // nextRound method call
        g.nextRound();
    }

    //  choice method definition
    public void choose() {
        int choose;
        do {
            System.out.println("\t\t\t\t\t| CHOOSE AN OPTION |");
            System.out.println("\t\t\t\t---------------------------");
            System.out.println("1.Start Game\t\t2.Score Board\t\t3.Quit");
            choose = sc.nextInt();
            switch (choose) {
                case 1 -> start();
                case 2 -> scoreBoard();
                case 3 -> {
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("\t\t\t\t| THANK YOU 🫶|");
                    System.out.println("------------------------------------------------------------------");
                    System.exit(0);
                }
                default -> {
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("\t\t\t\t| INVALID INPUT |");
                    System.out.println("------------------------------------------------------------------");
                }
            }
        }
        while (choose != 1);
    }

    // Start method definition
    public void start() {
//      Number of Chance
        int n = 5;
//          Create a random number
        r_number = (int) (Math.ceil(Math.random() * 100));
        System.out.println("------------------------------------------------------------------");
        System.out.println("ROUND " + (round + 1) + " START..... ");
        System.out.println("You have 5 Chance to Guess the Number.");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Random Number is less than ⏬ " + (r_number + 1) + " & Greater than ⏫ " + (r_number - 1));
        System.out.println("------------------------------------------------------------------");

        int tryCount = 0;
        while (n > 0) {
            tryCount++;
            System.out.print("Enter Your Guessing Number : ");
            int u_number = sc.nextInt();
            if (u_number < 0 || u_number > 100) {
                System.out.println("| INVALID INPUT |");
            } else if (u_number == r_number) {
                System.out.println("------------------------------------------------------------------");
                System.out.println("\t\t\t\t\t| CORRECT GUESSING 🤩 |");
                System.out.println("\t\t\t\t\t\t| YOU WIN  🫡️|");
                System.out.println("------------------------------------------------------------------");
                score = score + (n * 10);
                highScore = score;
                System.out.println("TRY : " + tryCount + "\t\tSCORE : " + score);
                System.out.println("------------------------------------------------------------------");
                break;
            } else if (u_number + 1 == r_number || u_number - 1 == r_number) {
                System.out.println("OHH!  Your Guessing is Too Close 😐.....");
            } else if (u_number > r_number) {
                System.out.println("NOPE ! Random Number is Less than " + u_number + " Guess Again 🤯");
            } else {
                System.out.println("NOPE ! Random Number is Greater than " + u_number + " Guess Again 🤯");
            }
            n--;
        }
        // if trials end new game begin
        if (n == 0) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("\t\t\t\t| GUESSING LIMIT EXCEEDED 🫥 |");
            System.out.println("\t\t\t\t\t\t| YOU LOSE ☹️|");
            System.out.println("------------------------------------------------------------------");
            round = 0;
            if (lose_count == 0) {
                copy_highScore = score;
            }
            score = 0;
            lose_count++;
            System.out.println("Would you like to play again:\n1.Yes\t\t 2.No");
            int c = sc.nextInt();
            if (c == 1)
                choose();
            else {
                System.out.println("------------------------------------------------------------------");
                System.out.println("\t\t\t\t\t\t| THANK YOU 🫶|");
                System.out.println("------------------------------------------------------------------");
                System.exit(0);
            }
        }
        if (n != 0) {
            round++;
        }
    }

    //  nextRound method definition
    public void nextRound() {
        int choose;
        do {
            System.out.println("\t\t\t\t\t\t" + "| CHOOSE AN OPTION |");
            System.out.println("\t\t\t\t\t----------------------------");
            System.out.println("1.Next Round\t\t2.Score Board\t\t3.Quit");
            choose = sc.nextInt();
            switch (choose) {
                case 1 -> start();
                case 2 -> scoreBoard();
                case 3 -> {
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("\t\t\t\t\t\t| THANK YOU 🫶|");
                    System.out.println("------------------------------------------------------------------");
                    System.exit(0);
                }
                default -> {
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("\t\t\t\t\t\t| INVALID INPUT |");
                    System.out.println("------------------------------------------------------------------");
                }
            }
        }
        while (choose == 1 || choose == 2 || choose > 3);
    }

    // ScoreBoard method definition
    public void scoreBoard() {
        if (copy_highScore <= highScore) {
            copy_highScore = highScore;
        }
        System.out.println("HIGHEST SCORE : " + copy_highScore);
        System.out.println("------------------------------------------------------------------");
    }
}