package com.company;

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
            if(gameBegan == true && start == true){
                    System.out.println("THE GAME HAS BEGUN");
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
                if(player1.getPoints > 21){
                gameOver = true;
                return true;
                }
                if(player2.getPoints > 21){
                        gameOver = true;
                        return true;
                }
        }

        public void showPointTotal(Player player1, Player player2) {
        player1.getPoints();
        player2.getPoints();
        }

        public void playerAskHitOrStay(Player player1) {
            if(hit1 == true){
                player1.addPoints;
            }
        }

        public void player2HitOrStay(Player player2) {
            if(hit2 == true){
                player2.addPoints;
            }
        }
    }
