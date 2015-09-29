package com.company;


import CardGenerator.Card;
import CardGenerator.DeckMaker;


import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        DeckMaker deck =new DeckMaker().createDeck();
        ArrayList<Card> cardDeck = deck.getDeck();
        Play game = new Play();


        game.playGame(cardDeck);

    }
}
