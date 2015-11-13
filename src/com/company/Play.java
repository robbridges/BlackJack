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
    Dealer dealer = new Dealer();
    Player1 inputPlayer = new Player1();
    Player1 player1 = inputPlayer.returnPlayer();
    private String playerAnswer;
    private String acceptableAnswer;
    public Boolean continueToPlay = false;
    public boolean isHandOver = true;
    boolean gameInprogress = true;


    public void playGame(ArrayList cardDeck) {
        while (gameInprogress) {
        dealCards(cardDeck,dealer);
        dealCards(cardDeck,player1);
        dealDealerFaceDown(cardDeck);

            if (hasWon(dealer)) { // check to see player parameter has won
                System.out.println("The dealer shows 21, you lose this hand.");
                deductFromBank(player1);
            }
            dealCards(cardDeck, player1);
            if (hasWon(player1)) {
                System.out.println("WINNER WINNER CHICKEN DINNER!");



            }
            playerAction(cardDeck, player1);
            dealerDecision(cardDeck, dealer);
            if (!hasBusted(player1)) {
                System.out.printf("Dealer shows %d \n", dealer.getCurrentScore());
            }
            hasBeatDealer(player1, dealer);
            continueToNextHand();
        }

    }

    public void dealCards(ArrayList<Card> cardDeck, Player player) {

            cardIterator = cardDeck.listIterator();
            card = cardIterator.next();
            System.out.printf("%s is dealt the %s of %s \n", player.getmName(), card.getValue(), card.getSuit());
            player.addCardsToHand(card); // add card to personal player hand
            score = player.tallyCurrentScore(card);
            if (player.isDealtAce(card)) {
                selectAceValue(player);
            }
            cardDeck.remove(card); // remove the card from the deck so it cannot be dealt again by a odd bug
            System.out.printf("%s currently sits at %d \n", player.getmName(),
                    player.getCurrentScore());// display current player score

    }


    public boolean hasBusted(Player player) {
        if (player.getCurrentScore() > 21) { // check to see if current player has gone over 21
            return true;
        } else {
            return false;
        }
    }


    public void dealDealerFaceDown(ArrayList<Card> cardDeck) {
        cardIterator = cardDeck.listIterator();
        card = cardIterator.next();
        dealer.addCardsToHand(card);
        score = dealer.tallyCurrentScore(card);
        System.out.println("The dealer deals himself a face-down Card");
        cardDeck.remove(card);
    }
    public void dealPlayerFirstCard(Player player, ArrayList<Card> cardDeck) {
        cardIterator = cardDeck.listIterator();
        card = cardIterator.next();
        score = player.tallyCurrentScore(card);
        player.addCardsToHand(card);
        System.out.printf("%s is dealt the %s of %s \n", player.getmName(), card.getValue(), card.getSuit());
        player.addCardsToHand(card); // add card to personal player hand
        if (player.isDealtAce(card)) {
            selectAceValue(player);
        }
        cardDeck.remove(card); // remove the card from the deck so it cannot be dealt again by a odd bug
        System.out.printf("%s currently sits at %d \n", player.getmName(),
                player.getCurrentScore());// display current player score
    }

    public void selectAceValue(Player player) {
        score = player.getCurrentScore();
        if (!player.isDealer() && player.isDealtAce(card)) {

            acceptableAnswer = "1 11";
            try {
                BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
                System.out.printf("%s is dealt an ace! do you want the value to be 1 or 11\n", player.getmName());
                playerAnswer = reader2.readLine();
                while (!acceptableAnswer.contains(playerAnswer)) {
                    System.out.println("Sorry that answer is not accepted, please try again");
                    playerAnswer = reader2.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (playerAnswer.equalsIgnoreCase("1")) {

                System.out.printf("%s has devalued the ace to 1 \n", player.getmName());
                player.setCurrentScore(player.getCurrentScore() - 10);
            }

        }

    }

    public int getScore() {
        return score;
    }

    public boolean hasWon(Player player) {
        if (player.getCurrentScore() == 21) {
            //continueToNextHand();
            isHandOver = true;
            return true;

        } else {
            return false;
        }
    }

    public void playerAction(ArrayList<Card> cardDeck, Player player) {

            cardIterator = cardDeck.listIterator();
            card = cardIterator.next();
            acceptableAnswer = "yes no YES NO";
            playerAnswer = "";

            while (!playerAnswer.equalsIgnoreCase("no") ||
                    !player.getmName().equalsIgnoreCase("dealer")) {


                System.out.printf("%s currently sits at a score of %s, do you want to have another card?",
                        player1.getmName(), player.getCurrentScore());
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
                    if (hasWon(player)) {
                        System.out.printf("You win!!");
                        break;
                    }
                    else if (hasBusted(player)) {
                        System.out.printf("Sorry %s, you have busted \n", player.getmName());
                        break;
                    }
                } else {
                    System.out.printf("Very well %s, your final score is %d let's see how the dealer does \n",
                            player.getmName(), player.getCurrentScore());
                    break;

                }

            }
        }






    public boolean hasBeatDealer(Player player, Dealer dealer) {
        if ((player.getCurrentScore() > dealer.getCurrentScore() && !hasBusted(player))) {
            System.out.printf("%s wins with a score of %d \n", player.getmName(), player.getCurrentScore());
            addtoBank(player);
            isHandOver = true;
            //continueToNextHand();
            return true;
        } else if (hasBusted(player)) {

            deductFromBank(player);
            //continueToNextHand();
            return false;
        }
        else if (dealer.getCurrentScore() > player.getCurrentScore() && !hasBusted(dealer)) {
            System.out.printf("Sorry %s, the dealer shows %d \n", player.getmName(), dealer.getCurrentScore());
            deductFromBank(player);
            return false;
        }
        else if (player.getCurrentScore() == dealer.getCurrentScore()) {
            System.out.println("Tie goes to the house \n");
            deductFromBank(player);
            return false;
        }
        else if (hasBusted(dealer)) {
            System.out.printf("The dealer has busted, you have won \n");
            addtoBank(player);
            return true;
        }
        else {
            System.out.println("You should not be seeing this message, please contact monkey tech support \n");
            return false; // SHOULD NEVER RUN!!
        }
    }


    public void dealerDecision(ArrayList<Card> cardDeck, Dealer dealer) {
        cardIterator = cardDeck.listIterator();
        card = cardIterator.next();


            while (dealer.continueToDraw()) {
                if(hasBusted(player1)) {
                    break;
                }
                dealCards(cardDeck, dealer);
                if (hasBusted(dealer)) {
                    System.out.println("The dealer took toomany cards");
                    break;
                }
            }
        }




    public void addtoBank(Player player) {
        if (player.getCurrentScore() == 21) {
            player.setBankCount(player.getBankCount() + 30);
            System.out.printf("Congratulations %s, you have won and your current chip count is %d \n",
                    player.getmName(), player.getBankCount());

        }
        else {
            player.setBankCount(player.getBankCount() + 10);
            System.out.printf("Congratulations %s, you have won and your current chip count is %d \n",
                    player.getmName(), player.getBankCount());

        }

    }

    public void deductFromBank(Player player) {
        player.setBankCount(player.getBankCount() - 10);
        System.out.printf("Sorry %s you have lost, and your current ship count is %d \n ",
                player.getmName(), player.getBankCount());



    }

    public void continueToNextHand() {
        player1.setCurrentScore(0);
        player1.emptyHand();
        dealer.setCurrentScore(0);
        dealer.emptyHand();
        continueToPlay();
    }

    public boolean continueToPlay() {
        String acceptAbleAnswer = "yes YES no NO";
        String continueAnswer = "";
        while (!continueAnswer.contains(acceptAbleAnswer)) {
            System.out.printf("%s, do you want to play again? \n", player1.getmName());
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                continueAnswer = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (continueAnswer.equalsIgnoreCase("yes")) {
                System.out.printf("very well, let's continue to the next hand \n");
                continueToPlay = true;
                break;
            }
            else if (continueAnswer.equalsIgnoreCase("no")) {
                System.out.println("Very well, some other time");
                continueToPlay = false;
                gameInprogress = false;
                System.exit(0);
            }
            else {
                System.out.println("sorry, please choose yes or no.");
            }

        }
        return continueToPlay;
    }

}



