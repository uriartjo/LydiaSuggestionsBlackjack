package com.company;
import com.studiohartman.jamepad.ControllerManager;
import com.studiohartman.jamepad.ControllerState;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("player");
        Player player2 = new Player("Jack");
        Blackjack game = new Blackjack();
        boolean restart = false;
        // write your code here
            System.out.println("I challange you to a game of black jack! Press start if you accept this challange.");
            ControllerManager controllers = new ControllerManager();
            controllers.initSDLGamepad();
            boolean intro = true;
            boolean understand = false;
            while (intro == true) {
                ControllerState currState = controllers.getState(0);
                if (currState.startJustPressed) {
                    System.out.println("Then prepare to taste defeat");
                    System.out.println("Do you know how to play black jack? If so press x if not press y.");
                    if (currState.xJustPressed) {
                        System.out.println("GOOD! Press y to begin!");
                        if (currState.yJustPressed) {
                            intro = false;
                            Blackjack.start = true;
                            Blackjack.gameBegan = true;
                            System.out.println("START!");
                        }
                    }
                    if (currState.yJustPressed) {
                        System.out.println("WHAT YOU DON'T KNOW HOW TO PLAY BLACK JACK!? WHY WOULD YOU CHALLENGE ME, THE BEST BLACK JACKER IN THE WORLD, IF YOU CANNOT PLAY BLACK JACK!");
                        while (understand == false) {
                            System.out.println("The rules are simple. You will start with two card. The goal is to have all of your cards add up to 21 first. If you get to 21 first you win," +
                                    " if I get to 21 first I win. If either of us go over 21 the other one wins be default. Press a to hit, this will give you another card and press b to stay.");
                            understand = true;
                        }
                        System.out.println("If you understand press x. If you need me to repeat the rules press y");
                        if (currState.xJustPressed) {
                            System.out.println("Great now press y and lets get started");
                            if (currState.yJustPressed) {
                                intro = true;
                                Blackjack.start = true;
                                Blackjack.gameBegan = true;
                            }
                        }
                        if (currState.yJustPressed) {
                            understand = false;
                        }
                    }
                }

                if (Blackjack.start == true && Blackjack.gameBegan == true) {
                    System.out.println("The cards are now being dealt.");
                    Blackjack.dealCards(player1, player2);
                    System.out.println(player1.getPoints());
                    while (player1.getPoints() <= 21 && player2.getPoints() <= 21) {
                        System.out.println(player2.getPoints());
                        System.out.println("Your total so far is" + player1.getPoints() + "If you would like to hit press x if you would like to stay press y");
                        if (currState.xJustPressed) {
                            Blackjack.hit1 = true;
                        }
                        if (currState.yJustPressed) {
                            player1.getPoints();
                        }
                        System.out.println("It is now Jack's turn") {
                            if (player2.getPoints() <= 16) {
                                System.out.println("I will hit");
                                Blackjack.hit2 = true;
                            }
                            if (player2.getPoints() > 17) {
                                System.out.println("I will stay");
                                player2.getPoints();
                            }
                            System.out.println("You currently have" + player1.getPoints());
                            System.out.println("Your opponent currently has" + player2.getPoints());
                        }
                    }

                    System.out.println("GAME OVER");
                    Blackjack.gameBegan = false;
                }


                while (Blackjack.gameBegan == false) {
                    if (player1.getPoints() <= 21) {
                        System.out.println("You win"){
                            player1.getNumberOfWins += 1;
                        }
                    }
                    if (player2.getPoints() <= 21) {
                        System.out.println("You Lose");
                    }
                    System.out.println("Press x to play again, y to end the game, b to clear win history");
                    if (currState.xJustPressed) {
                        Blackjack.gameBegan = true;
                    }
                    if (currState.yJustPressed) {
                        System.out.println("THE END");
                    }
                }
            }
        }
    }





