package com.company;


import CardGenerator.Card;
import CardGenerator.DeckMaker;
import PlayerGenerator.Dealer;
import PlayerGenerator.Player1;
import com.company.Play;


import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        DeckMaker deck =new DeckMaker().createDeck();
        ArrayList<Card> cardDeck = deck.getDeck();
        Play game = new Play();

        game.playGame(cardDeck);
        while (game.continueToPlay) {
                game.playGame(cardDeck);
            }
        }

    }

