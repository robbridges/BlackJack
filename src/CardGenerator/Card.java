package CardGenerator;

/**
 * Created by Robert on 9/26/2015.
 */
public class Card {

    private CardSuit suit;
    private CardValue value;

    public Card(CardValue value, CardSuit suit) {
        this.value= value;
        this.suit = suit;

    }


    public CardSuit getSuit() {
        return suit;
    } // returns the suit of the card


    public CardValue getValue() {
        return value;
    } // returns the value of the card, 2 through ace(11)


}
