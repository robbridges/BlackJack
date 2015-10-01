package com.company;

import CardGenerator.Card;
import CardGenerator.DeckMaker;
import PlayerGenerator.Dealer;
import PlayerGenerator.Player;
import PlayerGenerator.Player1;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by Robert on 9/26/2015.
 */
public class Play {


    public int score;
    private ArrayList<Card> cardDeck;
    private Card card;
    private Card dealerFaceDown;
    private Dealer dealer = new Dealer();
    private Player1 inputPlayer = new Player1();
    private Player1 player1 = inputPlayer.returnPlayer();
    String playerAnswer;
    String acceptableAnswer;
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(isr);
    Scanner scnr;





    public void playGame(ArrayList cardDeck) {
        dealCards(cardDeck, 0);
        dealCards(cardDeck, 1);
        dealDealerFaceDown(cardDeck);
        if (hasWon(dealer)) {
            System.out.println("The dealer shows 21, you lose this hand.");
        }
        dealCards(cardDeck,3);
        if (hasWon(player1)) {
            System.out.println("WINNER WINNER CHICKEN DINNER!");
        }



    }



    public void dealCards(ArrayList<Card> cardDeck, int turnNumber) {
        card = cardDeck.get(turnNumber);

        if (isEven(turnNumber)) {
            System.out.printf("Dealer is dealt %s of %s \n", card.getValue(), card.getSuit());
            dealer.addCardsToHand(card);
            score = dealer.setCurrentScore(card);
            if (dealer.isDealtAce(card)) {
                selectAceValue(dealer);
            }
            cardDeck.remove(card);
            System.out.printf("Dealer currently sits at %d \n", getCurrentScore(dealer));
        }
        else {
            System.out.printf("%s is dealt %s of %s \n",player1.getmName(), card.getValue(), card.getSuit());
            player1.addCardsToHand(card);
            score = player1.setCurrentScore(card);
            if (player1.isDealtAce(card)) {
                selectAceValue(player1);
            }
            cardDeck.remove(card);
            System.out.printf("%s currently sits at %d  \n",player1.getmName(), getCurrentScore(player1));

        }






    }
    public void dealDealerFaceDown(ArrayList<Card> cardDeck) {
        card = cardDeck.get(2);
        dealer.addCardsToHand(card);
        score = dealer.setCurrentScore(card);
        System.out.println("The dealer deals himself a face-down Card");
        cardDeck.remove(card);
    }

    public boolean isEven(int turnNumber) {

        if (turnNumber % 2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public int selectAceValue(Player player)  {

        acceptableAnswer = "1 11";
        try(InputStreamReader isr2 = new InputStreamReader(System.in);
            BufferedReader reader2 = new BufferedReader(isr2)) {
            System.out.printf("%s is dealt an ace! do you want the value to be 1 or 11\n", player.getmName());
            playerAnswer = reader2.readLine();
            while(!acceptableAnswer.contains(playerAnswer)) {
                System.out.println("Sorry that answer is not accepted, please try again");
                playerAnswer = reader2.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (playerAnswer.equalsIgnoreCase("1")) {
            player.setAceDevalueCount(1);
            System.out.printf("%s has devalued the ace to 1 \n",player.getmName());
            score -= 10;
        }
        return player.getAceDevalueCount();
    }



   public int getCurrentScore(Player player) {
      return score;
   }

   public boolean hasWon(Player player) {
       if (getCurrentScore(player) == 21) {
           return true;
       }
       else {
           return false;
       }
   }
}
