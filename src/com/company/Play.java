package com.company;

import CardGenerator.Card;
import PlayerGenerator.Dealer;
import PlayerGenerator.Player;
import PlayerGenerator.Player1;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by Robert on 9/26/2015.
 */
public class Play {


    public int score;
    private ArrayList<Card> cardDeck;
    private Iterator<Card> cardIterator;
    private Card card;
    private Card dealerFaceDown;
    private Dealer dealer = new Dealer();
    private Player1 inputPlayer = new Player1();
    private Player1 player1 = inputPlayer.returnPlayer();
    String playerAnswer;
    String acceptableAnswer;







    public void playGame(ArrayList cardDeck) {
        dealCards(cardDeck,  dealer);
        dealCards(cardDeck,  player1);
        dealDealerFaceDown(cardDeck);
        if (hasWon(dealer)) { // check to see player parameter has won
            System.out.println("The dealer shows 21, you lose this hand.");
        }
        dealCards(cardDeck, player1);
        if (hasWon(player1)) {
            System.out.println("WINNER WINNER CHICKEN DINNER!");
        }
        playerAction(cardDeck,player1);




    }

    public void dealCards(ArrayList<Card> cardDeck,  Player player) {
        cardIterator = cardDeck.listIterator();
        card = cardIterator.next();
        System.out.printf("%s is dealt the %s of %s \n", player.getmName(), card.getValue(), card.getSuit());
        player.addCardsToHand(card); // add card to personal player hand
        score = player.tallyCurrentScore(card);
        if (player.isDealtAce(card)) {
            selectAceValue(player);
        }
        cardDeck.remove(card); // remove the card from the deck so it cannot be dealt again by a odd bug
        System.out.printf("%s currently sits at %d \n", player.getmName(), player.getCurrentScore()); // display current player score
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
        score = dealer.tallyCurrentScore(card);
        System.out.println("The dealer deals himself a face-down Card");
        cardDeck.remove(card);
    }
    public void selectAceValue(Player player)  {
        score = player.getCurrentScore();

        acceptableAnswer = "1 11";
        try  {
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
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
            player.setCurrentScore(player.getCurrentScore() - 10);
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

    public void playerAction(ArrayList<Card> cardDeck, Player player) {

        cardIterator = cardDeck.listIterator();
        card = cardIterator.next();
        acceptableAnswer = "yes no YES NO";
        playerAnswer = "";
        while (!playerAnswer.equalsIgnoreCase("no")) {
        System.out.printf("%s currently sits at a score of %s, do you want to have another card?",
                player1.getmName(), getScore());
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                playerAnswer = reader.readLine();

                if (!acceptableAnswer.contains(playerAnswer)) {
                    System.out.println("Sorry please choose yes or no");
                    playerAnswer = reader.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            if (playerAnswer.equalsIgnoreCase("yes")) {
                dealCards(cardDeck, player);
            } else {
                System.out.printf("Very well %s, your final score is %d let's see how the dealer does",
                        player.getmName(), getScore());
            }
        }
    }



    public void dealerDecision() {


    }
}



