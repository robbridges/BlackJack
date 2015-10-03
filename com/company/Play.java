package com.company;

import CardGenerator.Card;
import PlayerGenerator.Dealer;
import PlayerGenerator.Player1;


import java.util.ArrayList;

/**
 * Created by Robert on 9/26/2015.
 */
public class Play {

    private int mPlayerScore;
    private int mDealerScore;
    ArrayList<Card> cardDeck;
    Card card;
    Card dealerFaceDown;
    Dealer dealer = new Dealer();
    Player1 inputPlayer = new Player1();
    Player1 player1 = inputPlayer.returnPlayer();


    public void playGame(ArrayList cardDeck) {
        dealCards(cardDeck, 0);
        dealCards(cardDeck, 1);
        dealDealerFaceDown(cardDeck);
        if (dealer.hasWon()) {
            System.out.println("The dealer shows 21, you lose this hand.");
        }
        dealCards(cardDeck,3);
        if (player1.hasWon()) {
            System.out.println("WINNER WINNER CHICKEN DINNER!");
        }



    }



    public void dealCards(ArrayList<Card> cardDeck, int turnNumber) {
        card = cardDeck.get(turnNumber);

        if (isEven(turnNumber)) {
            System.out.printf("Dealer is dealt %s of %s \n", card.getValue(), card.getSuit());
            dealer.addCardsToHand(card);
            mDealerScore += dealer.tallyCurrentScore(dealer.getDealerCards());
            cardDeck.remove(card);
            System.out.printf("Dealer currently sits at %d \n", getmDealerScore());
        }
        else {
            System.out.printf("%s is dealt %s of %s \n",player1.getmName(), card.getValue(), card.getSuit());
            player1.addCardsToHand(card);
            mPlayerScore += player1.tallyCurrentScore(player1.getPlayer1CardList());
            cardDeck.remove(card);
            System.out.printf("%s currently sits at %d \n",player1.getmName(), getmPlayerScore());

        }






    }
    public void dealDealerFaceDown(ArrayList<Card> cardDeck) {
        card = cardDeck.get(2);
        dealer.addCardsToHand(card);
        mDealerScore += dealer.tallyCurrentScore(dealer.getDealerCards());
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



    public int getvalue() {
        String cardValue = card.getValue().toString();
        int cardNumericalValue = 0;
        switch (cardValue) {
            case "ONE": cardNumericalValue = 1;
                break;
            case "TWO": cardNumericalValue = 2;
                break;
            case "THREE": cardNumericalValue = 3;
                break;
            case "FOUR": cardNumericalValue = 4;
                break;
            case "FIVE": cardNumericalValue = 5;
                break;
            case "SIX": cardNumericalValue = 6;
                break;
            case "SEVEN": cardNumericalValue = 7;
                break;
            case "EIGHT": cardNumericalValue = 8;
                break;
            case "NINE": cardNumericalValue = 9;
                break;
            case "TEN": cardNumericalValue = 10;
                break;
            case "JACK": cardNumericalValue = 10;
                break;
            case "QUEEN": cardNumericalValue = 10;
                break;
            case "KING": cardNumericalValue = 10;
                break;
            case "ACE": cardNumericalValue = 11;
                break;
            default: break;

        }
        return cardNumericalValue;
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
