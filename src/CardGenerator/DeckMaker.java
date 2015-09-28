package CardGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Robert on 9/26/2015.
 */
public class DeckMaker {
    private DeckMaker deck;
    private ArrayList<Card> cardDeck;
    Card card;
    CardValue value;
    CardSuit suit;

    public DeckMaker createDeck() {
        deck = new DeckMaker();
        cardDeck = new ArrayList<Card>();
        for (CardValue value: CardValue.values()) {
            for (CardSuit suit : CardSuit.values()) {
                //System.out.printf("The %s of %s \n", value.getValue(), suit.getSuit());
                card = new Card(value,suit);
                this.cardDeck.add(card);
            }

        }
        Collections.shuffle(cardDeck);
        return deck;
    }

    public void showDeck() {
        if (deck == null) {
            deck = createDeck();
        }
        for (Card card : cardDeck) {
            System.out.printf("the %s of %s \n", card.getValue(), card.getSuit());
        }
    }

    public ArrayList<Card> getDeck() {
        cardDeck = new ArrayList<Card>();
        for (CardValue value: CardValue.values()) {
            for (CardSuit suit : CardSuit.values()) {
                //System.out.printf("The %s of %s \n", value.getValue(), suit.getSuit());
                card = new Card(value,suit);
                this.cardDeck.add(card);
            }

        }
        Collections.shuffle(cardDeck);
        return cardDeck;

    }






}
