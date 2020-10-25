package com.company;
import com.studiohartman.jamepad.ControllerManager;
import com.studiohartman.jamepad.ControllerState;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("player");
        Player player2 = new Player("Jack"); //Notice this is also asking the player for their name, maybe we can find a way to prevent this?
        Blackjack game = new Blackjack();
        Controller.controllers.initSDLGamepad(); //I'll explain in person why I moved this here and how the Controller is working
        boolean gameActive = true; //We need a way to keep the game running until the user chooses to quit it themselves
        System.out.println("X for blackjack, Y for win count, Start to quit");
        while(gameActive) { //Using the variable we just made in Line 13
            ControllerState currState = Controller.controllers.getState(0); //Notice we are calling the static ControllerManager object from the new class.
            if(currState.xJustPressed)
            game.blackJackIntro(player1,player2); //We need to make sure we bring the two players with us into the blackjack game!
            else if(currState.yJustPressed)
                System.out.println(player1.getNumberOfWins() + " total wins");
            else if(currState.startJustPressed) {
                System.out.println("Later alligator");
                gameActive = false;
            }
        }
        }
    }





