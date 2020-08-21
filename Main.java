package com.company;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static ArrayList<Holes> holes = new ArrayList<Holes>(); //used for saving our holes.
    static int totalScore = 0;
    static int totalTime = 30; //the total time of the game
    static long start = System.currentTimeMillis();

    public static void main(String[] args) {
        //instantiation of all 9 holes.
        Holes hole1 = new Holes(false);
        Holes hole2 = new Holes(false);
        Holes hole3 = new Holes(false);
        Holes hole4 = new Holes(false);
        Holes hole5 = new Holes(false);
        Holes hole6 = new Holes(false);
        Holes hole7 = new Holes(false);
        Holes hole8 = new Holes(false);
        Holes hole9 = new Holes(false);

        //add each holes into arraylist.
        holes.add(hole1);
        holes.add(hole2);
        holes.add(hole3);
        holes.add(hole4);
        holes.add(hole5);
        holes.add(hole6);
        holes.add(hole7);
        holes.add(hole8);
        holes.add(hole9);
        //set a random hole to have a mole.
        holes.get(randomNumber()).setMole(true);

        //the main loop for our game.
        while (true){
            //reminder of time
            System.out.println("time remain：" + ((totalTime - (System.currentTimeMillis()-start) / 1000))+"s");

            //if time less than 0, then the game over
            if((totalTime - (System.currentTimeMillis()-start) / 1000) < 0){
                System.out.printf("\nGame over! Your score: %d", totalScore);
                return;
            }
            //setGraph() is used for display our game in console
            setGraph();
            System.out.printf("\nYour score: %d", totalScore);
            System.out.printf("\nhit:");
            //get users'input
            Scanner input = new Scanner(System.in);
            int whack;
            whack = input.nextInt() - 1;
            //the result when the user hits on a hole.
            if (holes.get(whack).getMole() == true){
                totalScore = totalScore + 100;
                holes.get(whack).setMole(false);
                holes.get(randomNumber()).setMole(true);
            }else {
                System.out.printf("\nGame over! Your score: %d", totalScore);
                return;
            }
        }
    }
    //a method to create a random number
    public static int randomNumber() {
        int max=8;
        int min=0;
        Random random = new Random();
        int randomHole = random.nextInt(max)%(max-min+1) + min;
        return randomHole;
    }

    //display game in console
    public static void setGraph(){
        for (int i = 1; i <= 9; i++) {
            if (i % 3 == 1) {
                System.out.printf("\n");
            }
            if (!holes.get(i - 1).getMole()) {
                System.out.printf("0");
            } else {
                System.out.printf("X");
            }
        }
    }

}