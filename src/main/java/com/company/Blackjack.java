package com.company;

import com.studiohartman.jamepad.ControllerState;

import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Blackjack {
static boolean gameBegan = false;
static boolean start = false;
boolean fairness;
boolean dealing = false;
boolean gameOver = false;
boolean hit1 = false;
boolean hit2 = false;

        public void playAGame(Player player1, Player player2) {
            System.out.println("The cards are now being dealt.");
            Blackjack.dealCards(player1, player2);
            System.out.println(player1.getPoints());
            while (player1.getPoints() <= 21 && player2.getPoints() <= 21) {
                ControllerState currState = Controller.controllers.getState(0);
                System.out.println(player2.getPoints());
                System.out.println("Your total so far is" + player1.getPoints() + "If you would like to hit press x if you would like to stay press y");
                if (currState.xJustPressed) {
                    hit1 = true; //We can directly access hit1 since it is inside the class this method is being written in, no need to try and use Blackjack.hit1
                }
                if (currState.yJustPressed) {
                    player1.getPoints();
                }
                System.out.println("It is now Jack's turn");
                    if (player2.getPoints() <= 16) {
                        System.out.println("I will hit");
                        hit2 = true; //We can directly access hit1 since it is inside the class this method is being written in, no need to try and use Blackjack.hit2
                    }
                    if (player2.getPoints() > 17) {
                        System.out.println("I will stay");
                        player2.getPoints();
                    }
                    System.out.println("You currently have" + player1.getPoints());
                    System.out.println("Your opponent currently has" + player2.getPoints());

            }

            System.out.println("GAME OVER");
            Blackjack.gameBegan = false;
        }

        public void blackJackIntro(Player player1, Player player2) { //The parameters will let us access and manipulate the two player objeccts you created in Main!
            System.out.println("I challange you to a game of black jack! Press start if you accept this challange.");
            boolean intro = true;
            while (intro == true) {
                ControllerState currState = Controller.controllers.getState(0);
                if (currState.startJustPressed) {
                    System.out.println("Then prepare to taste defeat");
                    System.out.println("Do you know how to play black jack? If so press x if not press y.");
                    boolean waitingForResponse = true;
                    while (waitingForResponse) { //Even need another while here. Why? The if statement will happen to fast and bring us back to the start of this method otherwise!
                        currState = Controller.controllers.getState(0); //We need to get ready for another key being pressed on the controller
                        if (currState.xJustPressed) {
                            System.out.println("GOOD! Press y to begin!");
                            while (waitingForResponse) { //Same idea...if we don't put a while here, the below code will run too quickly before a player has a chance to respond
                                currState = Controller.controllers.getState(0); //We need to get ready for another key being pressed on the controller
                                if (currState.yJustPressed) {
                                    intro = false;
                                    Blackjack.start = true;
                                    Blackjack.gameBegan = true;
                                    System.out.println("START!");
                                    playAGame(player1,player2); //We are taking the two player objects from Main and now bringing them into the "main game"
                                }
                            }
                        }
                                else if (currState.yJustPressed) {
                                    blackJackHowtoPlay(); //So we can call the method that shows you how to play - how kind of you to include!
                                }
                            }
                        }

                    }
                }

        public void blackJackHowtoPlay() {
            boolean understand = false;
            System.out.println("WHAT YOU DON'T KNOW HOW TO PLAY BLACK JACK!? WHY WOULD YOU CHALLENGE ME, THE BEST BLACK JACKER IN THE WORLD, IF YOU CANNOT PLAY BLACK JACK!");
            while (understand == false) {
                ControllerState currState = Controller.controllers.getState(0);
                System.out.println("The rules are simple. You will start with two card. The goal is to have all of your cards add up to 21 first. If you get to 21 first you win," +
                        " if I get to 21 first I win. If either of us go over 21 the other one wins be default. Press a to hit, this will give you another card and press b to stay.");
                understand = true;
                System.out.println("If you understand press x. If you need me to repeat the rules press y");
                if (currState.xJustPressed) {
                    System.out.println("Great now press y and lets get started");
                    if (currState.yJustPressed) {

                    }
                }
                if (currState.yJustPressed) {
                    blackJackHowtoPlay(); //If the player doesn't undersatnd, we can call this block of code to explain it again to them!
                }
            }
        }
   public static void dealCards(Player player1,Player player2){
                if(player1.getPlayStatus() == 1){
                        int theCards = (int)( Math.random()+1 *12);
                        player1.addPoints(theCards);
                        player1.addPoints(theCards);

                    player2.addPoints(theCards);
                    player2.addPoints(theCards);
                }

        }
        public boolean checkIfBust(Player playerToCheck) {
                if(playerToCheck.getPoints() > 21){ //You were using player1, but notice the player object being passed into this method has a label called playerToCheck
                gameOver = true;
                return true;
                }
                /*
                if(player2.getPoints > 21){ This method only lets us check one player at a time, so we have to call this method twice. Once for each player being passed into the method.
                        gameOver = true;
                        return true;
                }*/
            return false; //If player isn't over 21, then they haven't busted yet
        }

        public void showPointTotal(Player player1, Player player2) {
        player1.getPoints();
        player2.getPoints();
        }

        public void playerAskHitOrStay(Player player1) {
            if(hit1 == true){
                player1.addPoints(10); //For now I just put in a value but we want to eventually use Math.random() to calculate it
            }
        }

        public void player2HitOrStay(Player player2) {
            if(hit2 == true){
                player2.addPoints(10); //Similar idea to method above it.
            }
        }



}
