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
import java.util.Queue;


/**
 * Created by Robert on 9/26/2015.
 */
public class Play {


    public int score;
    private ArrayList<Card> cardDeck;
    private Queue<Card> cardQueue;
    private Card card;
    private Card dealerFaceDown;
    private Dealer dealer = new Dealer();
    private Player1 inputPlayer = new Player1();
    private Player1 player1 = inputPlayer.returnPlayer();
    String playerAnswer;
    String acceptableAnswer;






    public void playGame(ArrayList cardDeck) {
        dealCards(cardDeck, 0, dealer);
        dealCards(cardDeck, 1, player1);
        dealDealerFaceDown(cardDeck);
        if (hasWon(dealer)) { // check to see player parameter has won
            System.out.println("The dealer shows 21, you lose this hand.");
        }
        dealCards(cardDeck,3, player1);
        if (hasWon(player1)) {
            System.out.println("WINNER WINNER CHICKEN DINNER!");
        }




    }

    public void dealCards(ArrayList<Card> cardDeck, int turnNumber, Player player) {
        card = cardDeck.get(turnNumber);
        System.out.printf("%s is dealt the %s of %s \n", player.getmName(), card.getValue(), card.getSuit());
        player.addCardsToHand(card); // add card to personal player hand
        score = player.setCurrentScore(card);
        if (player.isDealtAce(card)) {
            selectAceValue(player);
        }
        cardDeck.remove(card); // remove the card from the deck so it cannot be dealt again by a odd bug
        System.out.printf("%s currently sits at %d \n", player.getmName(), getScore()); // display current player score
        if (hasBusted(player)) {
            System.out.printf("%s has busted!! \n", player.getmName()); // if score > 21
        }
    }

    public boolean hasBusted(Player player) {

        if (player.getCurrentScore() > 21) { // check to see if current player has gone over 21
            return true;
        }
        else {
            return false;
        }
    }



    public void dealDealerFaceDown(ArrayList<Card> cardDeck) {
        card = cardDeck.get(2);
        dealer.addCardsToHand(card);
        score = dealer.setCurrentScore(card);
        System.out.println("The dealer deals himself a face-down Card");
        cardDeck.remove(card);
    }
    public void selectAceValue(Player player)  {
        score = player.getCurrentScore();

        acceptableAnswer = "1 11";
        try( InputStreamReader isr2 = new InputStreamReader(System.in);
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

            System.out.printf("%s has devalued the ace to 1 \n",player.getmName());
            score -= 10;
        }

    }

    public int getScore() {
        return score;
    }

    public boolean hasWon(Player player) {
       if (player.getCurrentScore() == 21) {
           return true;
       }
       else {
           return false;
       }
    }

    public boolean isDealer(Player player) {
        if (player.getmName() == "dealer") {
            return true;
        }
        else {
            return false;
        }

    }
}



