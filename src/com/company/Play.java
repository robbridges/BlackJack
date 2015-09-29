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

/**
 * Created by Robert on 9/26/2015.
 */
public class Play {

    private int mPlayerScore;
    private int mDealerScore;
    private ArrayList<Card> cardDeck;
    private Card card;
    private Card dealerFaceDown;
    private Dealer dealer = new Dealer();
    private Player1 inputPlayer = new Player1();
    private Player1 player1 = inputPlayer.returnPlayer();
    String playerAnswer;
    String acceptableAnswer;
    int aceValue;


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
            mDealerScore +=dealer.setCurrentScore(dealer.getDealerCards());
            /*if (dealer.isDealtAce(card)) {
                selectAce(dealer);
            }*/
            cardDeck.remove(card);
            System.out.printf("Dealer currently sits at %d \n", getmDealerScore());
        }
        else {
            System.out.printf("%s is dealt %s of %s \n",player1.getmName(), card.getValue(), card.getSuit());
            player1.addCardsToHand(card);
            mPlayerScore += player1.setCurrentScore(player1.getPlayer1CardList());
            /*if (player1.isDealtAce(card)) {
                selectAce(player1);
            }*/
            cardDeck.remove(card);
            System.out.printf("%s currently sits at %d \n",player1.getmName(), getmPlayerScore());

        }






    }
    public void dealDealerFaceDown(ArrayList<Card> cardDeck) {
        card = cardDeck.get(2);
        dealer.addCardsToHand(card);
        mDealerScore += dealer.setCurrentScore(dealer.getDealerCards());
        //if (dealer.isDealtAce(card)) {
            //selectAce(dealer);
        //}
        cardDeck.remove(card);
        System.out.println("The dealer deals himself a face-down Card");
    }

    public boolean isEven(int turnNumber) {

        if (turnNumber % 2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /*public int SelectAceValue(Player player) {
        acceptableAnswer= "1 11";
        if (player.isDealtAce(card)) {
            System.out.printf("%s player is dealt ace do you want the value to be one or zero?", player.getmName());
            while (!playerAnswer.contains(acceptableAnswer)) {
                playerAnswer =reader.readLine();
                if (!playerAnswer.contains(acceptableAnswer)) {
                    System.out.println("That is not an acceptable answer please choose 1 or 11");
                }
            }
            if (playerAnswer.equalsIgnoreCase("1")) {
                player.returnCurrentScore() -= 10;

            }

        }
    }*/

    public boolean hasWon(Player player) {
        if (player.returnCurrentScore() == 21) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isDealtAce(Card card) {
        if (card.getValue().toString().equalsIgnoreCase("ACE")) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getmPlayerScore() {
        return mPlayerScore;
    }

    public void setmPlayerScore(int mPlayerScore) {
        this.mPlayerScore = mPlayerScore;
    }

    public int getmDealerScore() {
        return mDealerScore;
    }

    public void setmDealerScore(int mDealerScore) {
        this.mDealerScore = mDealerScore;
    }
}
